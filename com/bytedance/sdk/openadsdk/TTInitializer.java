package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdSdk;
/* loaded from: classes12.dex */
public interface TTInitializer {
    TTAdManager getAdManager();

    TTAdManager init(Context context, AdConfig adConfig);

    void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback);

    boolean isInitSuccess();
}
