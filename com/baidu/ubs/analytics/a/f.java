package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f oJA;
    private static SQLiteOpenHelper oJB;
    private AtomicInteger oJC = new AtomicInteger();
    private SQLiteDatabase oJD;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oJA == null) {
                oJA = new f();
                oJB = new d(context);
            }
        }
    }

    public static synchronized f efI() {
        f fVar;
        synchronized (f.class) {
            if (oJA == null) {
                b(com.baidu.ubs.analytics.d.efH().getContext());
            }
            fVar = oJA;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase asC() {
        if (this.oJC.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.WF("***************新建立了 一个数据库的实例****************");
            this.oJD = oJB.getWritableDatabase();
        }
        return this.oJD;
    }
}
