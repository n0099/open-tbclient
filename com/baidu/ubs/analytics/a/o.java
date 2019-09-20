package com.baidu.ubs.analytics.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
final class o {
    private SQLiteDatabase jZU = f.cEv().cEw();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(n nVar) {
        this.jZU.execSQL("INSERT INTO tb_ab_sessionlog(_startTime,_keepTime,_endTime,_sessionId) VALUES (?,?,?,?);", new String[]{nVar.N(), nVar.P(), nVar.O(), nVar.I()});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(n nVar) {
        this.jZU.execSQL("UPDATE tb_ab_sessionlog SET _keepTime= ? , _endTime = ? WHERE _sessionId= ?", new String[]{nVar.P(), nVar.O(), nVar.I()});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<n> cEu() {
        Cursor rawQuery = this.jZU.rawQuery("SELECT * FROM  tb_ab_sessionlog", null);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            n nVar = new n();
            nVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
            nVar.setStartTime(rawQuery.getString(rawQuery.getColumnIndex("_startTime")));
            nVar.A(rawQuery.getString(rawQuery.getColumnIndex("_keepTime")));
            nVar.z(rawQuery.getString(rawQuery.getColumnIndex("_endTime")));
            arrayList.add(nVar);
        }
        rawQuery.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void HI(String str) {
        this.jZU.execSQL("delete from tb_ab_sessionlog where not ( _sessionId = ? )", new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean HJ(String str) {
        Cursor rawQuery = this.jZU.rawQuery("select * from tb_ab_sessionlog where _sessionId = ? ", new String[]{str});
        int count = rawQuery.getCount();
        rawQuery.close();
        return count > 0;
    }
}
