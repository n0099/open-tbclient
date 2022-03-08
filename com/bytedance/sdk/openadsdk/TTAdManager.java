package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
/* loaded from: classes7.dex */
public interface TTAdManager {
    TTAdNative createAdNative(Context context);

    String getBiddingToken(AdSlot adSlot);

    String getBiddingToken(AdSlot adSlot, boolean z, int i2);

    <T> T getExtra(Class<T> cls, Bundle bundle);

    String getPluginVersion();

    String getSDKVersion();

    int getThemeStatus();

    boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4);

    void register(Object obj);

    void requestPermissionIfNecessary(Context context);

    void setThemeStatus(int i2);

    boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener);

    void unregister(Object obj);
}
