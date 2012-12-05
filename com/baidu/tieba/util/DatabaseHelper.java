package com.baidu.tieba.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tieba.data.Config;
/* loaded from: classes.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, Config.PHONE_DATEBASE_NAME, (SQLiteDatabase.CursorFactory) null, 5);
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
        ExecSQL(db, "CREATE TABLE if not exists mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum,subPost int,forumName varchar(30),forumId varchar(30),threadId varchar(30))");
        ExecSQL(db, "CREATE TABLE if not exists draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
        ExecSQL(db, "CREATE TABLE if not exists setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone)");
        ExecSQL(db, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
        ExecSQL(db, "CREATE TABLE if not exists frs_image_forums(forum_name)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1) {
            ExecSQL(db, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
        }
        if (oldVersion < 3) {
            ExecSQL(db, "ALTER TABLE mark_data ADD subPost int");
            ExecSQL(db, "ALTER TABLE mark_data ADD forumName varchar(30)");
            ExecSQL(db, "ALTER TABLE mark_data ADD forumId varchar(30)");
            ExecSQL(db, "ALTER TABLE mark_data ADD threadId varchar(30)");
        }
        if (oldVersion < 4) {
            ExecSQL(db, "ALTER TABLE setting ADD remind_tone");
        }
        if (oldVersion < 5) {
            ExecSQL(db, "CREATE TABLE if not exists frs_image_forums(forum_name)");
        }
    }
}
