package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes10.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean ohQ;
    private long ohR;
    private long ohS;
    private boolean ohT;
    private int ohU;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.ohQ = aVar.ohQ;
        this.e = aVar.ohV;
        this.ohR = aVar.ohR;
        this.ohT = aVar.ohT;
        this.ohS = aVar.ohS;
        this.ohU = aVar.ohU;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.ohQ;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.ohR;
    }

    public final long f() {
        return this.ohS;
    }

    public final boolean g() {
        return this.ohT;
    }

    public final int h() {
        return this.ohU;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private Context mContext;
        private boolean ohQ = true;
        private long ohV = 30000;
        private long ohR = 60000;
        private long ohS = 10000;
        private boolean ohT = false;
        private int ohU = 1000;

        public a gp(Context context) {
            this.mContext = context;
            return this;
        }

        public a zp(boolean z) {
            this.ohQ = z;
            return this;
        }

        public a gT(long j) {
            this.ohV = 1000 * j;
            return this;
        }

        public a MQ(int i) {
            this.ohR = i * 60 * 1000;
            return this;
        }

        public a gU(long j) {
            this.ohS = 1000 * j;
            return this;
        }

        public a zq(boolean z) {
            this.ohT = z;
            return this;
        }

        public a MR(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.ohU = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dZQ() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
