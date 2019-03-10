package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jwR;
    private static SQLiteOpenHelper jwS;
    private AtomicInteger jwT = new AtomicInteger();
    private SQLiteDatabase jwU;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jwR == null) {
                jwR = new f();
                jwS = new d(context);
            }
        }
    }

    public static synchronized f csp() {
        f fVar;
        synchronized (f.class) {
            if (jwR == null) {
                b(com.baidu.ubs.analytics.d.csn().getContext());
            }
            fVar = jwR;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.jwT.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.EY("***************新建立了 一个数据库的实例****************");
            this.jwU = jwS.getWritableDatabase();
        }
        return this.jwU;
    }
}
