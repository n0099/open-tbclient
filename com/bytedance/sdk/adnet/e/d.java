package com.bytedance.sdk.adnet.e;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes4.dex */
public interface d {
    void a(Request<?> request, p<?> pVar);

    void a(Request<?> request, p<?> pVar, Runnable runnable);

    void a(Request<?> request, VAdError vAdError);
}
