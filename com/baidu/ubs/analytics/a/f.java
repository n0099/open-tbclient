package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f ifL;
    private static SQLiteOpenHelper ifM;
    private AtomicInteger ifN = new AtomicInteger();
    private SQLiteDatabase ifO;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (ifL == null) {
                ifL = new f();
                ifM = new d(context);
            }
        }
    }

    public static synchronized f bSB() {
        f fVar;
        synchronized (f.class) {
            if (ifL == null) {
                b(com.baidu.ubs.analytics.d.bSz().getContext());
            }
            fVar = ifL;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.ifN.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.yD("***************新建立了 一个数据库的实例****************");
            this.ifO = ifM.getWritableDatabase();
        }
        return this.ifO;
    }
}
