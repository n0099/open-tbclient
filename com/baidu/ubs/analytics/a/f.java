package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f hVo;
    private static SQLiteOpenHelper hVp;
    private AtomicInteger hVq = new AtomicInteger();
    private SQLiteDatabase hVr;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hVo == null) {
                hVo = new f();
                hVp = new d(context);
            }
        }
    }

    public static synchronized f bPF() {
        f fVar;
        synchronized (f.class) {
            if (hVo == null) {
                b(com.baidu.ubs.analytics.d.bPD().getContext());
            }
            fVar = hVo;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hVq.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.xX("***************新建立了 一个数据库的实例****************");
            this.hVr = hVp.getWritableDatabase();
        }
        return this.hVr;
    }
}
