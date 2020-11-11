package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
final class f {
    private static f orh;
    private static SQLiteOpenHelper ori;
    private AtomicInteger orj = new AtomicInteger();
    private SQLiteDatabase ork;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (orh == null) {
                orh = new f();
                ori = new d(context);
            }
        }
    }

    public static synchronized f edC() {
        f fVar;
        synchronized (f.class) {
            if (orh == null) {
                b(com.baidu.ubs.analytics.d.edA().getContext());
            }
            fVar = orh;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase asD() {
        if (this.orj.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.ork = ori.getWritableDatabase();
        }
        return this.ork;
    }
}
