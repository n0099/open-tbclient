package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
final class f {
    private static f mMP;
    private static SQLiteOpenHelper mMQ;
    private AtomicInteger mMR = new AtomicInteger();
    private SQLiteDatabase mMS;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (mMP == null) {
                mMP = new f();
                mMQ = new d(context);
            }
        }
    }

    public static synchronized f dAx() {
        f fVar;
        synchronized (f.class) {
            if (mMP == null) {
                b(com.baidu.ubs.analytics.d.dAv().getContext());
            }
            fVar = mMP;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase aec() {
        if (this.mMR.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.mMS = mMQ.getWritableDatabase();
        }
        return this.mMS;
    }
}
