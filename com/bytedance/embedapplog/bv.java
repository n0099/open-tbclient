package com.bytedance.embedapplog;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes6.dex */
abstract class bv {

    /* renamed from: a  reason: collision with root package name */
    final Context f3924a;
    private int b = 0;
    private boolean c;

    abstract boolean a();

    abstract long b();

    abstract boolean d();

    abstract String e();

    abstract long[] eon();

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(Context context) {
        this.f3924a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long h() {
        boolean z;
        long j;
        if (!(!a() || ar.a(this.f3924a))) {
            return AppStatusRules.DEFAULT_GRANULARITY;
        }
        long b = b();
        long currentTimeMillis = System.currentTimeMillis();
        if (b <= 1000 + currentTimeMillis) {
            try {
                z = d();
            } catch (Exception e) {
                au.a(e);
                z = false;
            }
            if (z) {
                this.b = 0;
                j = b() - System.currentTimeMillis();
            } else {
                long[] eon = eon();
                int i = this.b;
                this.b = i + 1;
                j = eon[i % eon.length];
            }
            au.d(e() + " worked:" + z + " " + j, null);
            return j;
        }
        return b - currentTimeMillis;
    }
}
