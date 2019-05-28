package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jPg;
    private long jPh;
    private long jPi;
    private boolean jPj;
    private int jPk;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jPg = aVar.jPg;
        this.e = aVar.jPl;
        this.jPh = aVar.jPh;
        this.jPj = aVar.jPj;
        this.jPi = aVar.jPi;
        this.jPk = aVar.jPk;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jPg;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jPh;
    }

    public final long f() {
        return this.jPi;
    }

    public final boolean g() {
        return this.jPj;
    }

    public final int h() {
        return this.jPk;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jPg = true;
        private long jPl = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jPh = 60000;
        private long jPi = 10000;
        private boolean jPj = false;
        private int jPk = 1000;

        public a ex(Context context) {
            this.mContext = context;
            return this;
        }

        public a sc(boolean z) {
            this.jPg = z;
            return this;
        }

        public a ey(long j) {
            this.jPl = 1000 * j;
            return this;
        }

        public a CL(int i) {
            this.jPh = i * 60 * 1000;
            return this;
        }

        public a ez(long j) {
            this.jPi = 1000 * j;
            return this;
        }

        public a sd(boolean z) {
            this.jPj = z;
            return this;
        }

        public a CM(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jPk = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cAl() {
            if (this.mContext == null) {
                j.Gr("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
