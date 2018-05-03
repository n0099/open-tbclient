package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class f {
    private static f hkB;
    private static SQLiteOpenHelper hkC;
    private AtomicInteger hkD = new AtomicInteger();
    private SQLiteDatabase hkE;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hkB == null) {
                hkB = new f();
                hkC = new d(context);
            }
        }
    }

    public static synchronized f bEP() {
        f fVar;
        synchronized (f.class) {
            if (hkB == null) {
                b(com.baidu.ubs.analytics.d.bEN().getContext());
            }
            fVar = hkB;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hkD.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.vj("***************新建立了 一个数据库的实例****************");
            this.hkE = hkC.getWritableDatabase();
        }
        return this.hkE;
    }
}
