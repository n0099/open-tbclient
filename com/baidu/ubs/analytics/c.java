package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes14.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oWc;
    private long oWd;
    private long oWe;
    private boolean oWf;
    private int oWg;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oWc = aVar.oWc;
        this.e = aVar.oWh;
        this.oWd = aVar.oWd;
        this.oWf = aVar.oWf;
        this.oWe = aVar.oWe;
        this.oWg = aVar.oWg;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oWc;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oWd;
    }

    public final long f() {
        return this.oWe;
    }

    public final boolean g() {
        return this.oWf;
    }

    public final int h() {
        return this.oWg;
    }

    /* loaded from: classes14.dex */
    public static class a {
        private Context mContext;
        private boolean oWc = true;
        private long oWh = 30000;
        private long oWd = AppStatusRules.DEFAULT_GRANULARITY;
        private long oWe = 10000;
        private boolean oWf = false;
        private int oWg = 1000;

        public a hn(Context context) {
            this.mContext = context;
            return this;
        }

        public a AA(boolean z) {
            this.oWc = z;
            return this;
        }

        public a hU(long j) {
            this.oWh = 1000 * j;
            return this;
        }

        public a Nt(int i) {
            this.oWd = i * 60 * 1000;
            return this;
        }

        public a hV(long j) {
            this.oWe = 1000 * j;
            return this;
        }

        public a AB(boolean z) {
            this.oWf = z;
            return this;
        }

        public a Nu(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oWg = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c ein() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
