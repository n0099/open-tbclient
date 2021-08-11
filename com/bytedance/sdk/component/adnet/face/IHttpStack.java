package com.bytedance.sdk.component.adnet.face;

import com.bytedance.sdk.component.adnet.core.HttpResponse;
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.err.VAdError;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes9.dex */
public interface IHttpStack {
    HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, VAdError;
}
