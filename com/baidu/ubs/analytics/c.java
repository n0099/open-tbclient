package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean mME;
    private long mMF;
    private long mMG;
    private boolean mMH;
    private int mMI;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.mME = aVar.mME;
        this.e = aVar.mMJ;
        this.mMF = aVar.mMF;
        this.mMH = aVar.mMH;
        this.mMG = aVar.mMG;
        this.mMI = aVar.mMI;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.mME;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.mMF;
    }

    public final long f() {
        return this.mMG;
    }

    public final boolean g() {
        return this.mMH;
    }

    public final int h() {
        return this.mMI;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean mME = true;
        private long mMJ = 30000;
        private long mMF = 60000;
        private long mMG = 10000;
        private boolean mMH = false;
        private int mMI = 1000;

        public a fM(Context context) {
            this.mContext = context;
            return this;
        }

        public a wR(boolean z) {
            this.mME = z;
            return this;
        }

        public a fS(long j) {
            this.mMJ = 1000 * j;
            return this;
        }

        public a Id(int i) {
            this.mMF = i * 60 * 1000;
            return this;
        }

        public a fT(long j) {
            this.mMG = 1000 * j;
            return this;
        }

        public a wS(boolean z) {
            this.mMH = z;
            return this;
        }

        public a Ie(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.mMI = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dAt() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
