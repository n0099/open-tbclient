package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f icy;
    private static SQLiteOpenHelper icz;
    private AtomicInteger icA = new AtomicInteger();
    private SQLiteDatabase icB;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (icy == null) {
                icy = new f();
                icz = new d(context);
            }
        }
    }

    public static synchronized f bRK() {
        f fVar;
        synchronized (f.class) {
            if (icy == null) {
                b(com.baidu.ubs.analytics.d.bRI().getContext());
            }
            fVar = icy;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.icA.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.yA("***************新建立了 一个数据库的实例****************");
            this.icB = icz.getWritableDatabase();
        }
        return this.icB;
    }
}
