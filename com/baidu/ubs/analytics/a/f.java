package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f kXE;
    private static SQLiteOpenHelper kXF;
    private AtomicInteger kXG = new AtomicInteger();
    private SQLiteDatabase kXH;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (kXE == null) {
                kXE = new f();
                kXF = new d(context);
            }
        }
    }

    public static synchronized f cXP() {
        f fVar;
        synchronized (f.class) {
            if (kXE == null) {
                b(com.baidu.ubs.analytics.d.cXN().getContext());
            }
            fVar = kXE;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cXQ() {
        if (this.kXG.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Lr("***************新建立了 一个数据库的实例****************");
            this.kXH = kXF.getWritableDatabase();
        }
        return this.kXH;
    }
}
