package com.baidu.tieba.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tieba.data.Config;
/* loaded from: classes.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, Config.PHONE_DATEBASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE cash_data(type int,account varchar(30),data TEXT)");
        } catch (Exception e) {
            TiebaLog.e("DatabaseHelper", "onCreate", "error = CREATE TABLE cash_data");
        }
        try {
            db.execSQL("CREATE TABLE account_data(id,account,password,bduss,isactive int,tbs,time)");
        } catch (Exception e2) {
            TiebaLog.e("DatabaseHelper", "onCreate", "error = CREATE TABLE account_data");
        }
        try {
            db.execSQL("CREATE TABLE search_data(key, account, time)");
        } catch (Exception e3) {
            TiebaLog.e("DatabaseHelper", "onCreate", "error = CREATE TABLE search_data");
        }
        try {
            db.execSQL("CREATE TABLE mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum)");
        } catch (Exception e4) {
            TiebaLog.e("DatabaseHelper", "onCreate", "error = CREATE TABLE mark_data");
        }
        try {
            db.execSQL("CREATE TABLE draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
        } catch (Exception e5) {
            TiebaLog.e("DatabaseHelper", "onCreate", "error = CREATE TABLE draft_box");
        }
        try {
            db.execSQL("CREATE TABLE setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch)");
        } catch (Exception e6) {
            TiebaLog.e("DatabaseHelper", "onCreate", "error = CREATE TABLE setting");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        try {
            db.execSQL("DROP TABLE IF EXISTS cash_data");
        } catch (Exception e) {
            TiebaLog.e("DatabaseHelper", "onUpgrade", "error = DROP TABLE cash_data");
        }
        try {
            db.execSQL("DROP TABLE IF EXISTS account_data");
        } catch (Exception e2) {
            TiebaLog.e("DatabaseHelper", "onUpgrade", "error = DROP TABLE account_data");
        }
        try {
            db.execSQL("DROP TABLE IF EXISTS search_data");
        } catch (Exception e3) {
            TiebaLog.e("DatabaseHelper", "onUpgrade", "error = DROP TABLE search_data");
        }
        try {
            db.execSQL("DROP TABLE IF EXISTS mark_data");
        } catch (Exception e4) {
            TiebaLog.e("DatabaseHelper", "onUpgrade", "error = DROP TABLE mark_data");
        }
        try {
            db.execSQL("DROP TABLE IF EXISTS draft_box");
        } catch (Exception e5) {
            TiebaLog.e("DatabaseHelper", "onUpgrade", "error = DROP TABLE draft_box");
        }
        try {
            db.execSQL("DROP TABLE IF EXISTS setting");
        } catch (Exception e6) {
            TiebaLog.e("DatabaseHelper", "onUpgrade", "error = DROP TABLE draft_box");
        }
        onCreate(db);
    }
}
