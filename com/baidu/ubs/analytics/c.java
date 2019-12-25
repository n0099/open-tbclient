package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes5.dex */
public final class c {
    private long e;
    private boolean kRq;
    private long kRr;
    private long kRs;
    private boolean kRt;
    private int kRu;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.kRq = aVar.kRq;
        this.e = aVar.kRv;
        this.kRr = aVar.kRr;
        this.kRt = aVar.kRt;
        this.kRs = aVar.kRs;
        this.kRu = aVar.kRu;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.kRq;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.kRr;
    }

    public final long f() {
        return this.kRs;
    }

    public final boolean g() {
        return this.kRt;
    }

    public final int h() {
        return this.kRu;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private Context mContext;
        private boolean kRq = true;
        private long kRv = 30000;
        private long kRr = 60000;
        private long kRs = 10000;
        private boolean kRt = false;
        private int kRu = 1000;

        public a fL(Context context) {
            this.mContext = context;
            return this;
        }

        public a tI(boolean z) {
            this.kRq = z;
            return this;
        }

        public a eG(long j) {
            this.kRv = 1000 * j;
            return this;
        }

        public a Eq(int i) {
            this.kRr = i * 60 * 1000;
            return this;
        }

        public a eH(long j) {
            this.kRs = 1000 * j;
            return this;
        }

        public a tJ(boolean z) {
            this.kRt = z;
            return this;
        }

        public a Er(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.kRu = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cUS() {
            if (this.mContext == null) {
                j.KV("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
