package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean hTs;
    private long hTt;
    private long hTu;
    private boolean hTv;
    private int hTw;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hTs = aVar.hTs;
        this.e = aVar.hTx;
        this.hTt = aVar.hTt;
        this.hTv = aVar.hTv;
        this.hTu = aVar.hTu;
        this.hTw = aVar.hTw;
    }

    public final Context bQc() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hTs;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hTt;
    }

    public final long f() {
        return this.hTu;
    }

    public final boolean g() {
        return this.hTv;
    }

    public final int h() {
        return this.hTw;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean hTs = true;
        private long hTx = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hTt = 60000;
        private long hTu = ErrDef.Feature.WEIGHT;
        private boolean hTv = false;
        private int hTw = 1000;

        /* renamed from: do  reason: not valid java name */
        public a m21do(Context context) {
            this.mContext = context;
            return this;
        }

        public a oy(boolean z) {
            this.hTs = z;
            return this;
        }

        public a dm(long j) {
            this.hTx = 1000 * j;
            return this;
        }

        public a wT(int i) {
            this.hTt = i * 60 * 1000;
            return this;
        }

        public a dn(long j) {
            this.hTu = 1000 * j;
            return this;
        }

        public a oz(boolean z) {
            this.hTv = z;
            return this;
        }

        public a wU(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hTw = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c bQd() {
            if (this.mContext == null) {
                j.xT("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
