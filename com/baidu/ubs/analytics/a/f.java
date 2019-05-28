package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jPr;
    private static SQLiteOpenHelper jPs;
    private AtomicInteger jPt = new AtomicInteger();
    private SQLiteDatabase jPu;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jPr == null) {
                jPr = new f();
                jPs = new d(context);
            }
        }
    }

    public static synchronized f cAp() {
        f fVar;
        synchronized (f.class) {
            if (jPr == null) {
                b(com.baidu.ubs.analytics.d.cAn().getContext());
            }
            fVar = jPr;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.jPt.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Gq("***************新建立了 一个数据库的实例****************");
            this.jPu = jPs.getWritableDatabase();
        }
        return this.jPu;
    }
}
