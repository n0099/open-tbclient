package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class f {
    private static f hxA;
    private static SQLiteOpenHelper hxB;
    private AtomicInteger hxC = new AtomicInteger();
    private SQLiteDatabase hxD;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hxA == null) {
                hxA = new f();
                hxB = new d(context);
            }
        }
    }

    public static synchronized f bJR() {
        f fVar;
        synchronized (f.class) {
            if (hxA == null) {
                b(com.baidu.ubs.analytics.d.bJP().getContext());
            }
            fVar = hxA;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hxC.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.wg("***************新建立了 一个数据库的实例****************");
            this.hxD = hxB.getWritableDatabase();
        }
        return this.hxD;
    }
}
