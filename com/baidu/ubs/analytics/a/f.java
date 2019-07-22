package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jWt;
    private static SQLiteOpenHelper jWu;
    private AtomicInteger jWv = new AtomicInteger();
    private SQLiteDatabase jWw;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jWt == null) {
                jWt = new f();
                jWu = new d(context);
            }
        }
    }

    public static synchronized f cDm() {
        f fVar;
        synchronized (f.class) {
            if (jWt == null) {
                b(com.baidu.ubs.analytics.d.cDk().getContext());
            }
            fVar = jWt;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cDn() {
        if (this.jWv.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Hm("***************新建立了 一个数据库的实例****************");
            this.jWw = jWu.getWritableDatabase();
        }
        return this.jWw;
    }
}
