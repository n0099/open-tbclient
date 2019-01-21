package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f igT;
    private static SQLiteOpenHelper igU;
    private AtomicInteger igV = new AtomicInteger();
    private SQLiteDatabase igW;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (igT == null) {
                igT = new f();
                igU = new d(context);
            }
        }
    }

    public static synchronized f bTj() {
        f fVar;
        synchronized (f.class) {
            if (igT == null) {
                b(com.baidu.ubs.analytics.d.bTh().getContext());
            }
            fVar = igT;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.igV.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.yT("***************新建立了 一个数据库的实例****************");
            this.igW = igU.getWritableDatabase();
        }
        return this.igW;
    }
}
