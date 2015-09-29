package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m extends SQLiteOpenHelper {
    public m(Context context) {
        super(context, "theme_center.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        n(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        q(sQLiteDatabase);
        n(sQLiteDatabase);
    }

    public void n(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS theme_" + currentAccount + "(id INT UNIQUE, title TEXT, picUrl TEXT, packageSize TEXT, packageUrl TEXT, versionCode INT, permissionIconUrl TEXT, activityUrl TEXT, permissionType INT, stateIconUrl TEXT);");
                }
            } catch (Throwable th) {
                BdLog.e("create table wrong " + th.toString());
            }
        }
    }

    public void q(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!TextUtils.isEmpty(currentAccount)) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS theme_" + currentAccount);
                }
            } catch (Throwable th) {
                BdLog.e("drop table wrong " + th.toString());
            }
        }
    }
}
