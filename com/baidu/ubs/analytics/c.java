package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes5.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean nfA;
    private long nfB;
    private long nfC;
    private boolean nfD;
    private int nfE;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.nfA = aVar.nfA;
        this.e = aVar.nfF;
        this.nfB = aVar.nfB;
        this.nfD = aVar.nfD;
        this.nfC = aVar.nfC;
        this.nfE = aVar.nfE;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.nfA;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.nfB;
    }

    public final long f() {
        return this.nfC;
    }

    public final boolean g() {
        return this.nfD;
    }

    public final int h() {
        return this.nfE;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private Context mContext;
        private boolean nfA = true;
        private long nfF = 30000;
        private long nfB = 60000;
        private long nfC = 10000;
        private boolean nfD = false;
        private int nfE = 1000;

        public a fZ(Context context) {
            this.mContext = context;
            return this;
        }

        public a xH(boolean z) {
            this.nfA = z;
            return this;
        }

        public a ge(long j) {
            this.nfF = 1000 * j;
            return this;
        }

        public a KD(int i) {
            this.nfB = i * 60 * 1000;
            return this;
        }

        public a gf(long j) {
            this.nfC = 1000 * j;
            return this;
        }

        public a xI(boolean z) {
            this.nfD = z;
            return this;
        }

        public a KE(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.nfE = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dMg() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
