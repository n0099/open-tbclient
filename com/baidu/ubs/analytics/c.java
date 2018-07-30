package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes2.dex */
public final class c {
    private long e;
    private boolean hCb;
    private long hCc;
    private long hCd;
    private boolean hCe;
    private int hCf;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hCb = aVar.hCb;
        this.e = aVar.hCg;
        this.hCc = aVar.hCc;
        this.hCe = aVar.hCe;
        this.hCd = aVar.hCd;
        this.hCf = aVar.hCf;
    }

    public final Context bIR() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hCb;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hCc;
    }

    public final long f() {
        return this.hCd;
    }

    public final boolean g() {
        return this.hCe;
    }

    public final int h() {
        return this.hCf;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private Context mContext;
        private boolean hCb = true;
        private long hCg = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hCc = 60000;
        private long hCd = 10000;
        private boolean hCe = false;
        private int hCf = 1000;

        public a cv(Context context) {
            this.mContext = context;
            return this;
        }

        public a nG(boolean z) {
            this.hCb = z;
            return this;
        }

        public a dc(long j) {
            this.hCg = 1000 * j;
            return this;
        }

        public a vM(int i) {
            this.hCc = i * 60 * 1000;
            return this;
        }

        public a dd(long j) {
            this.hCd = 1000 * j;
            return this;
        }

        public a nH(boolean z) {
            this.hCe = z;
            return this;
        }

        public a vN(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hCf = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bIS() {
            if (this.mContext == null) {
                j.we("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
