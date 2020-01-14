package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f kVh;
    private static SQLiteOpenHelper kVi;
    private AtomicInteger kVj = new AtomicInteger();
    private SQLiteDatabase kVk;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (kVh == null) {
                kVh = new f();
                kVi = new d(context);
            }
        }
    }

    public static synchronized f cWa() {
        f fVar;
        synchronized (f.class) {
            if (kVh == null) {
                b(com.baidu.ubs.analytics.d.cVY().getContext());
            }
            fVar = kVh;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cWb() {
        if (this.kVj.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Le("***************新建立了 一个数据库的实例****************");
            this.kVk = kVi.getWritableDatabase();
        }
        return this.kVk;
    }
}
