package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class c {
    private long e;
    private boolean hKA;
    private long hKB;
    private long hKC;
    private boolean hKD;
    private int hKE;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hKA = aVar.hKA;
        this.e = aVar.hKF;
        this.hKB = aVar.hKB;
        this.hKD = aVar.hKD;
        this.hKC = aVar.hKC;
        this.hKE = aVar.hKE;
    }

    public final Context bLM() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hKA;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hKB;
    }

    public final long f() {
        return this.hKC;
    }

    public final boolean g() {
        return this.hKD;
    }

    public final int h() {
        return this.hKE;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Context mContext;
        private boolean hKA = true;
        private long hKF = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hKB = 60000;
        private long hKC = 10000;
        private boolean hKD = false;
        private int hKE = 1000;

        public a db(Context context) {
            this.mContext = context;
            return this;
        }

        public a od(boolean z) {
            this.hKA = z;
            return this;
        }

        public a de(long j) {
            this.hKF = 1000 * j;
            return this;
        }

        public a wm(int i) {
            this.hKB = i * 60 * 1000;
            return this;
        }

        public a df(long j) {
            this.hKC = 1000 * j;
            return this;
        }

        public a oe(boolean z) {
            this.hKD = z;
            return this;
        }

        public a wn(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hKE = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bLN() {
            if (this.mContext == null) {
                j.wT("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
