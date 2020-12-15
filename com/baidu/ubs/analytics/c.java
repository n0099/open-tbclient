package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes17.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oHK;
    private long oHL;
    private long oHM;
    private boolean oHN;
    private int oHO;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oHK = aVar.oHK;
        this.e = aVar.oHP;
        this.oHL = aVar.oHL;
        this.oHN = aVar.oHN;
        this.oHM = aVar.oHM;
        this.oHO = aVar.oHO;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oHK;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oHL;
    }

    public final long f() {
        return this.oHM;
    }

    public final boolean g() {
        return this.oHN;
    }

    public final int h() {
        return this.oHO;
    }

    /* loaded from: classes17.dex */
    public static class a {
        private Context mContext;
        private boolean oHK = true;
        private long oHP = 30000;
        private long oHL = 60000;
        private long oHM = 10000;
        private boolean oHN = false;
        private int oHO = 1000;

        public a gY(Context context) {
            this.mContext = context;
            return this;
        }

        public a Al(boolean z) {
            this.oHK = z;
            return this;
        }

        public a hX(long j) {
            this.oHP = 1000 * j;
            return this;
        }

        public a OK(int i) {
            this.oHL = i * 60 * 1000;
            return this;
        }

        public a hY(long j) {
            this.oHM = 1000 * j;
            return this;
        }

        public a Am(boolean z) {
            this.oHN = z;
            return this;
        }

        public a OL(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oHO = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c ejm() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
