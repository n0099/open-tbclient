package com.baidu.tieba.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tieba.data.Config;
/* loaded from: classes.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, Config.PHONE_DATEBASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    private void ExecSQL(SQLiteDatabase db, String sql) {
        try {
            db.execSQL(sql);
        } catch (Exception e) {
            TiebaLog.log_e(3, getClass().getName(), "ExecSQL", sql);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    public void createTables(SQLiteDatabase db) {
        ExecSQL(db, "CREATE TABLE if not exists cash_data(type int,account varchar(30),data TEXT)");
        ExecSQL(db, "CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time)");
        ExecSQL(db, "CREATE TABLE if not exists search_data(key, account, time)");
        ExecSQL(db, "CREATE TABLE if not exists mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum)");
        ExecSQL(db, "CREATE TABLE if not exists draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
        ExecSQL(db, "CREATE TABLE if not exists setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch)");
        ExecSQL(db, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 0) {
            ExecSQL(db, "DROP TABLE IF EXISTS cash_data");
            ExecSQL(db, "DROP TABLE IF EXISTS account_data");
            ExecSQL(db, "DROP TABLE IF EXISTS search_data");
            ExecSQL(db, "DROP TABLE IF EXISTS mark_data");
            ExecSQL(db, "DROP TABLE IF EXISTS draft_box");
            ExecSQL(db, "DROP TABLE IF EXISTS setting");
            onCreate(db);
        }
        if (oldVersion == 1) {
            ExecSQL(db, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
        }
    }
}
