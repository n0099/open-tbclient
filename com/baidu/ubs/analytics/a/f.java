package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f mhB;
    private static SQLiteOpenHelper mhC;
    private AtomicInteger mhD = new AtomicInteger();
    private SQLiteDatabase mhE;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (mhB == null) {
                mhB = new f();
                mhC = new d(context);
            }
        }
    }

    public static synchronized f dsm() {
        f fVar;
        synchronized (f.class) {
            if (mhB == null) {
                b(com.baidu.ubs.analytics.d.dsk().getContext());
            }
            fVar = mhB;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase dsn() {
        if (this.mhD.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.mhE = mhC.getWritableDatabase();
        }
        return this.mhE;
    }
}
