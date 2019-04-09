package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jwA;
    private static SQLiteOpenHelper jwB;
    private AtomicInteger jwC = new AtomicInteger();
    private SQLiteDatabase jwD;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jwA == null) {
                jwA = new f();
                jwB = new d(context);
            }
        }
    }

    public static synchronized f csq() {
        f fVar;
        synchronized (f.class) {
            if (jwA == null) {
                b(com.baidu.ubs.analytics.d.cso().getContext());
            }
            fVar = jwA;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.jwC.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.EV("***************新建立了 一个数据库的实例****************");
            this.jwD = jwB.getWritableDatabase();
        }
        return this.jwD;
    }
}
