package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes7.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean npU;
    private long npV;
    private long npW;
    private boolean npX;
    private int npY;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.npU = aVar.npU;
        this.e = aVar.npZ;
        this.npV = aVar.npV;
        this.npX = aVar.npX;
        this.npW = aVar.npW;
        this.npY = aVar.npY;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.npU;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.npV;
    }

    public final long f() {
        return this.npW;
    }

    public final boolean g() {
        return this.npX;
    }

    public final int h() {
        return this.npY;
    }

    /* loaded from: classes7.dex */
    public static class a {
        private Context mContext;
        private boolean npU = true;
        private long npZ = 30000;
        private long npV = 60000;
        private long npW = 10000;
        private boolean npX = false;
        private int npY = 1000;

        public a gg(Context context) {
            this.mContext = context;
            return this;
        }

        public a xS(boolean z) {
            this.npU = z;
            return this;
        }

        public a gu(long j) {
            this.npZ = 1000 * j;
            return this;
        }

        public a Li(int i) {
            this.npV = i * 60 * 1000;
            return this;
        }

        public a gv(long j) {
            this.npW = 1000 * j;
            return this;
        }

        public a xT(boolean z) {
            this.npX = z;
            return this;
        }

        public a Lj(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.npY = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dQn() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
