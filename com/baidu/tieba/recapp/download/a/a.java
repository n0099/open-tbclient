package com.baidu.tieba.recapp.download.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TiebaDatabase;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static a dDO() {
        return C0865a.mUX;
    }

    /* renamed from: com.baidu.tieba.recapp.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0865a {
        private static final a mUX = new a();
    }

    public synchronized void c(b bVar) {
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.downloadKey) && !TextUtils.isEmpty(bVar.packageName)) {
                SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
                openedDatabase.beginTransaction();
                openedDatabase.replace("ad_follow_up_info_table", null, d(bVar));
                openedDatabase.setTransactionSuccessful();
                openedDatabase.endTransaction();
            }
        }
    }

    public synchronized void RK(String str) {
        if (!TextUtils.isEmpty(str)) {
            SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
            openedDatabase.beginTransaction();
            openedDatabase.delete("ad_follow_up_info_table", "download_key = ?", new String[]{str});
            openedDatabase.setTransactionSuccessful();
            openedDatabase.endTransaction();
        }
    }

    public synchronized List<b> b(Integer num, Integer num2) {
        ArrayList arrayList;
        SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
        openedDatabase.beginTransaction();
        long currentTimeMillis = System.currentTimeMillis() - ((((num.intValue() * 24) * 60) * 60) * 1000);
        arrayList = new ArrayList();
        Cursor rawQuery = openedDatabase.rawQuery("SELECT * FROM ad_follow_up_info_table where finish_download_time > ? and show_times < ? and install_status = ? order by finish_download_time desc", new String[]{String.valueOf(currentTimeMillis), String.valueOf(num2), String.valueOf(1)});
        while (rawQuery.moveToNext()) {
            b B = B(rawQuery);
            if (B != null && !arrayList.contains(B)) {
                arrayList.add(B);
            }
        }
        openedDatabase.setTransactionSuccessful();
        n.close(rawQuery);
        openedDatabase.endTransaction();
        return arrayList;
    }

    public synchronized void c(Integer num, Integer num2) {
        SQLiteDatabase openedDatabase = TiebaDatabase.getInstance().getMainDBDatabaseManager().getOpenedDatabase();
        openedDatabase.beginTransaction();
        openedDatabase.delete("ad_follow_up_info_table", "finish_download_time < ? and show_times >= ?", new String[]{String.valueOf(System.currentTimeMillis() - ((((num.intValue() * 24) * 60) * 60) * 1000)), String.valueOf(num2)});
        openedDatabase.setTransactionSuccessful();
        openedDatabase.endTransaction();
    }

    private b B(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        try {
            b bVar = new b();
            bVar.downloadKey = cursor.getString(cursor.getColumnIndex("download_key"));
            bVar.packageName = cursor.getString(cursor.getColumnIndex("package_name"));
            bVar.mUY = Long.parseLong(cursor.getString(cursor.getColumnIndex("finish_download_time")));
            bVar.mUZ = Integer.parseInt(cursor.getString(cursor.getColumnIndex("show_times")));
            bVar.lOR = Long.parseLong(cursor.getString(cursor.getColumnIndex("last_show_time")));
            bVar.mVa = cursor.getString(cursor.getColumnIndex("ad_string"));
            bVar.mVb = cursor.getString(cursor.getColumnIndex("cmatch"));
            bVar.installStatus = Integer.parseInt(cursor.getString(cursor.getColumnIndex("install_status")));
            bVar.mVc = cursor.getString(cursor.getColumnIndex("ad_extension_info1"));
            bVar.mVd = cursor.getString(cursor.getColumnIndex("ad_extension_info2"));
            bVar.mVe = cursor.getString(cursor.getColumnIndex("ad_extension_info3"));
            return bVar;
        } catch (Exception e) {
            return null;
        }
    }

    private ContentValues d(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.downloadKey)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_key", bVar.downloadKey);
        contentValues.put("package_name", bVar.packageName);
        contentValues.put("finish_download_time", String.valueOf(bVar.mUY));
        contentValues.put("show_times", String.valueOf(bVar.mUZ));
        contentValues.put("last_show_time", String.valueOf(bVar.lOR));
        contentValues.put("ad_string", bVar.mVa);
        contentValues.put("cmatch", bVar.mVb);
        contentValues.put("install_status", Integer.valueOf(bVar.installStatus));
        contentValues.put("ad_extension_info1", bVar.mVc);
        contentValues.put("ad_extension_info2", bVar.mVd);
        contentValues.put("ad_extension_info3", bVar.mVe);
        return contentValues;
    }
}
