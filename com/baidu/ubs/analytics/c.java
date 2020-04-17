package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private boolean lNX;
    private long lNY;
    private long lNZ;
    private boolean lOa;
    private int lOb;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.lNX = aVar.lNX;
        this.e = aVar.lOc;
        this.lNY = aVar.lNY;
        this.lOa = aVar.lOa;
        this.lNZ = aVar.lNZ;
        this.lOb = aVar.lOb;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.lNX;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.lNY;
    }

    public final long f() {
        return this.lNZ;
    }

    public final boolean g() {
        return this.lOa;
    }

    public final int h() {
        return this.lOb;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean lNX = true;
        private long lOc = 30000;
        private long lNY = 60000;
        private long lNZ = 10000;
        private boolean lOa = false;
        private int lOb = 1000;

        public a fF(Context context) {
            this.mContext = context;
            return this;
        }

        public a vq(boolean z) {
            this.lNX = z;
            return this;
        }

        public a fA(long j) {
            this.lOc = 1000 * j;
            return this;
        }

        public a FM(int i) {
            this.lNY = i * 60 * 1000;
            return this;
        }

        public a fB(long j) {
            this.lNZ = 1000 * j;
            return this;
        }

        public a vr(boolean z) {
            this.lOa = z;
            return this;
        }

        public a FN(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.lOb = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dkU() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
