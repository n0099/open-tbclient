package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
final class f {
    private static f jwJ;
    private static SQLiteOpenHelper jwK;
    private AtomicInteger jwL = new AtomicInteger();
    private SQLiteDatabase jwM;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (jwJ == null) {
                jwJ = new f();
                jwK = new d(context);
            }
        }
    }

    public static synchronized f css() {
        f fVar;
        synchronized (f.class) {
            if (jwJ == null) {
                b(com.baidu.ubs.analytics.d.csq().getContext());
            }
            fVar = jwJ;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase getDatabase() {
        if (this.jwL.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.EW("***************新建立了 一个数据库的实例****************");
            this.jwM = jwK.getWritableDatabase();
        }
        return this.jwM;
    }
}
