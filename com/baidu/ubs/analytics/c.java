package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private boolean kVE;
    private long kVF;
    private long kVG;
    private boolean kVH;
    private int kVI;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.kVE = aVar.kVE;
        this.e = aVar.kVJ;
        this.kVF = aVar.kVF;
        this.kVH = aVar.kVH;
        this.kVG = aVar.kVG;
        this.kVI = aVar.kVI;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.kVE;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.kVF;
    }

    public final long f() {
        return this.kVG;
    }

    public final boolean g() {
        return this.kVH;
    }

    public final int h() {
        return this.kVI;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean kVE = true;
        private long kVJ = 30000;
        private long kVF = 60000;
        private long kVG = 10000;
        private boolean kVH = false;
        private int kVI = 1000;

        public a fL(Context context) {
            this.mContext = context;
            return this;
        }

        public a tY(boolean z) {
            this.kVE = z;
            return this;
        }

        public a eJ(long j) {
            this.kVJ = 1000 * j;
            return this;
        }

        public a EA(int i) {
            this.kVF = i * 60 * 1000;
            return this;
        }

        public a eK(long j) {
            this.kVG = 1000 * j;
            return this;
        }

        public a tZ(boolean z) {
            this.kVH = z;
            return this;
        }

        public a EB(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.kVI = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cXn() {
            if (this.mContext == null) {
                j.Ls("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
