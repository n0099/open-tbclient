package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
final class f {
    private static f nqf;
    private static SQLiteOpenHelper nqg;
    private AtomicInteger nqh = new AtomicInteger();
    private SQLiteDatabase nqi;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (nqf == null) {
                nqf = new f();
                nqg = new d(context);
            }
        }
    }

    public static synchronized f dQr() {
        f fVar;
        synchronized (f.class) {
            if (nqf == null) {
                b(com.baidu.ubs.analytics.d.dQp().getContext());
            }
            fVar = nqf;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase alw() {
        if (this.nqh.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.nqi = nqg.getWritableDatabase();
        }
        return this.nqi;
    }
}
