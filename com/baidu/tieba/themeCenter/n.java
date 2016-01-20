package com.baidu.tieba.themeCenter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static n dLJ;
    private SQLiteDatabase dLK = new o(TbadkCoreApplication.m411getInst().getApp()).getWritableDatabase();

    public static synchronized n aHA() {
        n nVar;
        synchronized (n.class) {
            if (dLJ == null) {
                dLJ = new n();
            }
            nVar = dLJ;
        }
        return nVar;
    }

    private n() {
    }

    public void mP(String str) {
        new o(TbadkCoreApplication.m411getInst().getApp()).f(this.dLK, str);
    }

    public void mQ(String str) {
        new o(TbadkCoreApplication.m411getInst().getApp()).g(this.dLK, str);
    }

    private ContentValues g(b bVar) {
        if (bVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(bVar.getId()));
        contentValues.put("title", bVar.getTitle());
        contentValues.put("picUrl", bVar.getPicUrl());
        contentValues.put("packageSize", bVar.getPackageSize());
        contentValues.put("packageUrl", bVar.aHq());
        contentValues.put("versionCode", Integer.valueOf(bVar.getVersionCode()));
        contentValues.put("permissionIconUrl", bVar.aHr());
        contentValues.put("stateIconUrl", bVar.aHs());
        contentValues.put("activityUrl", bVar.getActivityUrl());
        contentValues.put("permissionType", Integer.valueOf(bVar.aHt()));
        return contentValues;
    }

    public boolean h(b bVar) {
        ContentValues g;
        if (bVar == null || (g = g(bVar)) == null) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.dLK == null || StringUtils.isNull(currentAccount)) {
            return false;
        }
        return this.dLK.update(new StringBuilder("theme_").append(currentAccount).toString(), g, "id = ?", new String[]{new StringBuilder().append(bVar.getId()).toString()}) != 0 || this.dLK.insert(new StringBuilder("theme_").append(currentAccount).toString(), null, g) > 0;
    }

    public boolean nt(int i) {
        if (i <= 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.dLK == null || StringUtils.isNull(currentAccount) || this.dLK.delete(new StringBuilder("theme_").append(currentAccount).toString(), "id = ?", new String[]{String.valueOf(i)}) <= 0) ? false : true;
    }

    public ArrayList<String> aHB() {
        ArrayList<String> arrayList = null;
        if (this.dLK != null) {
            this.dLK.beginTransaction();
            Cursor rawQuery = this.dLK.rawQuery("SELECT name FROM sqlite_master WHERE type='table' order by name", null);
            if (rawQuery != null && rawQuery.getCount() > 0) {
                arrayList = new ArrayList<>();
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (string != null && string.startsWith("theme_")) {
                        arrayList.add(string);
                    }
                }
                com.baidu.adp.lib.util.o.b(rawQuery);
                this.dLK.setTransactionSuccessful();
                this.dLK.endTransaction();
            }
        }
        return arrayList;
    }

    public b nu(int i) {
        Cursor rawQuery;
        b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.dLK != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.dLK.rawQuery("SELECT * FROM theme_" + currentAccount + " WHERE id=?", new String[]{String.valueOf(i)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                bVar = new b();
                bVar.setId(i);
                bVar.setTitle(rawQuery.getString(rawQuery.getColumnIndex("title")));
                bVar.mL(rawQuery.getString(rawQuery.getColumnIndex("picUrl")));
                bVar.setPackageSize(rawQuery.getString(rawQuery.getColumnIndex("packageSize")));
                bVar.mM(rawQuery.getString(rawQuery.getColumnIndex("packageUrl")));
                bVar.setVersionCode(rawQuery.getInt(rawQuery.getColumnIndex("versionCode")));
                bVar.mN(rawQuery.getString(rawQuery.getColumnIndex("permissionIconUrl")));
                bVar.mO(rawQuery.getString(rawQuery.getColumnIndex("stateIconUrl")));
                bVar.setActivityUrl(rawQuery.getString(rawQuery.getColumnIndex("activityUrl")));
                bVar.nq(rawQuery.getInt(rawQuery.getColumnIndex("permissionType")));
            }
            com.baidu.adp.lib.util.o.b(rawQuery);
        }
        return bVar;
    }

    public List<b> mR(String str) {
        ArrayList arrayList = null;
        if (this.dLK != null && !StringUtils.isNull(str)) {
            this.dLK.beginTransaction();
            Cursor rawQuery = this.dLK.rawQuery("SELECT * FROM " + str, null);
            if (rawQuery != null) {
                arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("id")));
                    bVar.setTitle(rawQuery.getString(rawQuery.getColumnIndex("title")));
                    bVar.mL(rawQuery.getString(rawQuery.getColumnIndex("picUrl")));
                    bVar.setPackageSize(rawQuery.getString(rawQuery.getColumnIndex("packageSize")));
                    bVar.mM(rawQuery.getString(rawQuery.getColumnIndex("packageUrl")));
                    bVar.setVersionCode(rawQuery.getInt(rawQuery.getColumnIndex("versionCode")));
                    bVar.mN(rawQuery.getString(rawQuery.getColumnIndex("permissionIconUrl")));
                    bVar.mO(rawQuery.getString(rawQuery.getColumnIndex("stateIconUrl")));
                    bVar.setActivityUrl(rawQuery.getString(rawQuery.getColumnIndex("activityUrl")));
                    bVar.nq(rawQuery.getInt(rawQuery.getColumnIndex("permissionType")));
                    arrayList.add(bVar);
                }
                com.baidu.adp.lib.util.o.b(rawQuery);
                this.dLK.setTransactionSuccessful();
                this.dLK.endTransaction();
            }
        }
        return arrayList;
    }

    public List<b> aHC() {
        return mR("theme_" + TbadkCoreApplication.getCurrentAccount());
    }
}
