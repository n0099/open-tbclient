package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
final class f {
    private static SQLiteOpenHelper nFA;
    private static f nFz;
    private AtomicInteger nFB = new AtomicInteger();
    private SQLiteDatabase nFC;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (nFz == null) {
                nFz = new f();
                nFA = new d(context);
            }
        }
    }

    public static synchronized f dUc() {
        f fVar;
        synchronized (f.class) {
            if (nFz == null) {
                b(com.baidu.ubs.analytics.d.dUa().getContext());
            }
            fVar = nFz;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase aoh() {
        if (this.nFB.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.nFC = nFA.getWritableDatabase();
        }
        return this.nFC;
    }
}
