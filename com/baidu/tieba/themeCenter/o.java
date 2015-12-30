package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class o extends SQLiteOpenHelper {
    public o(Context context) {
        super(context, "theme_center.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f(sQLiteDatabase, "theme_" + TbadkCoreApplication.getCurrentAccount());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_DELETE_ALL_SKIN_FILE));
    }

    public void f(SQLiteDatabase sQLiteDatabase, String str) {
        if (sQLiteDatabase != null) {
            try {
                if (!StringUtils.isNull(str)) {
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + "(id INT UNIQUE, title TEXT, picUrl TEXT, packageSize TEXT, packageUrl TEXT, versionCode INT, permissionIconUrl TEXT, activityUrl TEXT, permissionType INT, stateIconUrl TEXT);");
                }
            } catch (Throwable th) {
                BdLog.e("create table wrong " + th.toString());
            }
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
