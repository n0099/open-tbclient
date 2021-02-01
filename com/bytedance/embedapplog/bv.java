package com.bytedance.embedapplog;

import android.content.Context;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes6.dex */
abstract class bv {

    /* renamed from: a  reason: collision with root package name */
    final Context f5816a;

    /* renamed from: b  reason: collision with root package name */
    private int f5817b = 0;
    private boolean c;

    abstract boolean a();

    abstract long b();

    abstract boolean d();

    abstract String e();

    abstract long[] enU();

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(Context context) {
        this.f5816a = context;
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
        if (!(!a() || ar.a(this.f5816a))) {
            return AppStatusRules.DEFAULT_GRANULARITY;
        }
        long b2 = b();
        long currentTimeMillis = System.currentTimeMillis();
        if (b2 <= 1000 + currentTimeMillis) {
            try {
                z = d();
            } catch (Exception e) {
                au.a(e);
                z = false;
            }
            if (z) {
                this.f5817b = 0;
                j = b() - System.currentTimeMillis();
            } else {
                long[] enU = enU();
                int i = this.f5817b;
                this.f5817b = i + 1;
                j = enU[i % enU.length];
            }
            au.d(e() + " worked:" + z + " " + j, null);
            return j;
        }
        return b2 - currentTimeMillis;
    }
}
