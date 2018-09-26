package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
final class f {
    private static f hKL;
    private static SQLiteOpenHelper hKM;
    private AtomicInteger hKN = new AtomicInteger();
    private SQLiteDatabase hKO;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hKL == null) {
                hKL = new f();
                hKM = new d(context);
            }
        }
    }

    public static synchronized f bLR() {
        f fVar;
        synchronized (f.class) {
            if (hKL == null) {
                b(com.baidu.ubs.analytics.d.bLP().getContext());
            }
            fVar = hKL;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hKN.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.wS("***************新建立了 一个数据库的实例****************");
            this.hKO = hKM.getWritableDatabase();
        }
        return this.hKO;
    }
}
