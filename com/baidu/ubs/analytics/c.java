package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean kUR;
    private long kUS;
    private long kUT;
    private boolean kUU;
    private int kUV;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.kUR = aVar.kUR;
        this.e = aVar.kUW;
        this.kUS = aVar.kUS;
        this.kUU = aVar.kUU;
        this.kUT = aVar.kUT;
        this.kUV = aVar.kUV;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.kUR;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.kUS;
    }

    public final long f() {
        return this.kUT;
    }

    public final boolean g() {
        return this.kUU;
    }

    public final int h() {
        return this.kUV;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean kUR = true;
        private long kUW = 30000;
        private long kUS = 60000;
        private long kUT = 10000;
        private boolean kUU = false;
        private int kUV = 1000;

        public a fM(Context context) {
            this.mContext = context;
            return this;
        }

        public a tU(boolean z) {
            this.kUR = z;
            return this;
        }

        public a eL(long j) {
            this.kUW = 1000 * j;
            return this;
        }

        public a Ev(int i) {
            this.kUS = i * 60 * 1000;
            return this;
        }

        public a eM(long j) {
            this.kUT = 1000 * j;
            return this;
        }

        public a tV(boolean z) {
            this.kUU = z;
            return this;
        }

        public a Ew(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.kUV = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cVV() {
            if (this.mContext == null) {
                j.Lf("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
