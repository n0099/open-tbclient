package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
final class f {
    private static f osK;
    private static SQLiteOpenHelper osL;
    private AtomicInteger osM = new AtomicInteger();
    private SQLiteDatabase osN;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (osK == null) {
                osK = new f();
                osL = new d(context);
            }
        }
    }

    public static synchronized f edB() {
        f fVar;
        synchronized (f.class) {
            if (osK == null) {
                b(com.baidu.ubs.analytics.d.edz().getContext());
            }
            fVar = osK;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase arU() {
        if (this.osM.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.osN = osL.getWritableDatabase();
        }
        return this.osN;
    }
}
