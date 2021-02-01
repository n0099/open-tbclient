package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadController;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.utils.ah;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class v implements TTAdManager {

    /* renamed from: a  reason: collision with root package name */
    String f6687a = "com.union_test.toutiao";

    /* renamed from: b  reason: collision with root package name */
    String f6688b = "5001121";

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: a */
    public v setAppId(String str) {
        i.c().a(str);
        com.bytedance.sdk.openadsdk.core.h.h.a(p.i()).a();
        com.bytedance.sdk.openadsdk.core.h.i.a(p.h()).c();
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: b */
    public v setName(String str) {
        i.c().b(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: a */
    public v setPaid(boolean z) {
        i.c().a(z);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: c */
    public v setKeywords(String str) {
        i.c().c(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: d */
    public v setData(String str) {
        i.c().d(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTitleBarTheme(int i) {
        i.c().a(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowShowNotifiFromSDK(boolean z) {
        i.c().b(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager openDebugMode() {
        com.bytedance.sdk.openadsdk.utils.u.b();
        com.bytedance.sdk.adnet.a.c();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z) {
        i.c().c(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        i.c().a(tTGlobalAppDownloadListener);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTGlobalAppDownloadController getGlobalAppDownloadController(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setDirectDownloadNetworkType(int... iArr) {
        i.c().a(iArr);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        i.c().n();
        return new w(context);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager isUseTextureView(boolean z) {
        i.c().d(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
        i.c().a(tTDownloadEventLogger);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTTSecAbs(TTSecAbs tTSecAbs) {
        i.c().a(tTSecAbs);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setCustomController(TTCustomController tTCustomController) {
        i.c().a(tTCustomController);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setNeedClearTaskReset(String[] strArr) {
        i.c().a(strArr);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        TTCustomController d = i.c().d();
        if (d != null) {
            boolean isCanUseLocation = d.isCanUseLocation();
            boolean isCanUsePhoneState = d.isCanUsePhoneState();
            boolean isCanUseWriteExternal = d.isCanUseWriteExternal();
            if (!isCanUseLocation && !isCanUsePhoneState && !isCanUseWriteExternal) {
                return;
            }
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        if (context != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Context context, ExitInstallListener exitInstallListener) {
        return com.bytedance.sdk.openadsdk.downloadnew.a.a(context, exitInstallListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "3.2.5.1";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (this.f6687a.equals(p.a().getPackageName()) && this.f6688b.equals(i.c().e()) && !TextUtils.isEmpty(str)) {
            try {
                Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
                if (a2 != null) {
                    a2.invoke(null, str, Integer.valueOf(i), str2, str3, str4);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdManagerImpl", "reward component maybe not exist, pls check", th);
            }
            return true;
        }
        return false;
    }
}
