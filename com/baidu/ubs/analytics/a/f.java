package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class f {
    private static f hkE;
    private static SQLiteOpenHelper hkF;
    private AtomicInteger hkG = new AtomicInteger();
    private SQLiteDatabase hkH;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hkE == null) {
                hkE = new f();
                hkF = new d(context);
            }
        }
    }

    public static synchronized f bEP() {
        f fVar;
        synchronized (f.class) {
            if (hkE == null) {
                b(com.baidu.ubs.analytics.d.bEN().getContext());
            }
            fVar = hkE;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hkG.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.vj("***************新建立了 一个数据库的实例****************");
            this.hkH = hkF.getWritableDatabase();
        }
        return this.hkH;
    }
}
