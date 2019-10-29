package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jXK;
    private long jXL;
    private long jXM;
    private boolean jXN;
    private int jXO;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jXK = aVar.jXK;
        this.e = aVar.jXP;
        this.jXL = aVar.jXL;
        this.jXN = aVar.jXN;
        this.jXM = aVar.jXM;
        this.jXO = aVar.jXO;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jXK;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jXL;
    }

    public final long f() {
        return this.jXM;
    }

    public final boolean g() {
        return this.jXN;
    }

    public final int h() {
        return this.jXO;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jXK = true;
        private long jXP = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jXL = 60000;
        private long jXM = 10000;
        private boolean jXN = false;
        private int jXO = 1000;

        public a ep(Context context) {
            this.mContext = context;
            return this;
        }

        public a sb(boolean z) {
            this.jXK = z;
            return this;
        }

        public a ed(long j) {
            this.jXP = 1000 * j;
            return this;
        }

        public a BU(int i) {
            this.jXL = i * 60 * 1000;
            return this;
        }

        public a ee(long j) {
            this.jXM = 1000 * j;
            return this;
        }

        public a sc(boolean z) {
            this.jXN = z;
            return this;
        }

        public a BV(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jXO = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cBb() {
            if (this.mContext == null) {
                j.Gf("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
