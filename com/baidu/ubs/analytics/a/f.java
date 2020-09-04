package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
final class f {
    private static f ngd;
    private static SQLiteOpenHelper nge;
    private AtomicInteger ngf = new AtomicInteger();
    private SQLiteDatabase ngg;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (ngd == null) {
                ngd = new f();
                nge = new d(context);
            }
        }
    }

    public static synchronized f dMt() {
        f fVar;
        synchronized (f.class) {
            if (ngd == null) {
                b(com.baidu.ubs.analytics.d.dMr().getContext());
            }
            fVar = ngd;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase akM() {
        if (this.ngf.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.ngg = nge.getWritableDatabase();
        }
        return this.ngg;
    }
}
