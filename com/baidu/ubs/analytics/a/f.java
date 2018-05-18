package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class f {
    private static f hlF;
    private static SQLiteOpenHelper hlG;
    private AtomicInteger hlH = new AtomicInteger();
    private SQLiteDatabase hlI;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hlF == null) {
                hlF = new f();
                hlG = new d(context);
            }
        }
    }

    public static synchronized f bEN() {
        f fVar;
        synchronized (f.class) {
            if (hlF == null) {
                b(com.baidu.ubs.analytics.d.bEL().getContext());
            }
            fVar = hlF;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hlH.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.vm("***************新建立了 一个数据库的实例****************");
            this.hlI = hlG.getWritableDatabase();
        }
        return this.hlI;
    }
}
