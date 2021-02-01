package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes15.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oTA;
    private int oTB;
    private boolean oTx;
    private long oTy;
    private long oTz;

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oTx = aVar.oTx;
        this.e = aVar.oTC;
        this.oTy = aVar.oTy;
        this.oTA = aVar.oTA;
        this.oTz = aVar.oTz;
        this.oTB = aVar.oTB;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oTx;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oTy;
    }

    public final long f() {
        return this.oTz;
    }

    public final boolean g() {
        return this.oTA;
    }

    public final int h() {
        return this.oTB;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private Context mContext;
        private boolean oTx = true;
        private long oTC = 30000;
        private long oTy = AppStatusRules.DEFAULT_GRANULARITY;
        private long oTz = 10000;
        private boolean oTA = false;
        private int oTB = 1000;

        public a ho(Context context) {
            this.mContext = context;
            return this;
        }

        public a AB(boolean z) {
            this.oTx = z;
            return this;
        }

        public a hU(long j) {
            this.oTC = 1000 * j;
            return this;
        }

        public a No(int i) {
            this.oTy = i * 60 * 1000;
            return this;
        }

        public a hV(long j) {
            this.oTz = 1000 * j;
            return this;
        }

        public a AC(boolean z) {
            this.oTA = z;
            return this;
        }

        public a Np(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oTB = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c ehX() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
