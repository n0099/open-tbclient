package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean icn;
    private long ico;
    private long icp;
    private boolean icq;
    private int icr;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.icn = aVar.icn;
        this.e = aVar.ics;
        this.ico = aVar.ico;
        this.icq = aVar.icq;
        this.icp = aVar.icp;
        this.icr = aVar.icr;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.icn;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.ico;
    }

    public final long f() {
        return this.icp;
    }

    public final boolean g() {
        return this.icq;
    }

    public final int h() {
        return this.icr;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean icn = true;
        private long ics = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long ico = 60000;
        private long icp = ErrDef.Feature.WEIGHT;
        private boolean icq = false;
        private int icr = 1000;

        public a dn(Context context) {
            this.mContext = context;
            return this;
        }

        public a oO(boolean z) {
            this.icn = z;
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public a m23do(long j) {
            this.ics = 1000 * j;
            return this;
        }

        public a xJ(int i) {
            this.ico = i * 60 * 1000;
            return this;
        }

        public a dp(long j) {
            this.icp = 1000 * j;
            return this;
        }

        public a oP(boolean z) {
            this.icq = z;
            return this;
        }

        public a xK(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.icr = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bRG() {
            if (this.mContext == null) {
                j.yB("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
