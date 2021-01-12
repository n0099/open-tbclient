package com.baidu.ubs.analytics;

import android.content.Context;
import com.baidu.ubs.analytics.d.j;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes3.dex */
public final class c {
    private long e;
    private Context mContext;
    private boolean oJo;
    private long oJp;
    private long oJq;
    private boolean oJr;
    private int oJs;

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private c(a aVar) {
        this.mContext = aVar.mContext;
        this.oJo = aVar.oJo;
        this.e = aVar.oJt;
        this.oJp = aVar.oJp;
        this.oJr = aVar.oJr;
        this.oJq = aVar.oJq;
        this.oJs = aVar.oJs;
    }

    public final Context b() {
        return this.mContext;
    }

    public final boolean c() {
        return this.oJo;
    }

    public final long d() {
        return this.e;
    }

    public final long e() {
        return this.oJp;
    }

    public final long f() {
        return this.oJq;
    }

    public final boolean g() {
        return this.oJr;
    }

    public final int h() {
        return this.oJs;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Context mContext;
        private boolean oJo = true;
        private long oJt = 30000;
        private long oJp = AppStatusRules.DEFAULT_GRANULARITY;
        private long oJq = 10000;
        private boolean oJr = false;
        private int oJs = 1000;

        public a hl(Context context) {
            this.mContext = context;
            return this;
        }

        public a Ai(boolean z) {
            this.oJo = z;
            return this;
        }

        public a hR(long j) {
            this.oJt = 1000 * j;
            return this;
        }

        public a MS(int i) {
            this.oJp = i * 60 * 1000;
            return this;
        }

        public a hS(long j) {
            this.oJq = 1000 * j;
            return this;
        }

        public a Aj(boolean z) {
            this.oJr = z;
            return this;
        }

        public a MT(int i) {
            int i2 = i <= 0 ? 0 : i;
            this.oJs = i2 < 1000 ? i2 : 1000;
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
