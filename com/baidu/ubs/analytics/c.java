package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private boolean lOb;
    private long lOc;
    private long lOd;
    private boolean lOe;
    private int lOf;
    private Context mContext;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.lOb = aVar.lOb;
        this.e = aVar.lOg;
        this.lOc = aVar.lOc;
        this.lOe = aVar.lOe;
        this.lOd = aVar.lOd;
        this.lOf = aVar.lOf;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.lOb;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.lOc;
    }

    public final long f() {
        return this.lOd;
    }

    public final boolean g() {
        return this.lOe;
    }

    public final int h() {
        return this.lOf;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean lOb = true;
        private long lOg = 30000;
        private long lOc = 60000;
        private long lOd = 10000;
        private boolean lOe = false;
        private int lOf = 1000;

        public a ft(Context context) {
            this.mContext = context;
            return this;
        }

        public a vq(boolean z) {
            this.lOb = z;
            return this;
        }

        public a fA(long j) {
            this.lOg = 1000 * j;
            return this;
        }

        public a FM(int i) {
            this.lOc = i * 60 * 1000;
            return this;
        }

        public a fB(long j) {
            this.lOd = 1000 * j;
            return this;
        }

        public a vr(boolean z) {
            this.lOe = z;
            return this;
        }

        public a FN(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.lOf = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dkS() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
