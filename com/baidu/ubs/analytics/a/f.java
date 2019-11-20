package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jXe;
    private static SQLiteOpenHelper jXf;
    private AtomicInteger jXg = new AtomicInteger();
    private SQLiteDatabase jXh;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jXe == null) {
                jXe = new f();
                jXf = new d(context);
            }
        }
    }

    public static synchronized f cBd() {
        f fVar;
        synchronized (f.class) {
            if (jXe == null) {
                b(com.baidu.ubs.analytics.d.cBb().getContext());
            }
            fVar = jXe;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cBe() {
        if (this.jXg.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Ge("***************新建立了 一个数据库的实例****************");
            this.jXh = jXf.getWritableDatabase();
        }
        return this.jXh;
    }
}
