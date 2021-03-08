package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
final class f {
    private static f oWn;
    private static SQLiteOpenHelper oWo;
    private AtomicInteger oWp = new AtomicInteger();
    private SQLiteDatabase oWq;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oWn == null) {
                oWn = new f();
                oWo = new d(context);
            }
        }
    }

    public static synchronized f eir() {
        f fVar;
        synchronized (f.class) {
            if (oWn == null) {
                b(com.baidu.ubs.analytics.d.eip().getContext());
            }
            fVar = oWn;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase atd() {
        if (this.oWp.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.XX("***************新建立了 一个数据库的实例****************");
            this.oWq = oWo.getWritableDatabase();
        }
        return this.oWq;
    }
}
