package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
final class f {
    private static f hCo;
    private static SQLiteOpenHelper hCp;
    private AtomicInteger hCq = new AtomicInteger();
    private SQLiteDatabase hCr;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hCo == null) {
                hCo = new f();
                hCp = new d(context);
            }
        }
    }

    public static synchronized f bJa() {
        f fVar;
        synchronized (f.class) {
            if (hCo == null) {
                b(com.baidu.ubs.analytics.d.bIY().getContext());
            }
            fVar = hCo;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hCq.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.wh("***************新建立了 一个数据库的实例****************");
            this.hCr = hCp.getWritableDatabase();
        }
        return this.hCr;
    }
}
