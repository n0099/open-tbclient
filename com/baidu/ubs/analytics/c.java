package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private boolean kXt;
    private long kXu;
    private long kXv;
    private boolean kXw;
    private int kXx;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.kXt = aVar.kXt;
        this.e = aVar.kXy;
        this.kXu = aVar.kXu;
        this.kXw = aVar.kXw;
        this.kXv = aVar.kXv;
        this.kXx = aVar.kXx;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.kXt;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.kXu;
    }

    public final long f() {
        return this.kXv;
    }

    public final boolean g() {
        return this.kXw;
    }

    public final int h() {
        return this.kXx;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean kXt = true;
        private long kXy = 30000;
        private long kXu = 60000;
        private long kXv = 10000;
        private boolean kXw = false;
        private int kXx = 1000;

        public a fK(Context context) {
            this.mContext = context;
            return this;
        }

        public a uf(boolean z) {
            this.kXt = z;
            return this;
        }

        public a eK(long j) {
            this.kXy = 1000 * j;
            return this;
        }

        public a EH(int i) {
            this.kXu = i * 60 * 1000;
            return this;
        }

        public a eL(long j) {
            this.kXv = 1000 * j;
            return this;
        }

        public a ug(boolean z) {
            this.kXw = z;
            return this;
        }

        public a EI(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.kXx = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cXM() {
            if (this.mContext == null) {
                j.Lt("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
