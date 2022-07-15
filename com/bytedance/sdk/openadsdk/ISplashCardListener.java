package com.bytedance.sdk.openadsdk;

import android.app.Activity;
/* loaded from: classes4.dex */
public interface ISplashCardListener {
    Activity getActivity();

    void onSplashClickEyeClose();

    void onSplashEyeReady();

    void setSupportSplashClickEye(boolean z);
}
