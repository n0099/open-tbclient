package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class c {
    private long e;
    private int hBA;
    private boolean hBw;
    private long hBx;
    private long hBy;
    private boolean hBz;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hBw = aVar.hBw;
        this.e = aVar.hBB;
        this.hBx = aVar.hBx;
        this.hBz = aVar.hBz;
        this.hBy = aVar.hBy;
        this.hBA = aVar.hBA;
    }

    public final Context qE() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hBw;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hBx;
    }

    public final long f() {
        return this.hBy;
    }

    public final boolean g() {
        return this.hBz;
    }

    public final int h() {
        return this.hBA;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Context mContext;
        private boolean hBw = true;
        private long hBB = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hBx = 60000;
        private long hBy = 10000;
        private boolean hBz = false;
        private int hBA = 1000;

        public a cu(Context context) {
            this.mContext = context;
            return this;
        }

        public a nS(boolean z) {
            this.hBw = z;
            return this;
        }

        public a df(long j) {
            this.hBB = 1000 * j;
            return this;
        }

        public a vP(int i) {
            this.hBx = i * 60 * 1000;
            return this;
        }

        public a dg(long j) {
            this.hBy = 1000 * j;
            return this;
        }

        public a nT(boolean z) {
            this.hBz = z;
            return this;
        }

        public a vQ(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hBA = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bKo() {
            if (this.mContext == null) {
                j.wd("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
