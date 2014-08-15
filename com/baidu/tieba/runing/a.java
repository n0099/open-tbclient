package com.baidu.tieba.runing;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private long b = 0;
    @SuppressLint({"HandlerLeak"})
    private final Handler c = new b(this);
    private com.baidu.adp.framework.listener.d d = new c(this, 303005);

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public a() {
        MessageManager.getInstance().registerListener(this.d);
    }

    public void b() {
        this.b = 0L;
        d();
        c();
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis() - this.b;
        long j = currentTimeMillis > 0 ? currentTimeMillis : 0L;
        if (j >= 1800000) {
            this.c.sendMessageDelayed(this.c.obtainMessage(1), 10000L);
        } else {
            this.c.sendMessageDelayed(this.c.obtainMessage(1), 1800000 - j);
        }
        this.b = System.currentTimeMillis();
    }

    public void d() {
        this.c.removeMessages(1);
        this.c.removeMessages(2);
    }
}
