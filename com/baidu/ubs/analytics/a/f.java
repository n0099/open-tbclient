package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f miN;
    private static SQLiteOpenHelper miO;
    private AtomicInteger miP = new AtomicInteger();
    private SQLiteDatabase miQ;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (miN == null) {
                miN = new f();
                miO = new d(context);
            }
        }
    }

    public static synchronized f dsA() {
        f fVar;
        synchronized (f.class) {
            if (miN == null) {
                b(com.baidu.ubs.analytics.d.dsy().getContext());
            }
            fVar = miN;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase dsB() {
        if (this.miP.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.miQ = miO.getWritableDatabase();
        }
        return this.miQ;
    }
}
