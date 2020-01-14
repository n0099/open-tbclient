package com.baidu.ubs.analytics.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
final class h {
    private SQLiteDatabase kVf = f.cWa().cWb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<i> cVZ() {
        Cursor rawQuery = this.kVf.rawQuery("SELECT * FROM tb_ab_netlog order by _id ", null);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            i iVar = new i();
            iVar.setUrl(rawQuery.getString(rawQuery.getColumnIndex("_url")));
            iVar.setType(rawQuery.getString(rawQuery.getColumnIndex("_type")));
            iVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
            iVar.setParameters(rawQuery.getString(rawQuery.getColumnIndex("_parameters")));
            iVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
            iVar.setId(rawQuery.getInt(rawQuery.getColumnIndex(IMConstants.MSG_ROW_ID)));
            arrayList.add(iVar);
        }
        rawQuery.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        this.kVf.execSQL("delete from tb_ab_netlog where _id <= " + i);
    }
}
