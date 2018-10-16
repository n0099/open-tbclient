package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f hTD;
    private static SQLiteOpenHelper hTE;
    private AtomicInteger hTF = new AtomicInteger();
    private SQLiteDatabase hTG;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hTD == null) {
                hTD = new f();
                hTE = new d(context);
            }
        }
    }

    public static synchronized f bQh() {
        f fVar;
        synchronized (f.class) {
            if (hTD == null) {
                b(com.baidu.ubs.analytics.d.bQf().getContext());
            }
            fVar = hTD;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hTF.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.xS("***************新建立了 一个数据库的实例****************");
            this.hTG = hTE.getWritableDatabase();
        }
        return this.hTG;
    }
}
