package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public final class c {
    private long e;
    private boolean hkt;
    private long hku;
    private long hkv;
    private boolean hkw;
    private int hkx;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hkt = aVar.hkt;
        this.e = aVar.hky;
        this.hku = aVar.hku;
        this.hkw = aVar.hkw;
        this.hkv = aVar.hkv;
        this.hkx = aVar.hkx;
    }

    public final Context ns() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hkt;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hku;
    }

    public final long f() {
        return this.hkv;
    }

    public final boolean g() {
        return this.hkw;
    }

    public final int h() {
        return this.hkx;
    }

    /* loaded from: classes.dex */
    public static class a {
        private Context mContext;
        private boolean hkt = true;
        private long hky = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hku = 60000;
        private long hkv = 10000;
        private boolean hkw = false;
        private int hkx = 1000;

        public a cl(Context context) {
            this.mContext = context;
            return this;
        }

        public a nC(boolean z) {
            this.hkt = z;
            return this;
        }

        public a da(long j) {
            this.hky = 1000 * j;
            return this;
        }

        public a vq(int i) {
            this.hku = i * 60 * 1000;
            return this;
        }

        public a db(long j) {
            this.hkv = 1000 * j;
            return this;
        }

        public a nD(boolean z) {
            this.hkw = z;
            return this;
        }

        public a vr(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hkx = i2 < 1000 ? i2 : 1000;
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
