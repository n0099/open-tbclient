package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private Context mContext;
    private long mEA;
    private boolean mEB;
    private int mEC;
    private boolean mEy;
    private long mEz;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.mEy = aVar.mEy;
        this.e = aVar.mED;
        this.mEz = aVar.mEz;
        this.mEB = aVar.mEB;
        this.mEA = aVar.mEA;
        this.mEC = aVar.mEC;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.mEy;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.mEz;
    }

    public final long f() {
        return this.mEA;
    }

    public final boolean g() {
        return this.mEB;
    }

    public final int h() {
        return this.mEC;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean mEy = true;
        private long mED = 30000;
        private long mEz = 60000;
        private long mEA = 10000;
        private boolean mEB = false;
        private int mEC = 1000;

        public a fJ(Context context) {
            this.mContext = context;
            return this;
        }

        public a wm(boolean z) {
            this.mEy = z;
            return this;
        }

        public a fF(long j) {
            this.mED = 1000 * j;
            return this;
        }

        public a HI(int i) {
            this.mEz = i * 60 * 1000;
            return this;
        }

        public a fG(long j) {
            this.mEA = 1000 * j;
            return this;
        }

        public a wn(boolean z) {
            this.mEB = z;
            return this;
        }

        public a HJ(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.mEC = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dxf() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
