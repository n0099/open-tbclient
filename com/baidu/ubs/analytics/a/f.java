package com.baidu.ubs.analytics.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
final class f {
    private static f mEJ;
    private static SQLiteOpenHelper mEK;
    private AtomicInteger mEL = new AtomicInteger();
    private SQLiteDatabase mEM;

    f() {
    }

    private static synchronized void b(Context context) {
        synchronized (f.class) {
            if (mEJ == null) {
                mEJ = new f();
                mEK = new d(context);
            }
        }
    }

    public static synchronized f dxj() {
        f fVar;
        synchronized (f.class) {
            if (mEJ == null) {
                b(com.baidu.ubs.analytics.d.dxh().getContext());
            }
            fVar = mEJ;
        }
        return fVar;
    }

    public final synchronized SQLiteDatabase dxk() {
        if (this.mEL.incrementAndGet() == 1) {
            com.baidu.ubs.analytics.d.b.H("***************新建立了 一个数据库的实例****************");
            this.mEM = mEK.getWritableDatabase();
        }
        return this.mEM;
    }
}
