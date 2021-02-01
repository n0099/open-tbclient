package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes15.dex */
final class f {
    private static f oTI;
    private static SQLiteOpenHelper oTJ;
    private AtomicInteger oTK = new AtomicInteger();
    private SQLiteDatabase oTL;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oTI == null) {
                oTI = new f();
                oTJ = new d(context);
            }
        }
    }

    public static synchronized f eia() {
        f fVar;
        synchronized (f.class) {
            if (oTI == null) {
                b(com.baidu.ubs.analytics.d.ehZ().getContext());
            }
            fVar = oTI;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase ata() {
        if (this.oTK.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.XE("***************新建立了 一个数据库的实例****************");
            this.oTL = oTJ.getWritableDatabase();
        }
        return this.oTL;
    }
}
