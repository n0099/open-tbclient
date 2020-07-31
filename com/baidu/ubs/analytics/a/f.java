package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f mMN;
    private static SQLiteOpenHelper mMO;
    private AtomicInteger mMP = new AtomicInteger();
    private SQLiteDatabase mMQ;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (mMN == null) {
                mMN = new f();
                mMO = new d(context);
            }
        }
    }

    public static synchronized f dAw() {
        f fVar;
        synchronized (f.class) {
            if (mMN == null) {
                b(com.baidu.ubs.analytics.d.dAu().getContext());
            }
            fVar = mMN;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase aec() {
        if (this.mMP.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.mMQ = mMO.getWritableDatabase();
        }
        return this.mMQ;
    }
}
