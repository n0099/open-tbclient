package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
/* loaded from: classes8.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean mhq;
    private long mhr;
    private long mhs;
    private boolean mht;
    private int mhu;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.mhq = aVar.mhq;
        this.e = aVar.mhv;
        this.mhr = aVar.mhr;
        this.mht = aVar.mht;
        this.mhs = aVar.mhs;
        this.mhu = aVar.mhu;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.mhq;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.mhr;
    }

    public final long f() {
        return this.mhs;
    }

    public final boolean g() {
        return this.mht;
    }

    public final int h() {
        return this.mhu;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private Context mContext;
        private boolean mhq = true;
        private long mhv = 30000;
        private long mhr = 60000;
        private long mhs = 10000;
        private boolean mht = false;
        private int mhu = 1000;

        public a fI(Context context) {
            this.mContext = context;
            return this;
        }

        public a vO(boolean z) {
            this.mhq = z;
            return this;
        }

        public a fA(long j) {
            this.mhv = 1000 * j;
            return this;
        }

        public a Gz(int i) {
            this.mhr = i * 60 * 1000;
            return this;
        }

        public a fB(long j) {
            this.mhs = 1000 * j;
            return this;
        }

        public a vP(boolean z) {
            this.mht = z;
            return this;
        }

        public a GA(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.mhu = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c dsi() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
