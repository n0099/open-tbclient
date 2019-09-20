package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jZW;
    private static SQLiteOpenHelper jZX;
    private AtomicInteger jZY = new AtomicInteger();
    private SQLiteDatabase jZZ;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jZW == null) {
                jZW = new f();
                jZX = new d(context);
            }
        }
    }

    public static synchronized f cEv() {
        f fVar;
        synchronized (f.class) {
            if (jZW == null) {
                b(com.baidu.ubs.analytics.d.cEt().getContext());
            }
            fVar = jZW;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cEw() {
        if (this.jZY.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.HN("***************新建立了 一个数据库的实例****************");
            this.jZZ = jZX.getWritableDatabase();
        }
        return this.jZZ;
    }
}
