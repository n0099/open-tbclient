package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import d.c.c.b.d.k;
/* loaded from: classes5.dex */
public class a extends VAdError {

    /* renamed from: b  reason: collision with root package name */
    public Intent f26933b;

    public a(k kVar) {
        super(kVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f26933b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
