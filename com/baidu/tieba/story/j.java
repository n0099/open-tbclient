package com.baidu.tieba.story;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class j extends SQLiteOpenHelper {
    public j(Context context) {
        super(context, "story_status.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f(sQLiteDatabase, "story_" + TbadkCoreApplication.getCurrentAccount());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        t(sQLiteDatabase);
        s(sQLiteDatabase);
    }

    public void s(SQLiteDatabase sQLiteDatabase) {
        try {
            f(sQLiteDatabase, "story_" + TbadkCoreApplication.getCurrentAccount());
        } catch (Throwable th) {
            BdLog.e("create table wrong " + th.toString());
        }
    }

    public void f(SQLiteDatabase sQLiteDatabase, String str) {
        if (sQLiteDatabase != null) {
            try {
                if (!StringUtils.isNull(str)) {
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + "(forum_id INT UNIQUE, forum_name TEXT, status INT, pagefrom INT, type INT, pic_path INT, origin_video_path TEXT, mute INT, sticer_path TEXT, need_pub INT, only_pub INT, need_composite INT, target_width INT, target_height INT, locate_x INT, locate_y INT, " + CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME + " TEXT, create_video_path TEXT);");
                }
            } catch (Throwable th) {
                BdLog.e("create table wrong " + th.toString());
            }
        }
    }

    public void t(SQLiteDatabase sQLiteDatabase) {
        try {
            g(sQLiteDatabase, "story_" + TbadkCoreApplication.getCurrentAccount());
        } catch (Throwable th) {
            BdLog.e("drop table wrong " + th.toString());
        }
    }

    public void g(SQLiteDatabase sQLiteDatabase, String str) {
        if (sQLiteDatabase != null) {
            try {
                if (!StringUtils.isNull(str)) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                }
            } catch (Throwable th) {
                BdLog.e("drop table wrong " + th.toString());
            }
        }
    }
}
