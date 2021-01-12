package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static SQLiteOpenHelper oJA;
    private static f oJz;
    private AtomicInteger oJB = new AtomicInteger();
    private SQLiteDatabase oJC;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oJz == null) {
                oJz = new f();
                oJA = new d(context);
            }
        }
    }

    public static synchronized f efI() {
        f fVar;
        synchronized (f.class) {
            if (oJz == null) {
                b(com.baidu.ubs.analytics.d.efH().getContext());
            }
            fVar = oJz;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase asC() {
        if (this.oJB.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.WE("***************新建立了 一个数据库的实例****************");
            this.oJC = oJA.getWritableDatabase();
        }
        return this.oJC;
    }
}
