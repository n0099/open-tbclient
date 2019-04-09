package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jwp;
    private long jwq;
    private long jwr;
    private boolean jws;
    private int jwt;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jwp = aVar.jwp;
        this.e = aVar.jwu;
        this.jwq = aVar.jwq;
        this.jws = aVar.jws;
        this.jwr = aVar.jwr;
        this.jwt = aVar.jwt;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jwp;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jwq;
    }

    public final long f() {
        return this.jwr;
    }

    public final boolean g() {
        return this.jws;
    }

    public final int h() {
        return this.jwt;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jwp = true;
        private long jwu = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jwq = 60000;
        private long jwr = 10000;
        private boolean jws = false;
        private int jwt = 1000;

        public a eH(Context context) {
            this.mContext = context;
            return this;
        }

        public a rn(boolean z) {
            this.jwp = z;
            return this;
        }

        public a dZ(long j) {
            this.jwu = 1000 * j;
            return this;
        }

        public a BH(int i) {
            this.jwq = i * 60 * 1000;
            return this;
        }

        public a ea(long j) {
            this.jwr = 1000 * j;
            return this;
        }

        public a ro(boolean z) {
            this.jws = z;
            return this;
        }

        public a BI(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jwt = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c csm() {
            if (this.mContext == null) {
                j.EW("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
