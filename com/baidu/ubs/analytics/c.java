package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class c {
    private long e;
    private boolean hCd;
    private long hCe;
    private long hCf;
    private boolean hCg;
    private int hCh;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hCd = aVar.hCd;
        this.e = aVar.hCi;
        this.hCe = aVar.hCe;
        this.hCg = aVar.hCg;
        this.hCf = aVar.hCf;
        this.hCh = aVar.hCh;
    }

    public final Context bIV() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hCd;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hCe;
    }

    public final long f() {
        return this.hCf;
    }

    public final boolean g() {
        return this.hCg;
    }

    public final int h() {
        return this.hCh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Context mContext;
        private boolean hCd = true;
        private long hCi = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hCe = 60000;
        private long hCf = 10000;
        private boolean hCg = false;
        private int hCh = 1000;

        public a cu(Context context) {
            this.mContext = context;
            return this;
        }

        public a nG(boolean z) {
            this.hCd = z;
            return this;
        }

        public a dc(long j) {
            this.hCi = 1000 * j;
            return this;
        }

        public a vM(int i) {
            this.hCe = i * 60 * 1000;
            return this;
        }

        public a dd(long j) {
            this.hCf = 1000 * j;
            return this;
        }

        public a nH(boolean z) {
            this.hCg = z;
            return this;
        }

        public a vN(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hCh = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bIW() {
            if (this.mContext == null) {
                j.wi("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
