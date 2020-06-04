package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean miC;
    private long miD;
    private long miE;
    private boolean miF;
    private int miG;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.miC = aVar.miC;
        this.e = aVar.miH;
        this.miD = aVar.miD;
        this.miF = aVar.miF;
        this.miE = aVar.miE;
        this.miG = aVar.miG;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.miC;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.miD;
    }

    public final long f() {
        return this.miE;
    }

    public final boolean g() {
        return this.miF;
    }

    public final int h() {
        return this.miG;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean miC = true;
        private long miH = 30000;
        private long miD = 60000;
        private long miE = 10000;
        private boolean miF = false;
        private int miG = 1000;

        public a fI(Context context) {
            this.mContext = context;
            return this;
        }

        public a vQ(boolean z) {
            this.miC = z;
            return this;
        }

        public a fA(long j) {
            this.miH = 1000 * j;
            return this;
        }

        public a GB(int i) {
            this.miD = i * 60 * 1000;
            return this;
        }

        public a fB(long j) {
            this.miE = 1000 * j;
            return this;
        }

        public a vR(boolean z) {
            this.miF = z;
            return this;
        }

        public a GC(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.miG = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dsw() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
