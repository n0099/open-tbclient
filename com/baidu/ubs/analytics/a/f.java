package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f igS;
    private static SQLiteOpenHelper igT;
    private AtomicInteger igU = new AtomicInteger();
    private SQLiteDatabase igV;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (igS == null) {
                igS = new f();
                igT = new d(context);
            }
        }
    }

    public static synchronized f bTj() {
        f fVar;
        synchronized (f.class) {
            if (igS == null) {
                b(com.baidu.ubs.analytics.d.bTh().getContext());
            }
            fVar = igS;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.igU.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.yT("***************新建立了 一个数据库的实例****************");
            this.igV = igT.getWritableDatabase();
        }
        return this.igV;
    }
}
