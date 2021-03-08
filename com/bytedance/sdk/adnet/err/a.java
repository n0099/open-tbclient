package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import com.bytedance.sdk.adnet.core.k;
/* loaded from: classes6.dex */
public class a extends VAdError {

    /* renamed from: a  reason: collision with root package name */
    private Intent f4060a;

    public a() {
    }

    public a(k kVar) {
        super(kVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f4060a != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
