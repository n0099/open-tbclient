package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private long jwA;
    private boolean jwB;
    private int jwC;
    private boolean jwy;
    private long jwz;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jwy = aVar.jwy;
        this.e = aVar.jwD;
        this.jwz = aVar.jwz;
        this.jwB = aVar.jwB;
        this.jwA = aVar.jwA;
        this.jwC = aVar.jwC;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jwy;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jwz;
    }

    public final long f() {
        return this.jwA;
    }

    public final boolean g() {
        return this.jwB;
    }

    public final int h() {
        return this.jwC;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jwy = true;
        private long jwD = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jwz = 60000;
        private long jwA = 10000;
        private boolean jwB = false;
        private int jwC = 1000;

        public a eH(Context context) {
            this.mContext = context;
            return this;
        }

        public a rn(boolean z) {
            this.jwy = z;
            return this;
        }

        public a dY(long j) {
            this.jwD = 1000 * j;
            return this;
        }

        public a BL(int i) {
            this.jwz = i * 60 * 1000;
            return this;
        }

        public a dZ(long j) {
            this.jwA = 1000 * j;
            return this;
        }

        public a ro(boolean z) {
            this.jwB = z;
            return this;
        }

        public a BM(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jwC = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cso() {
            if (this.mContext == null) {
                j.EX("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
