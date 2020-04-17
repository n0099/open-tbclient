package com.baidu.ubs.analytics.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
final class k {
    private SQLiteDatabase lOg = f.dkY().dkZ();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(l lVar) {
        this.lOg.execSQL("INSERT INTO tb_ab_page_log(_startTime,_endTime,_pagerName,_path,_sessionId) VALUES (?,?,?,?,?);", new String[]{lVar.N(), lVar.O(), lVar.E(), lVar.getPath(), lVar.I()});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<l> dkX() {
        Cursor rawQuery = this.lOg.rawQuery("SELECT * FROM  tb_ab_page_log order by _id ", null);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            l lVar = new l();
            lVar.t(rawQuery.getString(rawQuery.getColumnIndex("_pagerName")));
            lVar.setPath(rawQuery.getString(rawQuery.getColumnIndex("_path")));
            lVar.z(rawQuery.getString(rawQuery.getColumnIndex("_endTime")));
            lVar.setStartTime(rawQuery.getString(rawQuery.getColumnIndex("_startTime")));
            lVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
            lVar.setId(rawQuery.getInt(rawQuery.getColumnIndex(IMConstants.MSG_ROW_ID)));
            arrayList.add(lVar);
        }
        rawQuery.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.lOg.execSQL("delete from tb_ab_page_log where _id <= " + i);
    }
}
