package com.baidu.ubs.analytics.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
final class c {
    private SQLiteDatabase jwy = f.csq().getDatabase();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(a aVar) {
        this.jwy.execSQL("INSERT INTO tb_ab_click_log(_eventId,_parameter,_sessionId,_timeStamp,_pagerName,_productLine) VALUES (?,?,?,?,?,?);", new String[]{aVar.G(), aVar.H(), aVar.I(), aVar.F(), aVar.E(), aVar.D()});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<a> csp() {
        Cursor rawQuery = this.jwy.rawQuery("SELECT * FROM tb_ab_click_log order by _id ", null);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.v(rawQuery.getString(rawQuery.getColumnIndex("_eventId")));
            aVar.w(rawQuery.getString(rawQuery.getColumnIndex("_parameter")));
            aVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
            aVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
            aVar.t(rawQuery.getString(rawQuery.getColumnIndex("_pagerName")));
            aVar.s(rawQuery.getString(rawQuery.getColumnIndex("_productLine")));
            aVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
            arrayList.add(aVar);
        }
        rawQuery.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.jwy.execSQL("delete from tb_ab_click_log where _id <= " + i);
    }
}
