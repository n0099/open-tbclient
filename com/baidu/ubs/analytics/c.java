package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes10.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean nFo;
    private long nFp;
    private long nFq;
    private boolean nFr;
    private int nFs;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.nFo = aVar.nFo;
        this.e = aVar.nFt;
        this.nFp = aVar.nFp;
        this.nFr = aVar.nFr;
        this.nFq = aVar.nFq;
        this.nFs = aVar.nFs;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.nFo;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.nFp;
    }

    public final long f() {
        return this.nFq;
    }

    public final boolean g() {
        return this.nFr;
    }

    public final int h() {
        return this.nFs;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private Context mContext;
        private boolean nFo = true;
        private long nFt = 30000;
        private long nFp = 60000;
        private long nFq = 10000;
        private boolean nFr = false;
        private int nFs = 1000;

        public a gn(Context context) {
            this.mContext = context;
            return this;
        }

        public a yz(boolean z) {
            this.nFo = z;
            return this;
        }

        public a gM(long j) {
            this.nFt = 1000 * j;
            return this;
        }

        public a LO(int i) {
            this.nFp = i * 60 * 1000;
            return this;
        }

        public a gN(long j) {
            this.nFq = 1000 * j;
            return this;
        }

        public a yA(boolean z) {
            this.nFr = z;
            return this;
        }

        public a LP(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.nFs = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dTY() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
