package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
final class f {
    private static f nfL;
    private static SQLiteOpenHelper nfM;
    private AtomicInteger nfN = new AtomicInteger();
    private SQLiteDatabase nfO;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (nfL == null) {
                nfL = new f();
                nfM = new d(context);
            }
        }
    }

    public static synchronized f dMk() {
        f fVar;
        synchronized (f.class) {
            if (nfL == null) {
                b(com.baidu.ubs.analytics.d.dMi().getContext());
            }
            fVar = nfL;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase akM() {
        if (this.nfN.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.nfO = nfM.getWritableDatabase();
        }
        return this.nfO;
    }
}
