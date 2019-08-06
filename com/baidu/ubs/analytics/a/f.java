package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static SQLiteOpenHelper jXA;
    private static f jXz;
    private AtomicInteger jXB = new AtomicInteger();
    private SQLiteDatabase jXC;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jXz == null) {
                jXz = new f();
                jXA = new d(context);
            }
        }
    }

    public static synchronized f cDH() {
        f fVar;
        synchronized (f.class) {
            if (jXz == null) {
                b(com.baidu.ubs.analytics.d.cDF().getContext());
            }
            fVar = jXz;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cDI() {
        if (this.jXB.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Hn("***************新建立了 一个数据库的实例****************");
            this.jXC = jXA.getWritableDatabase();
        }
        return this.jXC;
    }
}
