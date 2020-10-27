package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
final class f {
    private static f oib;
    private static SQLiteOpenHelper oic;
    private AtomicInteger oid = new AtomicInteger();
    private SQLiteDatabase oie;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oib == null) {
                oib = new f();
                oic = new d(context);
            }
        }
    }

    public static synchronized f dZU() {
        f fVar;
        synchronized (f.class) {
            if (oib == null) {
                b(com.baidu.ubs.analytics.d.dZS().getContext());
            }
            fVar = oib;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase aqc() {
        if (this.oid.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.oie = oic.getWritableDatabase();
        }
        return this.oie;
    }
}
