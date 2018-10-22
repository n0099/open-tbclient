package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f hTE;
    private static SQLiteOpenHelper hTF;
    private AtomicInteger hTG = new AtomicInteger();
    private SQLiteDatabase hTH;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (hTE == null) {
                hTE = new f();
                hTF = new d(context);
            }
        }
    }

    public static synchronized f bQh() {
        f fVar;
        synchronized (f.class) {
            if (hTE == null) {
                b(com.baidu.ubs.analytics.d.bQf().getContext());
            }
            fVar = hTE;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.hTG.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.xS("***************新建立了 一个数据库的实例****************");
            this.hTH = hTF.getWritableDatabase();
        }
        return this.hTH;
    }
}
