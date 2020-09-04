package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes5.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean nfS;
    private long nfT;
    private long nfU;
    private boolean nfV;
    private int nfW;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.nfS = aVar.nfS;
        this.e = aVar.nfX;
        this.nfT = aVar.nfT;
        this.nfV = aVar.nfV;
        this.nfU = aVar.nfU;
        this.nfW = aVar.nfW;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.nfS;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.nfT;
    }

    public final long f() {
        return this.nfU;
    }

    public final boolean g() {
        return this.nfV;
    }

    public final int h() {
        return this.nfW;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private Context mContext;
        private boolean nfS = true;
        private long nfX = 30000;
        private long nfT = 60000;
        private long nfU = 10000;
        private boolean nfV = false;
        private int nfW = 1000;

        public a fZ(Context context) {
            this.mContext = context;
            return this;
        }

        public a xJ(boolean z) {
            this.nfS = z;
            return this;
        }

        public a gg(long j) {
            this.nfX = 1000 * j;
            return this;
        }

        public a KD(int i) {
            this.nfT = i * 60 * 1000;
            return this;
        }

        public a gh(long j) {
            this.nfU = 1000 * j;
            return this;
        }

        public a xK(boolean z) {
            this.nfV = z;
            return this;
        }

        public a KE(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.nfW = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dMp() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
