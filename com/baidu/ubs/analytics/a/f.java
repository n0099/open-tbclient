package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
final class f {
    private static f kRB;
    private static SQLiteOpenHelper kRC;
    private AtomicInteger kRD = new AtomicInteger();
    private SQLiteDatabase kRE;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (kRB == null) {
                kRB = new f();
                kRC = new d(context);
            }
        }
    }

    public static synchronized f cUV() {
        f fVar;
        synchronized (f.class) {
            if (kRB == null) {
                b(com.baidu.ubs.analytics.d.cUT().getContext());
            }
            fVar = kRB;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cUW() {
        if (this.kRD.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.KU("***************新建立了 一个数据库的实例****************");
            this.kRE = kRC.getWritableDatabase();
        }
        return this.kRE;
    }
}
