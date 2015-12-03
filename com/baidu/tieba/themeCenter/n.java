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
    private static n dEf;
    private SQLiteDatabase dEg = new o(TbadkCoreApplication.m411getInst().getApp()).getWritableDatabase();

    public static synchronized n aFl() {
        n nVar;
        synchronized (n.class) {
            if (dEf == null) {
                dEf = new n();
            }
            nVar = dEf;
        }
        return nVar;
    }

    private n() {
    }

    public void mR(String str) {
        new o(TbadkCoreApplication.m411getInst().getApp()).f(this.dEg, str);
    }

    public void mS(String str) {
        new o(TbadkCoreApplication.m411getInst().getApp()).g(this.dEg, str);
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
        contentValues.put("packageUrl", bVar.aFb());
        contentValues.put("versionCode", Integer.valueOf(bVar.getVersionCode()));
        contentValues.put("permissionIconUrl", bVar.aFc());
        contentValues.put("stateIconUrl", bVar.aFd());
        contentValues.put("activityUrl", bVar.getActivityUrl());
        contentValues.put("permissionType", Integer.valueOf(bVar.aFe()));
        return contentValues;
    }

    public boolean h(b bVar) {
        ContentValues g;
        if (bVar == null || (g = g(bVar)) == null) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.dEg == null || StringUtils.isNull(currentAccount)) {
            return false;
        }
        return this.dEg.update(new StringBuilder("theme_").append(currentAccount).toString(), g, "id = ?", new String[]{new StringBuilder().append(bVar.getId()).toString()}) != 0 || this.dEg.insert(new StringBuilder("theme_").append(currentAccount).toString(), null, g) > 0;
    }

    public boolean mR(int i) {
        if (i <= 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.dEg == null || StringUtils.isNull(currentAccount) || this.dEg.delete(new StringBuilder("theme_").append(currentAccount).toString(), "id = ?", new String[]{String.valueOf(i)}) <= 0) ? false : true;
    }

    public ArrayList<String> aFm() {
        ArrayList<String> arrayList = null;
        if (this.dEg != null) {
            this.dEg.beginTransaction();
            Cursor rawQuery = this.dEg.rawQuery("SELECT name FROM sqlite_master WHERE type='table' order by name", null);
            if (rawQuery != null && rawQuery.getCount() > 0) {
                arrayList = new ArrayList<>();
                while (rawQuery.moveToNext()) {
                    String string = rawQuery.getString(0);
                    if (string != null && string.startsWith("theme_")) {
                        arrayList.add(string);
                    }
                }
                com.baidu.adp.lib.util.o.b(rawQuery);
                this.dEg.setTransactionSuccessful();
                this.dEg.endTransaction();
            }
        }
        return arrayList;
    }

    public b mS(int i) {
        Cursor rawQuery;
        b bVar = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.dEg != null && !StringUtils.isNull(currentAccount) && (rawQuery = this.dEg.rawQuery("SELECT * FROM theme_" + currentAccount + " WHERE id=?", new String[]{String.valueOf(i)})) != null && rawQuery.getCount() > 0) {
            if (rawQuery.moveToFirst()) {
                bVar = new b();
                bVar.setId(i);
                bVar.setTitle(rawQuery.getString(rawQuery.getColumnIndex("title")));
                bVar.mN(rawQuery.getString(rawQuery.getColumnIndex("picUrl")));
                bVar.setPackageSize(rawQuery.getString(rawQuery.getColumnIndex("packageSize")));
                bVar.mO(rawQuery.getString(rawQuery.getColumnIndex("packageUrl")));
                bVar.setVersionCode(rawQuery.getInt(rawQuery.getColumnIndex("versionCode")));
                bVar.mP(rawQuery.getString(rawQuery.getColumnIndex("permissionIconUrl")));
                bVar.mQ(rawQuery.getString(rawQuery.getColumnIndex("stateIconUrl")));
                bVar.setActivityUrl(rawQuery.getString(rawQuery.getColumnIndex("activityUrl")));
                bVar.mO(rawQuery.getInt(rawQuery.getColumnIndex("permissionType")));
            }
            com.baidu.adp.lib.util.o.b(rawQuery);
        }
        return bVar;
    }

    public List<b> mT(String str) {
        ArrayList arrayList = null;
        if (this.dEg != null && !StringUtils.isNull(str)) {
            this.dEg.beginTransaction();
            Cursor rawQuery = this.dEg.rawQuery("SELECT * FROM " + str, null);
            if (rawQuery != null) {
                arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("id")));
                    bVar.setTitle(rawQuery.getString(rawQuery.getColumnIndex("title")));
                    bVar.mN(rawQuery.getString(rawQuery.getColumnIndex("picUrl")));
                    bVar.setPackageSize(rawQuery.getString(rawQuery.getColumnIndex("packageSize")));
                    bVar.mO(rawQuery.getString(rawQuery.getColumnIndex("packageUrl")));
                    bVar.setVersionCode(rawQuery.getInt(rawQuery.getColumnIndex("versionCode")));
                    bVar.mP(rawQuery.getString(rawQuery.getColumnIndex("permissionIconUrl")));
                    bVar.mQ(rawQuery.getString(rawQuery.getColumnIndex("stateIconUrl")));
                    bVar.setActivityUrl(rawQuery.getString(rawQuery.getColumnIndex("activityUrl")));
                    bVar.mO(rawQuery.getInt(rawQuery.getColumnIndex("permissionType")));
                    arrayList.add(bVar);
                }
                com.baidu.adp.lib.util.o.b(rawQuery);
                this.dEg.setTransactionSuccessful();
                this.dEg.endTransaction();
            }
        }
        return arrayList;
    }

    public List<b> aFn() {
        return mT("theme_" + TbadkCoreApplication.getCurrentAccount());
    }
}
