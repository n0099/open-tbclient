package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes15.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oTX;
    private long oTY;
    private long oTZ;
    private boolean oUa;
    private int oUb;

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oTX = aVar.oTX;
        this.e = aVar.oUc;
        this.oTY = aVar.oTY;
        this.oUa = aVar.oUa;
        this.oTZ = aVar.oTZ;
        this.oUb = aVar.oUb;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oTX;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oTY;
    }

    public final long f() {
        return this.oTZ;
    }

    public final boolean g() {
        return this.oUa;
    }

    public final int h() {
        return this.oUb;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private Context mContext;
        private boolean oTX = true;
        private long oUc = 30000;
        private long oTY = AppStatusRules.DEFAULT_GRANULARITY;
        private long oTZ = 10000;
        private boolean oUa = false;
        private int oUb = 1000;

        public a ho(Context context) {
            this.mContext = context;
            return this;
        }

        public a AB(boolean z) {
            this.oTX = z;
            return this;
        }

        public a hU(long j) {
            this.oUc = 1000 * j;
            return this;
        }

        public a Np(int i) {
            this.oTY = i * 60 * 1000;
            return this;
        }

        public a hV(long j) {
            this.oTZ = 1000 * j;
            return this;
        }

        public a AC(boolean z) {
            this.oUa = z;
            return this;
        }

        public a Nq(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oUb = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c eif() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
