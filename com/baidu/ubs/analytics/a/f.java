package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static SQLiteOpenHelper jwA;
    private static f jwz;
    private AtomicInteger jwB = new AtomicInteger();
    private SQLiteDatabase jwC;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jwz == null) {
                jwz = new f();
                jwA = new d(context);
            }
        }
    }

    public static synchronized f csq() {
        f fVar;
        synchronized (f.class) {
            if (jwz == null) {
                b(com.baidu.ubs.analytics.d.cso().getContext());
            }
            fVar = jwz;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.jwB.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.EV("***************新建立了 一个数据库的实例****************");
            this.jwC = jwA.getWritableDatabase();
        }
        return this.jwC;
    }
}
