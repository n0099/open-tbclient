package com.bytedance.sdk.component.adnet.face;

import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.adnet.err.VAdError;
/* loaded from: classes5.dex */
public interface c {
    void a(Request<?> request, m<?> mVar);

    void a(Request<?> request, m<?> mVar, Runnable runnable);

    void a(Request<?> request, VAdError vAdError);
}
