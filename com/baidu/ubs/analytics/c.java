package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jZL;
    private long jZM;
    private long jZN;
    private boolean jZO;
    private int jZP;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jZL = aVar.jZL;
        this.e = aVar.jZQ;
        this.jZM = aVar.jZM;
        this.jZO = aVar.jZO;
        this.jZN = aVar.jZN;
        this.jZP = aVar.jZP;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jZL;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jZM;
    }

    public final long f() {
        return this.jZN;
    }

    public final boolean g() {
        return this.jZO;
    }

    public final int h() {
        return this.jZP;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jZL = true;
        private long jZQ = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jZM = 60000;
        private long jZN = 10000;
        private boolean jZO = false;
        private int jZP = 1000;

        public a eA(Context context) {
            this.mContext = context;
            return this;
        }

        public a sw(boolean z) {
            this.jZL = z;
            return this;
        }

        public a eJ(long j) {
            this.jZQ = 1000 * j;
            return this;
        }

        public a Dy(int i) {
            this.jZM = i * 60 * 1000;
            return this;
        }

        public a eK(long j) {
            this.jZN = 1000 * j;
            return this;
        }

        public a sx(boolean z) {
            this.jZO = z;
            return this;
        }

        public a Dz(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jZP = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cEr() {
            if (this.mContext == null) {
                j.HO("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
