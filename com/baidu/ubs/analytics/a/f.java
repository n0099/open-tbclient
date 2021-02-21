package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes15.dex */
final class f {
    private static f oUi;
    private static SQLiteOpenHelper oUj;
    private AtomicInteger oUk = new AtomicInteger();
    private SQLiteDatabase oUl;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (oUi == null) {
                oUi = new f();
                oUj = new d(context);
            }
        }
    }

    public static synchronized f eii() {
        f fVar;
        synchronized (f.class) {
            if (oUi == null) {
                b(com.baidu.ubs.analytics.d.eih().getContext());
            }
            fVar = oUi;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase ata() {
        if (this.oUk.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.XQ("***************新建立了 一个数据库的实例****************");
            this.oUl = oUj.getWritableDatabase();
        }
        return this.oUl;
    }
}
