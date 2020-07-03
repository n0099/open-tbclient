package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f mEG;
    private static SQLiteOpenHelper mEH;
    private AtomicInteger mEI = new AtomicInteger();
    private SQLiteDatabase mEJ;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (mEG == null) {
                mEG = new f();
                mEH = new d(context);
            }
        }
    }

    public static synchronized f dxf() {
        f fVar;
        synchronized (f.class) {
            if (mEG == null) {
                b(com.baidu.ubs.analytics.d.dxd().getContext());
            }
            fVar = mEG;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase dxg() {
        if (this.mEI.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.mEJ = mEH.getWritableDatabase();
        }
        return this.mEJ;
    }
}
