package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.k;
/* loaded from: classes6.dex */
public class VAdError extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private long f4059a;
    public final k networkResponse;

    public VAdError() {
        this.networkResponse = null;
    }

    public VAdError(k kVar) {
        this.networkResponse = kVar;
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
        this.f4059a = j;
    }

    public long getNetworkTimeMs() {
        return this.f4059a;
    }
}
