package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
final class f {
    private static f hBH;
    private static SQLiteOpenHelper hBI;
    private AtomicInteger hBJ = new AtomicInteger();
    private SQLiteDatabase hBK;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hBH == null) {
                hBH = new f();
                hBI = new d(context);
            }
        }
    }

    public static synchronized f bKs() {
        f fVar;
        synchronized (f.class) {
            if (hBH == null) {
                b(com.baidu.ubs.analytics.d.bKq().getContext());
            }
            fVar = hBH;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hBJ.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.wc("***************新建立了 一个数据库的实例****************");
            this.hBK = hBI.getWritableDatabase();
        }
        return this.hBK;
    }
}
