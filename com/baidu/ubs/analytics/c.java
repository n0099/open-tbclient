package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jWT;
    private long jWU;
    private long jWV;
    private boolean jWW;
    private int jWX;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jWT = aVar.jWT;
        this.e = aVar.jWY;
        this.jWU = aVar.jWU;
        this.jWW = aVar.jWW;
        this.jWV = aVar.jWV;
        this.jWX = aVar.jWX;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jWT;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jWU;
    }

    public final long f() {
        return this.jWV;
    }

    public final boolean g() {
        return this.jWW;
    }

    public final int h() {
        return this.jWX;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jWT = true;
        private long jWY = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jWU = 60000;
        private long jWV = 10000;
        private boolean jWW = false;
        private int jWX = 1000;

        public a ep(Context context) {
            this.mContext = context;
            return this;
        }

        public a sb(boolean z) {
            this.jWT = z;
            return this;
        }

        public a ec(long j) {
            this.jWY = 1000 * j;
            return this;
        }

        public a BT(int i) {
            this.jWU = i * 60 * 1000;
            return this;
        }

        public a ed(long j) {
            this.jWV = 1000 * j;
            return this;
        }

        public a sc(boolean z) {
            this.jWW = z;
            return this;
        }

        public a BU(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jWX = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cAZ() {
            if (this.mContext == null) {
                j.Gf("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
