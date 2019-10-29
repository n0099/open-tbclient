package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jXV;
    private static SQLiteOpenHelper jXW;
    private AtomicInteger jXX = new AtomicInteger();
    private SQLiteDatabase jXY;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jXV == null) {
                jXV = new f();
                jXW = new d(context);
            }
        }
    }

    public static synchronized f cBf() {
        f fVar;
        synchronized (f.class) {
            if (jXV == null) {
                b(com.baidu.ubs.analytics.d.cBd().getContext());
            }
            fVar = jXV;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cBg() {
        if (this.jXX.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Ge("***************新建立了 一个数据库的实例****************");
            this.jXY = jXW.getWritableDatabase();
        }
        return this.jXY;
    }
}
