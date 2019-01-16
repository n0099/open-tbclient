package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean igH;
    private long igI;
    private long igJ;
    private boolean igK;
    private int igL;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.igH = aVar.igH;
        this.e = aVar.igM;
        this.igI = aVar.igI;
        this.igK = aVar.igK;
        this.igJ = aVar.igJ;
        this.igL = aVar.igL;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.igH;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.igI;
    }

    public final long f() {
        return this.igJ;
    }

    public final boolean g() {
        return this.igK;
    }

    public final int h() {
        return this.igL;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean igH = true;
        private long igM = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long igI = 60000;
        private long igJ = ErrDef.Feature.WEIGHT;
        private boolean igK = false;
        private int igL = 1000;

        public a dn(Context context) {
            this.mContext = context;
            return this;
        }

        public a oS(boolean z) {
            this.igH = z;
            return this;
        }

        public a dt(long j) {
            this.igM = 1000 * j;
            return this;
        }

        public a xY(int i) {
            this.igI = i * 60 * 1000;
            return this;
        }

        public a du(long j) {
            this.igJ = 1000 * j;
            return this;
        }

        public a oT(boolean z) {
            this.igK = z;
            return this;
        }

        public a xZ(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.igL = i2 < 1000 ? i2 : 1000;
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
