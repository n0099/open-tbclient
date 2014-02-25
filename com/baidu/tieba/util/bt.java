package com.baidu.tieba.util;

import android.os.Handler;
import android.os.SystemClock;
/* loaded from: classes.dex */
public abstract class bt {
    private long a;
    private final long b;
    private long c;
    private Handler d = new bu(this);

    public abstract void a();

    public abstract void a(long j);

    public bt(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final void b() {
        this.d.removeMessages(1);
    }

    public final synchronized bt c() {
        bt btVar;
        if (this.a <= 0) {
            a();
            btVar = this;
        } else {
            this.c = SystemClock.elapsedRealtime() + this.a;
            this.d.sendMessage(this.d.obtainMessage(1));
            btVar = this;
        }
        return btVar;
    }
}
