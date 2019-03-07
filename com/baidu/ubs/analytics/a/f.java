package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jwy;
    private static SQLiteOpenHelper jwz;
    private AtomicInteger jwA = new AtomicInteger();
    private SQLiteDatabase jwB;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jwy == null) {
                jwy = new f();
                jwz = new d(context);
            }
        }
    }

    public static synchronized f csf() {
        f fVar;
        synchronized (f.class) {
            if (jwy == null) {
                b(com.baidu.ubs.analytics.d.csd().getContext());
            }
            fVar = jwy;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.jwA.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.EV("***************新建立了 一个数据库的实例****************");
            this.jwB = jwz.getWritableDatabase();
        }
        return this.jwB;
    }
}
