package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f kVN;
    private static SQLiteOpenHelper kVO;
    private AtomicInteger kVP = new AtomicInteger();
    private SQLiteDatabase kVQ;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (kVN == null) {
                kVN = new f();
                kVO = new d(context);
            }
        }
    }

    public static synchronized f cXo() {
        f fVar;
        synchronized (f.class) {
            if (kVN == null) {
                b(com.baidu.ubs.analytics.d.cXm().getContext());
            }
            fVar = kVN;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase cXp() {
        if (this.kVP.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.Lr("***************新建立了 一个数据库的实例****************");
            this.kVQ = kVO.getWritableDatabase();
        }
        return this.kVQ;
    }
}
