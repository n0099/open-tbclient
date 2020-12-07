package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes17.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oHI;
    private long oHJ;
    private long oHK;
    private boolean oHL;
    private int oHM;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oHI = aVar.oHI;
        this.e = aVar.oHN;
        this.oHJ = aVar.oHJ;
        this.oHL = aVar.oHL;
        this.oHK = aVar.oHK;
        this.oHM = aVar.oHM;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oHI;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oHJ;
    }

    public final long f() {
        return this.oHK;
    }

    public final boolean g() {
        return this.oHL;
    }

    public final int h() {
        return this.oHM;
    }

    /* loaded from: classes17.dex */
    public static class a {
        private Context mContext;
        private boolean oHI = true;
        private long oHN = 30000;
        private long oHJ = 60000;
        private long oHK = 10000;
        private boolean oHL = false;
        private int oHM = 1000;

        public a gY(Context context) {
            this.mContext = context;
            return this;
        }

        public a Al(boolean z) {
            this.oHI = z;
            return this;
        }

        public a hX(long j) {
            this.oHN = 1000 * j;
            return this;
        }

        public a OK(int i) {
            this.oHJ = i * 60 * 1000;
            return this;
        }

        public a hY(long j) {
            this.oHK = 1000 * j;
            return this;
        }

        public a Am(boolean z) {
            this.oHL = z;
            return this;
        }

        public a OL(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oHM = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c ejl() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
