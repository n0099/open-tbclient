package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean hVd;
    private long hVe;
    private long hVf;
    private boolean hVg;
    private int hVh;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hVd = aVar.hVd;
        this.e = aVar.hVi;
        this.hVe = aVar.hVe;
        this.hVg = aVar.hVg;
        this.hVf = aVar.hVf;
        this.hVh = aVar.hVh;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hVd;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hVe;
    }

    public final long f() {
        return this.hVf;
    }

    public final boolean g() {
        return this.hVg;
    }

    public final int h() {
        return this.hVh;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean hVd = true;
        private long hVi = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hVe = 60000;
        private long hVf = ErrDef.Feature.WEIGHT;
        private boolean hVg = false;
        private int hVh = 1000;

        public a dj(Context context) {
            this.mContext = context;
            return this;
        }

        public a oM(boolean z) {
            this.hVd = z;
            return this;
        }

        public a dh(long j) {
            this.hVi = 1000 * j;
            return this;
        }

        public a xm(int i) {
            this.hVe = i * 60 * 1000;
            return this;
        }

        public a di(long j) {
            this.hVf = 1000 * j;
            return this;
        }

        public a oN(boolean z) {
            this.hVg = z;
            return this;
        }

        public a xn(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hVh = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bPB() {
            if (this.mContext == null) {
                j.xY("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
