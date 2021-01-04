package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import com.bytedance.sdk.adnet.core.l;
/* loaded from: classes4.dex */
public class a extends VAdError {

    /* renamed from: a  reason: collision with root package name */
    private Intent f6363a;

    public a() {
    }

    public a(l lVar) {
        super(lVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f6363a != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
