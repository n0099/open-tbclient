package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f kWb;
    private static SQLiteOpenHelper kWc;
    private AtomicInteger kWd = new AtomicInteger();
    private SQLiteDatabase kWe;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (kWb == null) {
                kWb = new f();
                kWc = new d(context);
            }
        }
    }

    public static synchronized f cXr() {
        f fVar;
        synchronized (f.class) {
            if (kWb == null) {
                b(com.baidu.ubs.analytics.d.cXp().getContext());
            }
            fVar = kWb;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cXs() {
        if (this.kWd.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Ls("***************新建立了 一个数据库的实例****************");
            this.kWe = kWc.getWritableDatabase();
        }
        return this.kWe;
    }
}
