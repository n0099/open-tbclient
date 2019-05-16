package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jPf;
    private long jPg;
    private long jPh;
    private boolean jPi;
    private int jPj;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jPf = aVar.jPf;
        this.e = aVar.jPk;
        this.jPg = aVar.jPg;
        this.jPi = aVar.jPi;
        this.jPh = aVar.jPh;
        this.jPj = aVar.jPj;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jPf;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jPg;
    }

    public final long f() {
        return this.jPh;
    }

    public final boolean g() {
        return this.jPi;
    }

    public final int h() {
        return this.jPj;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jPf = true;
        private long jPk = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jPg = 60000;
        private long jPh = 10000;
        private boolean jPi = false;
        private int jPj = 1000;

        public a ex(Context context) {
            this.mContext = context;
            return this;
        }

        public a sc(boolean z) {
            this.jPf = z;
            return this;
        }

        public a ey(long j) {
            this.jPk = 1000 * j;
            return this;
        }

        public a CL(int i) {
            this.jPg = i * 60 * 1000;
            return this;
        }

        public a ez(long j) {
            this.jPh = 1000 * j;
            return this;
        }

        public a sd(boolean z) {
            this.jPi = z;
            return this;
        }

        public a CM(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jPj = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cAj() {
            if (this.mContext == null) {
                j.Gr("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
