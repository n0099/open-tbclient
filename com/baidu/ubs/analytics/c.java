package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jwn;
    private long jwo;
    private long jwp;
    private boolean jwq;
    private int jwr;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jwn = aVar.jwn;
        this.e = aVar.jws;
        this.jwo = aVar.jwo;
        this.jwq = aVar.jwq;
        this.jwp = aVar.jwp;
        this.jwr = aVar.jwr;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jwn;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jwo;
    }

    public final long f() {
        return this.jwp;
    }

    public final boolean g() {
        return this.jwq;
    }

    public final int h() {
        return this.jwr;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jwn = true;
        private long jws = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jwo = 60000;
        private long jwp = 10000;
        private boolean jwq = false;
        private int jwr = 1000;

        public a eI(Context context) {
            this.mContext = context;
            return this;
        }

        public a rn(boolean z) {
            this.jwn = z;
            return this;
        }

        public a dY(long j) {
            this.jws = 1000 * j;
            return this;
        }

        public a BK(int i) {
            this.jwo = i * 60 * 1000;
            return this;
        }

        public a dZ(long j) {
            this.jwp = 1000 * j;
            return this;
        }

        public a ro(boolean z) {
            this.jwq = z;
            return this;
        }

        public a BL(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jwr = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c csb() {
            if (this.mContext == null) {
                j.EW("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
