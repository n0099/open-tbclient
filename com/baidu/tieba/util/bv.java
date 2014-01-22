package com.baidu.tieba.util;

import android.os.Handler;
import android.os.SystemClock;
/* loaded from: classes.dex */
public abstract class bv {
    private long a;
    private final long b;
    private long c;
    private Handler d = new bw(this);

    public abstract void a();

    public abstract void a(long j);

    public bv(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final void b() {
        this.d.removeMessages(1);
    }

    public final synchronized bv c() {
        bv bvVar;
        if (this.a <= 0) {
            a();
            bvVar = this;
        } else {
            this.c = SystemClock.elapsedRealtime() + this.a;
            this.d.sendMessage(this.d.obtainMessage(1));
            bvVar = this;
        }
        return bvVar;
    }
}
