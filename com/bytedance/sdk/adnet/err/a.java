package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import d.b.c.b.d.k;
/* loaded from: classes6.dex */
public class a extends VAdError {

    /* renamed from: b  reason: collision with root package name */
    public Intent f27108b;

    public a(k kVar) {
        super(kVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f27108b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
