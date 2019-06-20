package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jPj;
    private long jPk;
    private long jPl;
    private boolean jPm;
    private int jPn;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jPj = aVar.jPj;
        this.e = aVar.jPo;
        this.jPk = aVar.jPk;
        this.jPm = aVar.jPm;
        this.jPl = aVar.jPl;
        this.jPn = aVar.jPn;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jPj;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jPk;
    }

    public final long f() {
        return this.jPl;
    }

    public final boolean g() {
        return this.jPm;
    }

    public final int h() {
        return this.jPn;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jPj = true;
        private long jPo = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jPk = 60000;
        private long jPl = 10000;
        private boolean jPm = false;
        private int jPn = 1000;

        public a ex(Context context) {
            this.mContext = context;
            return this;
        }

        public a sd(boolean z) {
            this.jPj = z;
            return this;
        }

        public a ey(long j) {
            this.jPo = 1000 * j;
            return this;
        }

        public a CL(int i) {
            this.jPk = i * 60 * 1000;
            return this;
        }

        public a ez(long j) {
            this.jPl = 1000 * j;
            return this;
        }

        public a se(boolean z) {
            this.jPm = z;
            return this;
        }

        public a CM(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jPn = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cAk() {
            if (this.mContext == null) {
                j.Gt("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
