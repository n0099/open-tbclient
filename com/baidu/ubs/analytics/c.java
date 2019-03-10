package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jwG;
    private long jwH;
    private long jwI;
    private boolean jwJ;
    private int jwK;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jwG = aVar.jwG;
        this.e = aVar.jwL;
        this.jwH = aVar.jwH;
        this.jwJ = aVar.jwJ;
        this.jwI = aVar.jwI;
        this.jwK = aVar.jwK;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jwG;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jwH;
    }

    public final long f() {
        return this.jwI;
    }

    public final boolean g() {
        return this.jwJ;
    }

    public final int h() {
        return this.jwK;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jwG = true;
        private long jwL = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jwH = 60000;
        private long jwI = 10000;
        private boolean jwJ = false;
        private int jwK = 1000;

        public a eI(Context context) {
            this.mContext = context;
            return this;
        }

        public a rn(boolean z) {
            this.jwG = z;
            return this;
        }

        public a dY(long j) {
            this.jwL = 1000 * j;
            return this;
        }

        public a BL(int i) {
            this.jwH = i * 60 * 1000;
            return this;
        }

        public a dZ(long j) {
            this.jwI = 1000 * j;
            return this;
        }

        public a ro(boolean z) {
            this.jwJ = z;
            return this;
        }

        public a BM(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jwK = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c csl() {
            if (this.mContext == null) {
                j.EZ("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
