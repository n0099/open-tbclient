package com.baidu.tieba.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
public class k extends SQLiteOpenHelper {
    public k(Context context) {
        super(context, "baidu_tieba.db", (SQLiteDatabase.CursorFactory) null, 8);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            av.a(3, getClass().getName(), "ExecSQL", str);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE if not exists cash_data(type int,account varchar(30),data TEXT)");
        a(sQLiteDatabase, "CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time)");
        a(sQLiteDatabase, "CREATE TABLE if not exists search_data(key, account, time)");
        a(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
        a(sQLiteDatabase, "CREATE TABLE if not exists mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum,subPost int,forumName varchar(30),forumId varchar(30),threadId varchar(30))");
        a(sQLiteDatabase, "CREATE TABLE if not exists draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
        a(sQLiteDatabase, "CREATE TABLE if not exists setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time varchar(30),nodisturb_end_time varchar(30))");
        a(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
        a(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
        c(sQLiteDatabase);
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "DROP TABLE IF EXISTS cash_data;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='cash_data';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS account_data;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='account_data';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS search_data;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='search_data';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS search_post_data;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='search_post_data';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS mark_data;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='mark_data';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS draft_box;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='draft_box';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS setting;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='setting';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS chunk_upload_data;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='chunk_upload_data';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS frs_image_forums;");
        a(sQLiteDatabase, "DROP INDEX IF EXISTS idx_c_msgs_of;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='frs_image_forums';");
        a(sQLiteDatabase, "DROP TABLE IF EXISTS chat_msgs;");
        a(sQLiteDatabase, "DROP INDEX IF EXISTS idx_c_rfs_ost;");
        a(sQLiteDatabase, "update sqlite_sequence SET seq=0 where name='chat_msgs';");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            try {
                a(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
            } catch (Exception e) {
                av.b(k.class.getName(), "onUpgrade", e.getMessage());
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                return;
            }
        }
        if (i < 3) {
            a(sQLiteDatabase, "ALTER TABLE mark_data ADD subPost int");
            a(sQLiteDatabase, "ALTER TABLE mark_data ADD forumName varchar(30)");
            a(sQLiteDatabase, "ALTER TABLE mark_data ADD forumId varchar(30)");
            a(sQLiteDatabase, "ALTER TABLE mark_data ADD threadId varchar(30)");
        }
        if (i < 4) {
            a(sQLiteDatabase, "ALTER TABLE setting ADD remind_tone");
        }
        if (i < 5) {
            a(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
        }
        if (i < 6) {
            a(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
        }
        if (i < 7) {
            c(sQLiteDatabase);
        }
        if (i < 8) {
            a(sQLiteDatabase, "ALTER TABLE setting ADD msg_chat_switch DEFAULT 1");
            a(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_switch");
            a(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_start_time varchar(30)");
            a(sQLiteDatabase, "ALTER TABLE setting ADD nodisturb_end_time varchar(30)");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    protected void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE if not exists chat_msgs(pk INTEGER primary key autoincrement, msgId bigint,ownerId varchar(32), friendId varchar(32), msgType int(11) default 0, status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
        a(sQLiteDatabase, "CREATE INDEX if not exists idx_c_msgs_of ON chat_msgs(ownerId, friendId, msgId)");
        a(sQLiteDatabase, "CREATE TABLE if not exists chat_recent_friends(pk varchar(64) primary key, unReadCount int(11) default 0 ,ownerId varchar(32), friendId varchar(32), ownerName varchar(64), friendName varchar(64), friendPortrait varchar(64), status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
        a(sQLiteDatabase, "CREATE INDEX if not exists idx_c_rfs_ost ON chat_recent_friends(ownerId, serverTime)");
    }
}
