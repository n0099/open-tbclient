package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private boolean kVC;
    private long kVD;
    private long kVE;
    private boolean kVF;
    private int kVG;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.kVC = aVar.kVC;
        this.e = aVar.kVH;
        this.kVD = aVar.kVD;
        this.kVF = aVar.kVF;
        this.kVE = aVar.kVE;
        this.kVG = aVar.kVG;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.kVC;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.kVD;
    }

    public final long f() {
        return this.kVE;
    }

    public final boolean g() {
        return this.kVF;
    }

    public final int h() {
        return this.kVG;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean kVC = true;
        private long kVH = 30000;
        private long kVD = 60000;
        private long kVE = 10000;
        private boolean kVF = false;
        private int kVG = 1000;

        public a fL(Context context) {
            this.mContext = context;
            return this;
        }

        public a tY(boolean z) {
            this.kVC = z;
            return this;
        }

        public a eJ(long j) {
            this.kVH = 1000 * j;
            return this;
        }

        public a EA(int i) {
            this.kVD = i * 60 * 1000;
            return this;
        }

        public a eK(long j) {
            this.kVE = 1000 * j;
            return this;
        }

        public a tZ(boolean z) {
            this.kVF = z;
            return this;
        }

        public a EB(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.kVG = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cXl() {
            if (this.mContext == null) {
                j.Ls("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
