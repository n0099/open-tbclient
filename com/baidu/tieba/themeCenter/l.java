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
    private static l deS;
    private SQLiteDatabase deT = new m(TbadkCoreApplication.m411getInst().getApp()).getWritableDatabase();

    public static synchronized l azo() {
        l lVar;
        synchronized (l.class) {
            if (deS == null) {
                deS = new l();
            }
            lVar = deS;
        }
        return lVar;
    }

    private l() {
    }

    public void azp() {
        new m(TbadkCoreApplication.m411getInst().getApp()).n(this.deT);
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
        contentValues.put("packageUrl", bVar.aze());
        contentValues.put("versionCode", Integer.valueOf(bVar.getVersionCode()));
        contentValues.put("permissionIconUrl", bVar.azf());
        contentValues.put("stateIconUrl", bVar.azg());
        contentValues.put("activityUrl", bVar.getActivityUrl());
        contentValues.put("permissionType", Integer.valueOf(bVar.azh()));
        return contentValues;
    }

    public boolean f(b bVar) {
        ContentValues e;
        if (bVar == null || (e = e(bVar)) == null) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.deT == null || StringUtils.isNull(currentAccount)) {
            return false;
        }
        return this.deT.update(new StringBuilder("theme_").append(currentAccount).toString(), e, "id = ?", new String[]{new StringBuilder().append(bVar.getId()).toString()}) != 0 || this.deT.insert(new StringBuilder("theme_").append(currentAccount).toString(), null, e) > 0;
    }

    public boolean lu(int i) {
        if (i <= 0) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (this.deT == null || StringUtils.isNull(currentAccount) || this.deT.delete(new StringBuilder("theme_").append(currentAccount).toString(), "id = ?", new String[]{String.valueOf(i)}) <= 0) ? false : true;
    }

    public List<b> azq() {
        ArrayList arrayList = null;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (this.deT != null && !StringUtils.isNull(currentAccount)) {
            this.deT.beginTransaction();
            Cursor rawQuery = this.deT.rawQuery("SELECT * FROM theme_" + currentAccount, null);
            if (rawQuery != null) {
                arrayList = new ArrayList();
                while (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("id")));
                    bVar.setTitle(rawQuery.getString(rawQuery.getColumnIndex("title")));
                    bVar.lS(rawQuery.getString(rawQuery.getColumnIndex("picUrl")));
                    bVar.setPackageSize(rawQuery.getString(rawQuery.getColumnIndex("packageSize")));
                    bVar.lT(rawQuery.getString(rawQuery.getColumnIndex("packageUrl")));
                    bVar.setVersionCode(rawQuery.getInt(rawQuery.getColumnIndex("versionCode")));
                    bVar.lU(rawQuery.getString(rawQuery.getColumnIndex("permissionIconUrl")));
                    bVar.lV(rawQuery.getString(rawQuery.getColumnIndex("stateIconUrl")));
                    bVar.setActivityUrl(rawQuery.getString(rawQuery.getColumnIndex("activityUrl")));
                    bVar.lq(rawQuery.getInt(rawQuery.getColumnIndex("permissionType")));
                    arrayList.add(bVar);
                }
                com.baidu.adp.lib.util.o.b(rawQuery);
                this.deT.setTransactionSuccessful();
                this.deT.endTransaction();
            }
        }
        return arrayList;
    }
}
