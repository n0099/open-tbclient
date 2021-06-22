package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadController;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.utils.ai;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class v implements TTAdManager {

    /* renamed from: a  reason: collision with root package name */
    public String f28565a = "com.union_test.toutiao";

    /* renamed from: b  reason: collision with root package name */
    public String f28566b = "5001121";

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: a */
    public v setAppId(String str) {
        i.d().a(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: b */
    public v setName(String str) {
        i.d().b(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: c */
    public v setKeywords(String str) {
        i.d().c(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        return new w(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: d */
    public v setData(String str) {
        i.d().d(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        if (adSlot == null || p.f() == null) {
            return null;
        }
        return p.f().a(adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTGlobalAppDownloadController getGlobalAppDownloadController(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "3.4.5.5";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager isUseTextureView(boolean z) {
        i.d().e(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4) {
        if (this.f28565a.equals(p.a().getPackageName()) && this.f28566b.equals(i.d().g()) && !TextUtils.isEmpty(str)) {
            try {
                Method a2 = ai.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
                if (a2 != null) {
                    a2.invoke(null, str, Integer.valueOf(i2), str2, str3, str4);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.u.b("TTAdManagerImpl", "reward component maybe not exist, pls check", th);
            }
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager openDebugMode() {
        com.bytedance.sdk.openadsdk.utils.u.b();
        d.b.c.b.a.j();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        if (context == null) {
            return;
        }
        TTCustomController e2 = i.d().e();
        if (e2 != null) {
            boolean isCanUseLocation = e2.isCanUseLocation();
            boolean isCanUsePhoneState = e2.isCanUsePhoneState();
            boolean isCanUseWriteExternal = e2.isCanUseWriteExternal();
            if (!isCanUseLocation && !isCanUsePhoneState && !isCanUseWriteExternal) {
                return;
            }
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        intent.putExtra("type", 2);
        if (context != null) {
            com.bytedance.sdk.openadsdk.utils.b.a(context, intent, null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z) {
        i.d().d(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowShowNotifiFromSDK(boolean z) {
        i.d().c(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setCustomController(TTCustomController tTCustomController) {
        i.d().a(tTCustomController);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setDirectDownloadNetworkType(int... iArr) {
        i.d().a(iArr);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        i.d().a(tTGlobalAppDownloadListener);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setNeedClearTaskReset(String[] strArr) {
        i.d().a(strArr);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
        i.d().a(tTDownloadEventLogger);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTTSecAbs(TTSecAbs tTSecAbs) {
        i.d().a(tTSecAbs);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTitleBarTheme(int i2) {
        i.d().a(i2);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        return com.bytedance.sdk.openadsdk.downloadnew.a.a(activity, exitInstallListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: a */
    public v setPaid(boolean z) {
        i.d().b(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i2) {
        if (adSlot == null || p.f() == null) {
            return null;
        }
        return p.f().a(adSlot, z, i2);
    }
}
