package com.baidu.tieba.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
public class y extends SQLiteOpenHelper {
    public y(Context context) {
        super(context, "baidu_tieba.db", (SQLiteDatabase.CursorFactory) null, 11);
    }

    public static void a(Context context) {
        context.deleteDatabase("baidu_tieba.db");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE if not exists cash_data(type int,account varchar(30),data TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int)");
            sQLiteDatabase.execSQL("CREATE TABLE if not exists search_data(key, account, time)");
            sQLiteDatabase.execSQL("CREATE TABLE if not exists search_post_data(key, account, time)");
            sQLiteDatabase.execSQL("CREATE TABLE if not exists mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum,subPost int,forumName varchar(30),forumId varchar(30),threadId varchar(30))");
            sQLiteDatabase.execSQL("CREATE TABLE if not exists draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
            sQLiteDatabase.execSQL("CREATE TABLE if not exists setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time varchar(30),nodisturb_end_time varchar(30))");
            sQLiteDatabase.execSQL("CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
            sQLiteDatabase.execSQL("CREATE TABLE if not exists frs_image_forums(forum_name)");
            c(sQLiteDatabase);
            d(sQLiteDatabase);
        } catch (Exception e) {
            cb.a(e, "DatabaseHelper.createTables", new Object[0]);
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cash_data;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='cash_data';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS account_data;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='account_data';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS search_data;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='search_data';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS search_post_data;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='search_post_data';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mark_data;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='mark_data';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS draft_box;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='draft_box';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS setting;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='setting';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chunk_upload_data;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='chunk_upload_data';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS frs_image_forums;");
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS idx_c_msgs_of;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='frs_image_forums';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_msgs;");
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS idx_c_rfs_ost;");
            sQLiteDatabase.execSQL("update sqlite_sequence SET seq=0 where name='chat_msgs';");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS user_emotions");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS emotion_group");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS emotions");
        } catch (Exception e) {
            cb.a(e, "DatabaseHelper.clearTables", new Object[0]);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(y.class.getName(), "onUpgrade", e.getMessage());
                cb.a(e, "DatabaseHelper.onUpdate", new Object[0]);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                return;
            }
        }
        if (i < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE mark_data ADD subPost int");
            sQLiteDatabase.execSQL("ALTER TABLE mark_data ADD forumName varchar(30)");
            sQLiteDatabase.execSQL("ALTER TABLE mark_data ADD forumId varchar(30)");
            sQLiteDatabase.execSQL("ALTER TABLE mark_data ADD threadId varchar(30)");
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("ALTER TABLE setting ADD remind_tone");
        }
        if (i < 5) {
            sQLiteDatabase.execSQL("CREATE TABLE if not exists frs_image_forums(forum_name)");
        }
        if (i < 6) {
            sQLiteDatabase.execSQL("CREATE TABLE if not exists search_post_data(key, account, time)");
        }
        if (i < 7) {
            c(sQLiteDatabase);
        }
        if (i < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE setting ADD msg_chat_switch DEFAULT 1");
            sQLiteDatabase.execSQL("ALTER TABLE setting ADD nodisturb_switch");
            sQLiteDatabase.execSQL("ALTER TABLE setting ADD nodisturb_start_time varchar(30)");
            sQLiteDatabase.execSQL("ALTER TABLE setting ADD nodisturb_end_time varchar(30)");
        }
        if (i < 9) {
            sQLiteDatabase.execSQL("ALTER TABLE account_data ADD portrait varchar(255)");
        }
        if (i < 10) {
            sQLiteDatabase.execSQL("ALTER TABLE account_data ADD personal_gid int");
        }
        if (i < 11) {
            d(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE if not exists chat_msgs(pk INTEGER primary key autoincrement, msgId bigint,ownerId varchar(32), friendId varchar(32), msgType int(11) default 0, status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists idx_c_msgs_of ON chat_msgs(ownerId, friendId, msgId)");
        sQLiteDatabase.execSQL("CREATE TABLE if not exists chat_recent_friends(pk varchar(64) primary key, unReadCount int(11) default 0 ,ownerId varchar(32), friendId varchar(32), ownerName varchar(64), friendName varchar(64), friendPortrait varchar(64), status int(11) default 0, localTime bigint(21) default 0, serverTime bigint(21) default 0, msgContent text)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists idx_c_rfs_ost ON chat_recent_friends(ownerId, serverTime)");
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" CREATE TABLE if not exists user_emotions(id INTEGER primary key autoincrement, uid varchar(128), groupId varchar(64), updateTime bigint(21) default 0)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists idx_ue_uid ON user_emotions(uid)");
        sQLiteDatabase.execSQL("CREATE TABLE if not exists emotion_group(groupId varchar(64) primary key, groupName varchar(128), groupDesc text, emotionsCount int(11) default 0, width  int(11) default 0, height  int(11) default 0, status  int(11) default 0, bytesLength int(11) default 0, bytesReceived int(11) default 0, downloadUrl varchar(512), downloadTime bigint(21) default 0)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists idx_eg_gids ON emotion_group(groupId, status)");
        sQLiteDatabase.execSQL("CREATE TABLE if not exists emotions(sharpText varchar(512) primary key, groupId varchar(64), orderId int(11) default 0)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists idx_e_gido ON emotions(groupId, orderId)");
    }
}
