package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes17.dex */
public final class c {
    private long e;
    private Context mContext;
    private long osA;
    private long osB;
    private boolean osC;
    private int osD;
    private boolean osz;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.osz = aVar.osz;
        this.e = aVar.osE;
        this.osA = aVar.osA;
        this.osC = aVar.osC;
        this.osB = aVar.osB;
        this.osD = aVar.osD;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.osz;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.osA;
    }

    public final long f() {
        return this.osB;
    }

    public final boolean g() {
        return this.osC;
    }

    public final int h() {
        return this.osD;
    }

    /* loaded from: classes17.dex */
    public static class a {
        private Context mContext;
        private boolean osz = true;
        private long osE = 30000;
        private long osA = 60000;
        private long osB = 10000;
        private boolean osC = false;
        private int osD = 1000;

        public a go(Context context) {
            this.mContext = context;
            return this;
        }

        public a zH(boolean z) {
            this.osz = z;
            return this;
        }

        public a hs(long j) {
            this.osE = 1000 * j;
            return this;
        }

        public a NM(int i) {
            this.osA = i * 60 * 1000;
            return this;
        }

        public a ht(long j) {
            this.osB = 1000 * j;
            return this;
        }

        public a zI(boolean z) {
            this.osC = z;
            return this;
        }

        public a NN(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.osD = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c edx() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
