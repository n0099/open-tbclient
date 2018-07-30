package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
final class f {
    private static f hCm;
    private static SQLiteOpenHelper hCn;
    private AtomicInteger hCo = new AtomicInteger();
    private SQLiteDatabase hCp;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hCm == null) {
                hCm = new f();
                hCn = new d(context);
            }
        }
    }

    public static synchronized f bIW() {
        f fVar;
        synchronized (f.class) {
            if (hCm == null) {
                b(com.baidu.ubs.analytics.d.bIU().getContext());
            }
            fVar = hCm;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hCo.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.wd("***************新建立了 一个数据库的实例****************");
            this.hCp = hCn.getWritableDatabase();
        }
        return this.hCp;
    }
}
