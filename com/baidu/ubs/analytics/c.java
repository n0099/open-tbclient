package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private boolean kVQ;
    private long kVR;
    private long kVS;
    private boolean kVT;
    private int kVU;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.kVQ = aVar.kVQ;
        this.e = aVar.kVV;
        this.kVR = aVar.kVR;
        this.kVT = aVar.kVT;
        this.kVS = aVar.kVS;
        this.kVU = aVar.kVU;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.kVQ;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.kVR;
    }

    public final long f() {
        return this.kVS;
    }

    public final boolean g() {
        return this.kVT;
    }

    public final int h() {
        return this.kVU;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean kVQ = true;
        private long kVV = 30000;
        private long kVR = 60000;
        private long kVS = 10000;
        private boolean kVT = false;
        private int kVU = 1000;

        public a fL(Context context) {
            this.mContext = context;
            return this;
        }

        public a tY(boolean z) {
            this.kVQ = z;
            return this;
        }

        public a eJ(long j) {
            this.kVV = 1000 * j;
            return this;
        }

        public a EA(int i) {
            this.kVR = i * 60 * 1000;
            return this;
        }

        public a eK(long j) {
            this.kVS = 1000 * j;
            return this;
        }

        public a tZ(boolean z) {
            this.kVT = z;
            return this;
        }

        public a EB(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.kVU = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c cXo() {
            if (this.mContext == null) {
                j.Lt("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
