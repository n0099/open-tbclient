package com.bytedance.sdk.adnet.e;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.err.VAdError;
/* loaded from: classes6.dex */
public interface d {
    void a(Request<?> request, o<?> oVar);

    void a(Request<?> request, o<?> oVar, Runnable runnable);

    void a(Request<?> request, VAdError vAdError);
}
