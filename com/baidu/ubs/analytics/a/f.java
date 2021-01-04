package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f oOe;
    private static SQLiteOpenHelper oOf;
    private AtomicInteger oOg = new AtomicInteger();
    private SQLiteDatabase oOh;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oOe == null) {
                oOe = new f();
                oOf = new d(context);
            }
        }
    }

    public static synchronized f ejz() {
        f fVar;
        synchronized (f.class) {
            if (oOe == null) {
                b(com.baidu.ubs.analytics.d.ejy().getContext());
            }
            fVar = oOe;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase awv() {
        if (this.oOg.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.XN("***************新建立了 一个数据库的实例****************");
            this.oOh = oOf.getWritableDatabase();
        }
        return this.oOh;
    }
}
