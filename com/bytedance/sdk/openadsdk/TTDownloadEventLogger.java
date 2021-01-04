package com.bytedance.sdk.openadsdk;

import com.ss.android.a.a.d.d;
/* loaded from: classes4.dex */
public interface TTDownloadEventLogger {
    void onEvent(d dVar);

    void onV3Event(d dVar);

    boolean shouldFilterOpenSdkLog();
}
