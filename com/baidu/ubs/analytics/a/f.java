package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f kVP;
    private static SQLiteOpenHelper kVQ;
    private AtomicInteger kVR = new AtomicInteger();
    private SQLiteDatabase kVS;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (kVP == null) {
                kVP = new f();
                kVQ = new d(context);
            }
        }
    }

    public static synchronized f cXq() {
        f fVar;
        synchronized (f.class) {
            if (kVP == null) {
                b(com.baidu.ubs.analytics.d.cXo().getContext());
            }
            fVar = kVP;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cXr() {
        if (this.kVR.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Lr("***************新建立了 一个数据库的实例****************");
            this.kVS = kVQ.getWritableDatabase();
        }
        return this.kVS;
    }
}
