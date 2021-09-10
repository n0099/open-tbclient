package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.NetClient;
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
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class u implements TTAdManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f67019a;

    /* renamed from: b  reason: collision with root package name */
    public String f67020b;

    public u() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67019a = "com.union_test.toutiao";
        this.f67020b = "5001121";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: a */
    public u setAppId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            h.d().a(str);
            return this;
        }
        return (u) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: b */
    public u setName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            h.d().b(str);
            return this;
        }
        return (u) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: c */
    public u setKeywords(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            h.d().c(str);
            return this;
        }
        return (u) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? new v(context) : (TTAdNative) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: d */
    public u setData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            h.d().d(str);
            return this;
        }
        return (u) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, adSlot)) == null) {
            if (adSlot == null || o.f() == null) {
                return null;
            }
            return o.f().a(adSlot);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTGlobalAppDownloadController getGlobalAppDownloadController(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            return null;
        }
        return (TTGlobalAppDownloadController) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "3.7.0.3" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getThemeStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? h.d().A() : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager isUseTextureView(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            h.d().e(z);
            return this;
        }
        return (TTAdManager) invokeZ.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Integer.valueOf(i2), str2, str3, str4})) == null) {
            if (this.f67019a.equals(o.a().getPackageName()) && this.f67020b.equals(h.d().h()) && !TextUtils.isEmpty(str)) {
                try {
                    Method a2 = com.bytedance.sdk.component.utils.v.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
                    if (a2 != null) {
                        a2.invoke(null, str, Integer.valueOf(i2), str2, str3, str4);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.k.b("TTAdManagerImpl", "reward component maybe not exist, pls check", th);
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager openDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            com.bytedance.sdk.component.utils.k.b();
            NetClient.openDeubg();
            com.bytedance.sdk.openadsdk.o.a.b();
            return this;
        }
        return (TTAdManager) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, context) == null) || context == null) {
            return;
        }
        TTCustomController f2 = h.d().f();
        if (f2 != null) {
            boolean isCanUseLocation = f2.isCanUseLocation();
            boolean isCanUsePhoneState = f2.isCanUsePhoneState();
            boolean isCanUseWriteExternal = f2.isCanUseWriteExternal();
            if (!isCanUseLocation && !isCanUsePhoneState && !isCanUseWriteExternal) {
                return;
            }
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        if (context != null) {
            com.bytedance.sdk.component.utils.b.a(context, intent, null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            h.d().d(z);
            return this;
        }
        return (TTAdManager) invokeZ.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowShowNotifiFromSDK(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            h.d().c(z);
            return this;
        }
        return (TTAdManager) invokeZ.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setCustomController(TTCustomController tTCustomController) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, tTCustomController)) == null) {
            h.d().a(tTCustomController);
            return this;
        }
        return (TTAdManager) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setDirectDownloadNetworkType(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, iArr)) == null) {
            h.d().a(iArr);
            return this;
        }
        return (TTAdManager) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, tTGlobalAppDownloadListener)) == null) {
            h.d().a(tTGlobalAppDownloadListener);
            return this;
        }
        return (TTAdManager) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setNeedClearTaskReset(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, strArr)) == null) {
            h.d().a(strArr);
            return this;
        }
        return (TTAdManager) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTTDownloadEventLogger(TTDownloadEventLogger tTDownloadEventLogger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, tTDownloadEventLogger)) == null) {
            h.d().a(tTDownloadEventLogger);
            return this;
        }
        return (TTAdManager) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTTSecAbs(TTSecAbs tTSecAbs) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, tTSecAbs)) == null) {
            h.d().a(tTSecAbs);
            return this;
        }
        return (TTAdManager) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void setThemeStatus(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || i2 == h.d().A()) {
            return;
        }
        h.d().c(i2);
        Intent intent = new Intent();
        intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
        intent.putExtra("theme_status_change", i2);
        Context a2 = o.a();
        a2.sendBroadcast(intent, com.bytedance.sdk.openadsdk.q.q.d() + ".openadsdk.permission.TT_PANGOLIN");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTitleBarTheme(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            h.d().a(i2);
            return this;
        }
        return (TTAdManager) invokeI.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, activity, exitInstallListener)) == null) ? com.bytedance.sdk.openadsdk.downloadnew.a.a(activity, exitInstallListener) : invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* renamed from: a */
    public u setPaid(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            h.d().b(z);
            return this;
        }
        return (u) invokeZ.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken(AdSlot adSlot, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{adSlot, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (adSlot == null || o.f() == null) {
                return null;
            }
            return o.f().a(adSlot, z, i2);
        }
        return (String) invokeCommon.objValue;
    }
}
