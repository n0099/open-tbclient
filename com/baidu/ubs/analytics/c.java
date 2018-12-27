package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean ifA;
    private long ifB;
    private long ifC;
    private boolean ifD;
    private int ifE;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.ifA = aVar.ifA;
        this.e = aVar.ifF;
        this.ifB = aVar.ifB;
        this.ifD = aVar.ifD;
        this.ifC = aVar.ifC;
        this.ifE = aVar.ifE;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.ifA;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.ifB;
    }

    public final long f() {
        return this.ifC;
    }

    public final boolean g() {
        return this.ifD;
    }

    public final int h() {
        return this.ifE;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean ifA = true;
        private long ifF = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long ifB = 60000;
        private long ifC = ErrDef.Feature.WEIGHT;
        private boolean ifD = false;
        private int ifE = 1000;

        public a dn(Context context) {
            this.mContext = context;
            return this;
        }

        public a oR(boolean z) {
            this.ifA = z;
            return this;
        }

        public a dt(long j) {
            this.ifF = 1000 * j;
            return this;
        }

        public a xW(int i) {
            this.ifB = i * 60 * 1000;
            return this;
        }

        public a du(long j) {
            this.ifC = 1000 * j;
            return this;
        }

        public a oS(boolean z) {
            this.ifD = z;
            return this;
        }

        public a xX(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.ifE = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bSx() {
            if (this.mContext == null) {
                j.yE("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
