package com.baidu.tieba.tbadkCore.videoupload;

import android.database.Cursor;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes.dex */
public class b {
    public static void aGs() {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (mainDBDatabaseManager != null) {
            mainDBDatabaseManager.E("CREATE TABLE IF NOT EXISTS video_chunk_upload_data('md5' text,'total_length' long ,'chunk_no' integer,'account' text,'time' long)");
        }
    }

    public static void mF(String str) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null && mainDBDatabaseManager != null) {
                mainDBDatabaseManager.a("delete from video_chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            }
        }
    }

    public static boolean c(com.baidu.tbadk.coreExtra.data.c cVar) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (cVar == null || mainDBDatabaseManager == null) {
            return false;
        }
        Date date = new Date();
        mainDBDatabaseManager.a("delete from video_chunk_upload_data where md5=? and account=?", new String[]{cVar.wK(), TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.a("Insert into video_chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{cVar.wK(), Long.valueOf(cVar.getTotalLength()), Integer.valueOf(cVar.wL()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }

    public static com.baidu.tbadk.coreExtra.data.c mG(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tbadk.coreExtra.data.c cVar;
        if (TbadkCoreApplication.getCurrentAccount() == null || StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from video_chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        cVar = new com.baidu.tbadk.coreExtra.data.c();
                        try {
                            cVar.dW(str);
                            cVar.dc(cursor.getInt(cursor.getColumnIndex("chunk_no")));
                            cVar.G(cursor.getLong(cursor.getColumnIndex("total_length")));
                        } catch (Exception e2) {
                            e = e2;
                            mainDBDatabaseManager.d(e, "getChunkUploadDataByMd5");
                            com.baidu.adp.lib.h.a.b(cursor);
                            return cVar;
                        }
                    } else {
                        cVar = null;
                    }
                    com.baidu.adp.lib.h.a.b(cursor);
                } catch (Exception e3) {
                    cVar = null;
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.h.a.b(cursor);
                throw th;
            }
        } catch (Exception e4) {
            cursor = null;
            e = e4;
            cVar = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return cVar;
    }
}
