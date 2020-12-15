package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
final class f {
    private static f oHV;
    private static SQLiteOpenHelper oHW;
    private AtomicInteger oHX = new AtomicInteger();
    private SQLiteDatabase oHY;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oHV == null) {
                oHV = new f();
                oHW = new d(context);
            }
        }
    }

    public static synchronized f ejq() {
        f fVar;
        synchronized (f.class) {
            if (oHV == null) {
                b(com.baidu.ubs.analytics.d.ejo().getContext());
            }
            fVar = oHV;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase avd() {
        if (this.oHX.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Ye("***************新建立了 一个数据库的实例****************");
            this.oHY = oHW.getWritableDatabase();
        }
        return this.oHY;
    }
}
