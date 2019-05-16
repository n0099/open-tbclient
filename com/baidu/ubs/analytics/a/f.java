package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jPq;
    private static SQLiteOpenHelper jPr;
    private AtomicInteger jPs = new AtomicInteger();
    private SQLiteDatabase jPt;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jPq == null) {
                jPq = new f();
                jPr = new d(context);
            }
        }
    }

    public static synchronized f cAn() {
        f fVar;
        synchronized (f.class) {
            if (jPq == null) {
                b(com.baidu.ubs.analytics.d.cAl().getContext());
            }
            fVar = jPq;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.jPs.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Gq("***************新建立了 一个数据库的实例****************");
            this.jPt = jPr.getWritableDatabase();
        }
        return this.jPt;
    }
}
