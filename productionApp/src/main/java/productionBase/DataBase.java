package productionBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

	public static void main(String[] args) {
		 final String sql = "SELECT * FROM pn";
		    
	   	 try(Connection c = DriverManager.getConnection("jdbc:sqlite:pnbase.db");
	   		 PreparedStatement stmt = c.prepareStatement(sql)) {
	   		 
	   		 try(ResultSet rs = stmt.executeQuery()) {
	   			 while(rs.next()) {
	   				 System.out.printf("* %-12s %-10s %-30s %3s %-5s\n",
	   						rs.getString("fg_id"),
	   						rs.getString("pn"),
	   					 rs.getString("Description"),
	   					 rs.getString("usege"),
	   					 rs.getString("unit"));
	   					 
	   			 }
	   		 }
	   	 } catch (SQLException e) {
	   		 e.printStackTrace();
	   	 }
	    }
	}