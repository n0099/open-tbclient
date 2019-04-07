package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jwo;
    private long jwp;
    private long jwq;
    private boolean jwr;
    private int jws;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jwo = aVar.jwo;
        this.e = aVar.jwt;
        this.jwp = aVar.jwp;
        this.jwr = aVar.jwr;
        this.jwq = aVar.jwq;
        this.jws = aVar.jws;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jwo;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jwp;
    }

    public final long f() {
        return this.jwq;
    }

    public final boolean g() {
        return this.jwr;
    }

    public final int h() {
        return this.jws;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jwo = true;
        private long jwt = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jwp = 60000;
        private long jwq = 10000;
        private boolean jwr = false;
        private int jws = 1000;

        public a eH(Context context) {
            this.mContext = context;
            return this;
        }

        public a rn(boolean z) {
            this.jwo = z;
            return this;
        }

        public a dZ(long j) {
            this.jwt = 1000 * j;
            return this;
        }

        public a BH(int i) {
            this.jwp = i * 60 * 1000;
            return this;
        }

        public a ea(long j) {
            this.jwq = 1000 * j;
            return this;
        }

        public a ro(boolean z) {
            this.jwr = z;
            return this;
        }

        public a BI(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jws = i2 < 1000 ? i2 : 1000;
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
