package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
final class f {
    private static f oHT;
    private static SQLiteOpenHelper oHU;
    private AtomicInteger oHV = new AtomicInteger();
    private SQLiteDatabase oHW;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oHT == null) {
                oHT = new f();
                oHU = new d(context);
            }
        }
    }

    public static synchronized f ejp() {
        f fVar;
        synchronized (f.class) {
            if (oHT == null) {
                b(com.baidu.ubs.analytics.d.ejn().getContext());
            }
            fVar = oHT;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase avd() {
        if (this.oHV.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Ye("***************新建立了 一个数据库的实例****************");
            this.oHW = oHU.getWritableDatabase();
        }
        return this.oHW;
    }
}
