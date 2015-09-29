package com.baidu.tieba.themeCenter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    private static l des;
    private SQLiteDatabase det = new m(TbadkCoreApplication.m411getInst().getApp()).getWritableDatabase();

    public static synchronized l azi() {
        l lVar;
        synchronized (l.class) {
            if (des == null) {
                des = new l();
            }
            lVar = des;
        }
        return lVar;
    }

    private l() {
    }

    public void azj() {
        new m(TbadkCoreApplication.m411getInst().getApp()).n(this.det);
    }

    private ContentValues e(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(bVar.getId()));
        contentValues.put("title", bVar.getTitle());
        contentValues.put("picUrl", bVar.getPicUrl());
        contentValues.put("packageSize", bVar.getPackageSize());
        contentValues.put("packageUrl", bVar.ayY());
        contentValues.put("versionCode", Integer.valueOf(bVar.getVersionCode()));
        contentValues.put("permissionIconUrl", bVar.ayZ());
        contentValues.put("stateIconUrl", bVar.aza());
        contentValues.put("activityUrl", bVar.getActivityUrl());
        contentValues.put("permissionType", Integer.valueOf(bVar.azb()));
        return contentValues;
    }

    public boolean f(b bVar) {
        ContentValues e;
        if (bVar == null || (e = e(bVar)) == null) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.det == null || StringUtils.isNull(currentAccount)) {
            return false;
        }
        return this.det.update(new StringBuilder("theme_").append(currentAccount).toString(), e, "id = ?", new String[]{new StringBuilder().append(bVar.getId()).toString()}) != 0 || this.det.insert(new StringBuilder("theme_").append(currentAccount).toString(), null, e) > 0;
    }

    public boolean ls(int i) {
        if (i <= 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.det == null || StringUtils.isNull(currentAccount) || this.det.delete(new StringBuilder("theme_").append(currentAccount).toString(), "id = ?", new String[]{String.valueOf(i)}) <= 0) ? false : true;
    }

    public List<b> azk() {
        ArrayList arrayList = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.det != null && !StringUtils.isNull(currentAccount)) {
            this.det.beginTransaction();
            Cursor rawQuery = this.det.rawQuery("SELECT * FROM theme_" + currentAccount, null);
            if (rawQuery != null) {
                arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("id")));
                    bVar.setTitle(rawQuery.getString(rawQuery.getColumnIndex("title")));
                    bVar.lP(rawQuery.getString(rawQuery.getColumnIndex("picUrl")));
                    bVar.setPackageSize(rawQuery.getString(rawQuery.getColumnIndex("packageSize")));
                    bVar.lQ(rawQuery.getString(rawQuery.getColumnIndex("packageUrl")));
                    bVar.setVersionCode(rawQuery.getInt(rawQuery.getColumnIndex("versionCode")));
                    bVar.lR(rawQuery.getString(rawQuery.getColumnIndex("permissionIconUrl")));
                    bVar.lS(rawQuery.getString(rawQuery.getColumnIndex("stateIconUrl")));
                    bVar.setActivityUrl(rawQuery.getString(rawQuery.getColumnIndex("activityUrl")));
                    bVar.lo(rawQuery.getInt(rawQuery.getColumnIndex("permissionType")));
                    arrayList.add(bVar);
                }
                com.baidu.adp.lib.util.o.b(rawQuery);
                this.det.setTransactionSuccessful();
                this.det.endTransaction();
            }
        }
        return arrayList;
    }
}
