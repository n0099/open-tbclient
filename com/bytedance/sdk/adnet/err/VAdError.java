package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.l;
/* loaded from: classes4.dex */
public class VAdError extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private long f6063a;
    public final l networkResponse;

    public VAdError() {
        this.networkResponse = null;
    }

    public VAdError(l lVar) {
        this.networkResponse = lVar;
    }

    public VAdError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VAdError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VAdError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public void setNetworkTimeMs(long j) {
        this.f6063a = j;
    }

    public long getNetworkTimeMs() {
        return this.f6063a;
    }
}
