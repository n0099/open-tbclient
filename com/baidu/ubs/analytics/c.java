package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes10.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oqV;
    private long oqW;
    private long oqX;
    private boolean oqY;
    private int oqZ;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oqV = aVar.oqV;
        this.e = aVar.ora;
        this.oqW = aVar.oqW;
        this.oqY = aVar.oqY;
        this.oqX = aVar.oqX;
        this.oqZ = aVar.oqZ;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oqV;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oqW;
    }

    public final long f() {
        return this.oqX;
    }

    public final boolean g() {
        return this.oqY;
    }

    public final int h() {
        return this.oqZ;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private Context mContext;
        private boolean oqV = true;
        private long ora = 30000;
        private long oqW = 60000;
        private long oqX = 10000;
        private boolean oqY = false;
        private int oqZ = 1000;

        public a gp(Context context) {
            this.mContext = context;
            return this;
        }

        public a zA(boolean z) {
            this.oqV = z;
            return this;
        }

        public a hp(long j) {
            this.ora = 1000 * j;
            return this;
        }

        public a Nj(int i) {
            this.oqW = i * 60 * 1000;
            return this;
        }

        public a hq(long j) {
            this.oqX = 1000 * j;
            return this;
        }

        public a zB(boolean z) {
            this.oqY = z;
            return this;
        }

        public a Nk(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oqZ = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c edy() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
