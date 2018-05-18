package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public final class c {
    private long e;
    private boolean hlu;
    private long hlv;
    private long hlw;
    private boolean hlx;
    private int hly;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hlu = aVar.hlu;
        this.e = aVar.hlz;
        this.hlv = aVar.hlv;
        this.hlx = aVar.hlx;
        this.hlw = aVar.hlw;
        this.hly = aVar.hly;
    }

    public final Context nr() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hlu;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hlv;
    }

    public final long f() {
        return this.hlw;
    }

    public final boolean g() {
        return this.hlx;
    }

    public final int h() {
        return this.hly;
    }

    /* loaded from: classes.dex */
    public static class a {
        private Context mContext;
        private boolean hlu = true;
        private long hlz = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hlv = 60000;
        private long hlw = 10000;
        private boolean hlx = false;
        private int hly = 1000;

        public a cl(Context context) {
            this.mContext = context;
            return this;
        }

        public a nD(boolean z) {
            this.hlu = z;
            return this;
        }

        public a da(long j) {
            this.hlz = 1000 * j;
            return this;
        }

        public a vo(int i) {
            this.hlv = i * 60 * 1000;
            return this;
        }

        public a db(long j) {
            this.hlw = 1000 * j;
            return this;
        }

        public a nE(boolean z) {
            this.hlx = z;
            return this;
        }

        public a vp(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hly = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bEJ() {
            if (this.mContext == null) {
                j.vn("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
