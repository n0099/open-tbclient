package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public final class c {
    private long e;
    private boolean hxp;
    private long hxq;
    private long hxr;
    private boolean hxs;
    private int hxt;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hxp = aVar.hxp;
        this.e = aVar.hxu;
        this.hxq = aVar.hxq;
        this.hxs = aVar.hxs;
        this.hxr = aVar.hxr;
        this.hxt = aVar.hxt;
    }

    public final Context qE() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hxp;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hxq;
    }

    public final long f() {
        return this.hxr;
    }

    public final boolean g() {
        return this.hxs;
    }

    public final int h() {
        return this.hxt;
    }

    /* loaded from: classes.dex */
    public static class a {
        private Context mContext;
        private boolean hxp = true;
        private long hxu = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hxq = 60000;
        private long hxr = 10000;
        private boolean hxs = false;
        private int hxt = 1000;

        public a cw(Context context) {
            this.mContext = context;
            return this;
        }

        public a nL(boolean z) {
            this.hxp = z;
            return this;
        }

        public a dh(long j) {
            this.hxu = 1000 * j;
            return this;
        }

        public a vG(int i) {
            this.hxq = i * 60 * 1000;
            return this;
        }

        public a di(long j) {
            this.hxr = 1000 * j;
            return this;
        }

        public a nM(boolean z) {
            this.hxs = z;
            return this;
        }

        public a vH(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hxt = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bJN() {
            if (this.mContext == null) {
                j.wh("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
