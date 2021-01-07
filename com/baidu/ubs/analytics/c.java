package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oNT;
    private long oNU;
    private long oNV;
    private boolean oNW;
    private int oNX;

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oNT = aVar.oNT;
        this.e = aVar.oNY;
        this.oNU = aVar.oNU;
        this.oNW = aVar.oNW;
        this.oNV = aVar.oNV;
        this.oNX = aVar.oNX;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oNT;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oNU;
    }

    public final long f() {
        return this.oNV;
    }

    public final boolean g() {
        return this.oNW;
    }

    public final int h() {
        return this.oNX;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean oNT = true;
        private long oNY = 30000;
        private long oNU = AppStatusRules.DEFAULT_GRANULARITY;
        private long oNV = 10000;
        private boolean oNW = false;
        private int oNX = 1000;

        public a hn(Context context) {
            this.mContext = context;
            return this;
        }

        public a Am(boolean z) {
            this.oNT = z;
            return this;
        }

        public a hR(long j) {
            this.oNY = 1000 * j;
            return this;
        }

        public a Oz(int i) {
            this.oNU = i * 60 * 1000;
            return this;
        }

        public a hS(long j) {
            this.oNV = 1000 * j;
            return this;
        }

        public a An(boolean z) {
            this.oNW = z;
            return this;
        }

        public a OA(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oNX = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c ejx() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
