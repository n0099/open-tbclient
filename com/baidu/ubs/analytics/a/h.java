package com.baidu.ubs.analytics.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
final class h {
    private SQLiteDatabase hBF = f.bKs().getDatabase();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<i> bKr() {
        Cursor rawQuery = this.hBF.rawQuery("SELECT * FROM tb_ab_netlog order by _id ", null);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            i iVar = new i();
            iVar.setUrl(rawQuery.getString(rawQuery.getColumnIndex("_url")));
            iVar.setType(rawQuery.getString(rawQuery.getColumnIndex("_type")));
            iVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
            iVar.setParameters(rawQuery.getString(rawQuery.getColumnIndex("_parameters")));
            iVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
            iVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
            arrayList.add(iVar);
        }
        rawQuery.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.hBF.execSQL("delete from tb_ab_netlog where _id <= " + i);
    }
}
