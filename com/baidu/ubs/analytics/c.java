package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.ubs.analytics.d.j;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean hTt;
    private long hTu;
    private long hTv;
    private boolean hTw;
    private int hTx;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.hTt = aVar.hTt;
        this.e = aVar.hTy;
        this.hTu = aVar.hTu;
        this.hTw = aVar.hTw;
        this.hTv = aVar.hTv;
        this.hTx = aVar.hTx;
    }

    public final Context bQc() {
        return this.mContext;
    }

    public final boolean c() {
        return this.hTt;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.hTu;
    }

    public final long f() {
        return this.hTv;
    }

    public final boolean g() {
        return this.hTw;
    }

    public final int h() {
        return this.hTx;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean hTt = true;
        private long hTy = StatisticConfig.MIN_UPLOAD_INTERVAL;
        private long hTu = 60000;
        private long hTv = ErrDef.Feature.WEIGHT;
        private boolean hTw = false;
        private int hTx = 1000;

        /* renamed from: do  reason: not valid java name */
        public a m21do(Context context) {
            this.mContext = context;
            return this;
        }

        public a oy(boolean z) {
            this.hTt = z;
            return this;
        }

        public a dm(long j) {
            this.hTy = 1000 * j;
            return this;
        }

        public a wT(int i) {
            this.hTu = i * 60 * 1000;
            return this;
        }

        public a dn(long j) {
            this.hTv = 1000 * j;
            return this;
        }

        public a oz(boolean z) {
            this.hTw = z;
            return this;
        }

        public a wU(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.hTx = i2 < 1000 ? i2 : 1000;
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
