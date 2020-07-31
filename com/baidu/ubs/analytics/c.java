package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean mMC;
    private long mMD;
    private long mME;
    private boolean mMF;
    private int mMG;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.mMC = aVar.mMC;
        this.e = aVar.mMH;
        this.mMD = aVar.mMD;
        this.mMF = aVar.mMF;
        this.mME = aVar.mME;
        this.mMG = aVar.mMG;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.mMC;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.mMD;
    }

    public final long f() {
        return this.mME;
    }

    public final boolean g() {
        return this.mMF;
    }

    public final int h() {
        return this.mMG;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean mMC = true;
        private long mMH = 30000;
        private long mMD = 60000;
        private long mME = 10000;
        private boolean mMF = false;
        private int mMG = 1000;

        public a fM(Context context) {
            this.mContext = context;
            return this;
        }

        public a wR(boolean z) {
            this.mMC = z;
            return this;
        }

        public a fS(long j) {
            this.mMH = 1000 * j;
            return this;
        }

        public a Id(int i) {
            this.mMD = i * 60 * 1000;
            return this;
        }

        public a fT(long j) {
            this.mME = 1000 * j;
            return this;
        }

        public a wS(boolean z) {
            this.mMF = z;
            return this;
        }

        public a Ie(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.mMG = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dAs() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
