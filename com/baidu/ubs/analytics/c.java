package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oJp;
    private long oJq;
    private long oJr;
    private boolean oJs;
    private int oJt;

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oJp = aVar.oJp;
        this.e = aVar.oJu;
        this.oJq = aVar.oJq;
        this.oJs = aVar.oJs;
        this.oJr = aVar.oJr;
        this.oJt = aVar.oJt;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oJp;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oJq;
    }

    public final long f() {
        return this.oJr;
    }

    public final boolean g() {
        return this.oJs;
    }

    public final int h() {
        return this.oJt;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean oJp = true;
        private long oJu = 30000;
        private long oJq = AppStatusRules.DEFAULT_GRANULARITY;
        private long oJr = 10000;
        private boolean oJs = false;
        private int oJt = 1000;

        public a hl(Context context) {
            this.mContext = context;
            return this;
        }

        public a Ai(boolean z) {
            this.oJp = z;
            return this;
        }

        public a hR(long j) {
            this.oJu = 1000 * j;
            return this;
        }

        public a MS(int i) {
            this.oJq = i * 60 * 1000;
            return this;
        }

        public a hS(long j) {
            this.oJr = 1000 * j;
            return this;
        }

        public a Aj(boolean z) {
            this.oJs = z;
            return this;
        }

        public a MT(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oJt = i2 < 1000 ? i2 : 1000;
            return this;
        }

        public c efF() {
            if (this.mContext == null) {
                j.I("Context must be not empty!");
                return null;
            }
            return new c(this, (byte) 0);
        }
    }
}
