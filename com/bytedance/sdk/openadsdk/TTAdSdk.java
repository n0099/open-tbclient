package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.p;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class TTAdSdk {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f6384a = new AtomicBoolean(false);

    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        z.a((Object) context, "Context is null, please check.");
        z.a(tTAdConfig, "TTAdConfig is null, please check.");
        updateAdConfig(tTAdConfig);
        if (tTAdConfig != null) {
            updatePaid(tTAdConfig.isPaid());
        }
        if (!f6384a.get()) {
            a(context, tTAdConfig);
            f6384a.set(true);
        }
        return getAdManager();
    }

    public static TTAdManager getAdManager() {
        return TTAdManagerFactory.a();
    }

    private static void a(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig.getHttpStack() != null) {
            e.a(tTAdConfig.getHttpStack());
        }
        m.f6906a = tTAdConfig.isAsyncInit();
        m.f6907b = tTAdConfig.getCustomController();
        if (tTAdConfig.isDebug()) {
            u.b();
        }
        TTAdManager tTAdManagerFactory = TTAdManagerFactory.getInstance(context, tTAdConfig.isSupportMultiProcess());
        if (tTAdConfig.isDebug()) {
            tTAdManagerFactory.openDebugMode();
        }
        tTAdManagerFactory.setAppId(tTAdConfig.getAppId()).setName(tTAdConfig.getAppName()).setPaid(tTAdConfig.isPaid()).setKeywords(tTAdConfig.getKeywords()).setData(tTAdConfig.getData()).setTitleBarTheme(tTAdConfig.getTitleBarTheme()).setAllowShowNotifiFromSDK(tTAdConfig.isAllowShowNotify()).setAllowLandingPageShowWhenScreenLock(tTAdConfig.isAllowShowPageWhenScreenLock()).setDirectDownloadNetworkType(tTAdConfig.getDirectDownloadNetworkType()).isUseTextureView(tTAdConfig.isUseTextureView()).setTTDownloadEventLogger(tTAdConfig.getTTDownloadEventLogger()).setNeedClearTaskReset(tTAdConfig.getNeedClearTaskReset()).setTTSecAbs(tTAdConfig.getTTSecAbs()).setCustomController(tTAdConfig.getCustomController());
        try {
            p.a();
        } catch (Throwable th) {
        }
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        if (tTAdConfig != null) {
            if (!TextUtils.isEmpty(tTAdConfig.getData())) {
                i.c().d(tTAdConfig.getData());
            }
            if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
                i.c().c(tTAdConfig.getKeywords());
            }
        }
    }

    public static void updatePaid(boolean z) {
        i.c().a(z);
    }
}
