package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean mEv;
    private long mEw;
    private long mEx;
    private boolean mEy;
    private int mEz;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.mEv = aVar.mEv;
        this.e = aVar.mEA;
        this.mEw = aVar.mEw;
        this.mEy = aVar.mEy;
        this.mEx = aVar.mEx;
        this.mEz = aVar.mEz;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.mEv;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.mEw;
    }

    public final long f() {
        return this.mEx;
    }

    public final boolean g() {
        return this.mEy;
    }

    public final int h() {
        return this.mEz;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean mEv = true;
        private long mEA = 30000;
        private long mEw = 60000;
        private long mEx = 10000;
        private boolean mEy = false;
        private int mEz = 1000;

        public a fJ(Context context) {
            this.mContext = context;
            return this;
        }

        public a wm(boolean z) {
            this.mEv = z;
            return this;
        }

        public a fF(long j) {
            this.mEA = 1000 * j;
            return this;
        }

        public a HI(int i) {
            this.mEw = i * 60 * 1000;
            return this;
        }

        public a fG(long j) {
            this.mEx = 1000 * j;
            return this;
        }

        public a wn(boolean z) {
            this.mEy = z;
            return this;
        }

        public a HJ(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.mEz = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dxb() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
