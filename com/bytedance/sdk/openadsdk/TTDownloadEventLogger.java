package com.bytedance.sdk.openadsdk;

import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface TTDownloadEventLogger {
    void onEvent(JSONObject jSONObject);

    void onV3Event(JSONObject jSONObject);

    boolean shouldFilterOpenSdkLog();
}
