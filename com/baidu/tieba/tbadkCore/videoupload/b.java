package com.baidu.tieba.tbadkCore.videoupload;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class b {
    public static void bgF() {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (mainDBDatabaseManager != null) {
            mainDBDatabaseManager.u("CREATE TABLE IF NOT EXISTS video_block_upload_data('md5' text,'last_upload_id' text ,'last_upload_success_index' integer,'account' text,'time' long)");
        }
    }

    public static void qx(String str) {
        BdLog.e("deleteVieoChunkUploadData Called");
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.g("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean m(String str, String str2, int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() == null || (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) == null) {
            return false;
        }
        Date date = new Date();
        mainDBDatabaseManager.g("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.g("Insert into video_block_upload_data(md5,last_upload_id,last_upload_success_index,account,time) values(?,?,?,?,?)", new Object[]{str, str2, Integer.valueOf(i), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static c qy(String str) {
        Cursor cursor;
        Exception e;
        c cVar;
        if (TbadkCoreApplication.getCurrentAccount() == null || StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from video_block_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        cVar = new c();
                        try {
                            cVar.fnj = cursor.getString(cursor.getColumnIndex("last_upload_id"));
                            cVar.fnk = cursor.getInt(cursor.getColumnIndex("last_upload_success_index"));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.d(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.h.a.a(cursor);
                            return cVar;
                        }
                    } else {
                        cVar = null;
                    }
                    com.baidu.adp.lib.h.a.a(cursor);
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.h.a.a(cursor);
                    throw th;
                }
            } catch (Exception e3) {
                cVar = null;
                e = e3;
            }
        } catch (Exception e4) {
            cursor = null;
            e = e4;
            cVar = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.h.a.a(cursor);
            throw th;
        }
        return cVar;
    }
}
