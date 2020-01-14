package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes6.dex */
public final class c {
    private long e;
    private boolean kUW;
    private long kUX;
    private long kUY;
    private boolean kUZ;
    private int kVa;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.kUW = aVar.kUW;
        this.e = aVar.kVb;
        this.kUX = aVar.kUX;
        this.kUZ = aVar.kUZ;
        this.kUY = aVar.kUY;
        this.kVa = aVar.kVa;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.kUW;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.kUX;
    }

    public final long f() {
        return this.kUY;
    }

    public final boolean g() {
        return this.kUZ;
    }

    public final int h() {
        return this.kVa;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private Context mContext;
        private boolean kUW = true;
        private long kVb = 30000;
        private long kUX = 60000;
        private long kUY = 10000;
        private boolean kUZ = false;
        private int kVa = 1000;

        public a fM(Context context) {
            this.mContext = context;
            return this;
        }

        public a tU(boolean z) {
            this.kUW = z;
            return this;
        }

        public a eL(long j) {
            this.kVb = 1000 * j;
            return this;
        }

        public a Ev(int i) {
            this.kUX = i * 60 * 1000;
            return this;
        }

        public a eM(long j) {
            this.kUY = 1000 * j;
            return this;
        }

        public a tV(boolean z) {
            this.kUZ = z;
            return this;
        }

        public a Ew(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.kVa = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cVX() {
            if (this.mContext == null) {
                j.Lf("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
