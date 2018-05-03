package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public final class c {
    private long e;
    private boolean hkq;
    private long hkr;
    private long hks;
    private boolean hkt;
    private int hku;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hkq = aVar.hkq;
        this.e = aVar.hkv;
        this.hkr = aVar.hkr;
        this.hkt = aVar.hkt;
        this.hks = aVar.hks;
        this.hku = aVar.hku;
    }

    public final Context ns() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hkq;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hkr;
    }

    public final long f() {
        return this.hks;
    }

    public final boolean g() {
        return this.hkt;
    }

    public final int h() {
        return this.hku;
    }

    /* loaded from: classes.dex */
    public static class a {
        private Context mContext;
        private boolean hkq = true;
        private long hkv = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hkr = 60000;
        private long hks = 10000;
        private boolean hkt = false;
        private int hku = 1000;

        public a cl(Context context) {
            this.mContext = context;
            return this;
        }

        public a nC(boolean z) {
            this.hkq = z;
            return this;
        }

        public a da(long j) {
            this.hkv = 1000 * j;
            return this;
        }

        public a vp(int i) {
            this.hkr = i * 60 * 1000;
            return this;
        }

        public a db(long j) {
            this.hks = 1000 * j;
            return this;
        }

        public a nD(boolean z) {
            this.hkt = z;
            return this;
        }

        public a vq(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hku = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bEL() {
            if (this.mContext == null) {
                j.vk("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
