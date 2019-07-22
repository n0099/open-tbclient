package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private boolean jWi;
    private long jWj;
    private long jWk;
    private boolean jWl;
    private int jWm;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.jWi = aVar.jWi;
        this.e = aVar.jWn;
        this.jWj = aVar.jWj;
        this.jWl = aVar.jWl;
        this.jWk = aVar.jWk;
        this.jWm = aVar.jWm;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.jWi;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.jWj;
    }

    public final long f() {
        return this.jWk;
    }

    public final boolean g() {
        return this.jWl;
    }

    public final int h() {
        return this.jWm;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean jWi = true;
        private long jWn = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long jWj = 60000;
        private long jWk = 10000;
        private boolean jWl = false;
        private int jWm = 1000;

        public a ey(Context context) {
            this.mContext = context;
            return this;
        }

        public a ss(boolean z) {
            this.jWi = z;
            return this;
        }

        public a eG(long j) {
            this.jWn = 1000 * j;
            return this;
        }

        public a Ds(int i) {
            this.jWj = i * 60 * 1000;
            return this;
        }

        public a eH(long j) {
            this.jWk = 1000 * j;
            return this;
        }

        public a st(boolean z) {
            this.jWl = z;
            return this;
        }

        public a Dt(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.jWm = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cDi() {
            if (this.mContext == null) {
                j.Hn("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
