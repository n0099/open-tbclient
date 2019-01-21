package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean igI;
    private long igJ;
    private long igK;
    private boolean igL;
    private int igM;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.igI = aVar.igI;
        this.e = aVar.igN;
        this.igJ = aVar.igJ;
        this.igL = aVar.igL;
        this.igK = aVar.igK;
        this.igM = aVar.igM;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.igI;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.igJ;
    }

    public final long f() {
        return this.igK;
    }

    public final boolean g() {
        return this.igL;
    }

    public final int h() {
        return this.igM;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean igI = true;
        private long igN = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long igJ = 60000;
        private long igK = ErrDef.Feature.WEIGHT;
        private boolean igL = false;
        private int igM = 1000;

        public a dn(Context context) {
            this.mContext = context;
            return this;
        }

        public a oS(boolean z) {
            this.igI = z;
            return this;
        }

        public a dt(long j) {
            this.igN = 1000 * j;
            return this;
        }

        public a xY(int i) {
            this.igJ = i * 60 * 1000;
            return this;
        }

        public a du(long j) {
            this.igK = 1000 * j;
            return this;
        }

        public a oT(boolean z) {
            this.igL = z;
            return this;
        }

        public a xZ(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.igM = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bTf() {
            if (this.mContext == null) {
                j.yU("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
