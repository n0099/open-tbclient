package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import d.c.c.b.d.k;
/* loaded from: classes4.dex */
public class a extends VAdError {

    /* renamed from: b  reason: collision with root package name */
    public Intent f27240b;

    public a(k kVar) {
        super(kVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f27240b != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
