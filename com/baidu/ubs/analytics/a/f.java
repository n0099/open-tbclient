package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jPu;
    private static SQLiteOpenHelper jPv;
    private AtomicInteger jPw = new AtomicInteger();
    private SQLiteDatabase jPx;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jPu == null) {
                jPu = new f();
                jPv = new d(context);
            }
        }
    }

    public static synchronized f cAo() {
        f fVar;
        synchronized (f.class) {
            if (jPu == null) {
                b(com.baidu.ubs.analytics.d.cAm().getContext());
            }
            fVar = jPu;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.jPw.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Gs("***************新建立了 一个数据库的实例****************");
            this.jPx = jPv.getWritableDatabase();
        }
        return this.jPx;
    }
}
