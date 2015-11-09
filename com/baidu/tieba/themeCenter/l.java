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
    private static l dgy;
    private SQLiteDatabase dgz = new m(TbadkCoreApplication.m411getInst().getApp()).getWritableDatabase();

    public static synchronized l aAe() {
        l lVar;
        synchronized (l.class) {
            if (dgy == null) {
                dgy = new l();
            }
            lVar = dgy;
        }
        return lVar;
    }

    private l() {
    }

    public void aAf() {
        new m(TbadkCoreApplication.m411getInst().getApp()).n(this.dgz);
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
        contentValues.put("packageUrl", bVar.azU());
        contentValues.put("versionCode", Integer.valueOf(bVar.getVersionCode()));
        contentValues.put("permissionIconUrl", bVar.azV());
        contentValues.put("stateIconUrl", bVar.azW());
        contentValues.put("activityUrl", bVar.getActivityUrl());
        contentValues.put("permissionType", Integer.valueOf(bVar.azX()));
        return contentValues;
    }

    public boolean f(b bVar) {
        ContentValues e;
        if (bVar == null || (e = e(bVar)) == null) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.dgz == null || StringUtils.isNull(currentAccount)) {
            return false;
        }
        return this.dgz.update(new StringBuilder("theme_").append(currentAccount).toString(), e, "id = ?", new String[]{new StringBuilder().append(bVar.getId()).toString()}) != 0 || this.dgz.insert(new StringBuilder("theme_").append(currentAccount).toString(), null, e) > 0;
    }

    public boolean lI(int i) {
        if (i <= 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.dgz == null || StringUtils.isNull(currentAccount) || this.dgz.delete(new StringBuilder("theme_").append(currentAccount).toString(), "id = ?", new String[]{String.valueOf(i)}) <= 0) ? false : true;
    }

    public List<b> aAg() {
        ArrayList arrayList = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.dgz != null && !StringUtils.isNull(currentAccount)) {
            this.dgz.beginTransaction();
            Cursor rawQuery = this.dgz.rawQuery("SELECT * FROM theme_" + currentAccount, null);
            if (rawQuery != null) {
                arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("id")));
                    bVar.setTitle(rawQuery.getString(rawQuery.getColumnIndex("title")));
                    bVar.lW(rawQuery.getString(rawQuery.getColumnIndex("picUrl")));
                    bVar.setPackageSize(rawQuery.getString(rawQuery.getColumnIndex("packageSize")));
                    bVar.lX(rawQuery.getString(rawQuery.getColumnIndex("packageUrl")));
                    bVar.setVersionCode(rawQuery.getInt(rawQuery.getColumnIndex("versionCode")));
                    bVar.lY(rawQuery.getString(rawQuery.getColumnIndex("permissionIconUrl")));
                    bVar.lZ(rawQuery.getString(rawQuery.getColumnIndex("stateIconUrl")));
                    bVar.setActivityUrl(rawQuery.getString(rawQuery.getColumnIndex("activityUrl")));
                    bVar.lE(rawQuery.getInt(rawQuery.getColumnIndex("permissionType")));
                    arrayList.add(bVar);
                }
                com.baidu.adp.lib.util.o.b(rawQuery);
                this.dgz.setTransactionSuccessful();
                this.dgz.endTransaction();
            }
        }
        return arrayList;
    }
}
