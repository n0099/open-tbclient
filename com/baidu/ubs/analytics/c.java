package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jXo;
    private long jXp;
    private long jXq;
    private boolean jXr;
    private int jXs;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jXo = aVar.jXo;
        this.e = aVar.jXt;
        this.jXp = aVar.jXp;
        this.jXr = aVar.jXr;
        this.jXq = aVar.jXq;
        this.jXs = aVar.jXs;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jXo;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jXp;
    }

    public final long f() {
        return this.jXq;
    }

    public final boolean g() {
        return this.jXr;
    }

    public final int h() {
        return this.jXs;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jXo = true;
        private long jXt = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jXp = 60000;
        private long jXq = 10000;
        private boolean jXr = false;
        private int jXs = 1000;

        public a ez(Context context) {
            this.mContext = context;
            return this;
        }

        public a st(boolean z) {
            this.jXo = z;
            return this;
        }

        public a eG(long j) {
            this.jXt = 1000 * j;
            return this;
        }

        public a Du(int i) {
            this.jXp = i * 60 * 1000;
            return this;
        }

        public a eH(long j) {
            this.jXq = 1000 * j;
            return this;
        }

        public a su(boolean z) {
            this.jXr = z;
            return this;
        }

        public a Dv(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jXs = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cDD() {
            if (this.mContext == null) {
                j.Ho("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
