package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f lOi;
    private static SQLiteOpenHelper lOj;
    private AtomicInteger lOk = new AtomicInteger();
    private SQLiteDatabase lOl;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (lOi == null) {
                lOi = new f();
                lOj = new d(context);
            }
        }
    }

    public static synchronized f dkY() {
        f fVar;
        synchronized (f.class) {
            if (lOi == null) {
                b(com.baidu.ubs.analytics.d.dkW().getContext());
            }
            fVar = lOi;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase dkZ() {
        if (this.lOk.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.lOl = lOj.getWritableDatabase();
        }
        return this.lOl;
    }
}
