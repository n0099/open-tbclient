package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f kVc;
    private static SQLiteOpenHelper kVd;
    private AtomicInteger kVe = new AtomicInteger();
    private SQLiteDatabase kVf;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (kVc == null) {
                kVc = new f();
                kVd = new d(context);
            }
        }
    }

    public static synchronized f cVY() {
        f fVar;
        synchronized (f.class) {
            if (kVc == null) {
                b(com.baidu.ubs.analytics.d.cVW().getContext());
            }
            fVar = kVc;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cVZ() {
        if (this.kVe.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Le("***************新建立了 一个数据库的实例****************");
            this.kVf = kVd.getWritableDatabase();
        }
        return this.kVf;
    }
}
