package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f lOm;
    private static SQLiteOpenHelper lOn;
    private AtomicInteger lOo = new AtomicInteger();
    private SQLiteDatabase lOp;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (lOm == null) {
                lOm = new f();
                lOn = new d(context);
            }
        }
    }

    public static synchronized f dkV() {
        f fVar;
        synchronized (f.class) {
            if (lOm == null) {
                b(com.baidu.ubs.analytics.d.dkT().getContext());
            }
            fVar = lOm;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase dkW() {
        if (this.lOo.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.lOp = lOn.getWritableDatabase();
        }
        return this.lOp;
    }
}
