package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes8.dex */
final class d extends SQLiteOpenHelper {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        super(context, "BaiDuAb.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (int i = 0; i < e.kVM.length; i++) {
            sQLiteDatabase.execSQL(e.kVM[i]);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
