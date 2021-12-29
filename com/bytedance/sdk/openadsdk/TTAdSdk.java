package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.b.d;
import com.bytedance.sdk.openadsdk.api.plugin.g;
/* loaded from: classes2.dex */
public final class TTAdSdk {
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final TTInitializer a = new g();

    /* loaded from: classes2.dex */
    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    public static void a(Context context, TTAdConfig tTAdConfig) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            d.a("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        a(context, "Context is null, please check.");
        a(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        if (tTAdConfig.isDebug()) {
            d.a();
        }
        tTAdConfig.setExtra(TTAdConstant.PANGLE_INIT_START_TIME, Long.valueOf(SystemClock.elapsedRealtime()));
        tTAdConfig.setExtra(TTAdConstant.KEY_S_C, "main");
    }

    public static TTAdManager getAdManager() {
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            return tTInitializer.getAdManager();
        }
        return null;
    }

    @Deprecated
    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        d.a("Please call init(final Context context, final TTAdConfig config, final InitCallback callback), this method will be deprecated");
        a(context, tTAdConfig);
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            return tTInitializer.init(context, tTAdConfig);
        }
        return null;
    }

    public static boolean isInitSuccess() {
        TTInitializer tTInitializer = a;
        if (tTInitializer != null) {
            return tTInitializer.isInitSuccess();
        }
        return false;
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        TTAdManager adManager;
        if (tTAdConfig == null || (adManager = a.getAdManager()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (bundle.keySet().isEmpty()) {
            return;
        }
        adManager.getExtra(AdConfig.class, bundle);
    }

    public static void updatePaid(boolean z) {
        TTAdManager adManager = a.getAdManager();
        if (adManager == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        adManager.getExtra(AdConfig.class, bundle);
    }

    public static void init(Context context, TTAdConfig tTAdConfig, InitCallback initCallback) {
        a(context, tTAdConfig);
        TTInitializer tTInitializer = a;
        if (tTInitializer == null) {
            initCallback.fail(4100, "Load initializer failed");
        } else {
            tTInitializer.init(context, tTAdConfig, initCallback);
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
