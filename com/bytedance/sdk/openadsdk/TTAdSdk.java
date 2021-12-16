package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.api.b.d;
import com.bytedance.sdk.openadsdk.api.plugin.g;
/* loaded from: classes2.dex */
public final class TTAdSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final TTInitializer a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2037386439, "Lcom/bytedance/sdk/openadsdk/TTAdSdk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2037386439, "Lcom/bytedance/sdk/openadsdk/TTAdSdk;");
                return;
            }
        }
        a = new g();
    }

    public TTAdSdk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, obj, str) == null) && obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static TTAdManager getAdManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            TTInitializer tTInitializer = a;
            if (tTInitializer != null) {
                return tTInitializer.getAdManager();
            }
            return null;
        }
        return (TTAdManager) invokeV.objValue;
    }

    @Deprecated
    public static TTAdManager init(Context context, TTAdConfig tTAdConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, tTAdConfig)) == null) {
            d.a("Please call init(final Context context, final TTAdConfig config, final InitCallback callback), this method will be deprecated");
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
            TTInitializer tTInitializer = a;
            if (tTInitializer != null) {
                return tTInitializer.init(context, tTAdConfig);
            }
            return null;
        }
        return (TTAdManager) invokeLL.objValue;
    }

    public static boolean isInitSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            TTInitializer tTInitializer = a;
            if (tTInitializer != null) {
                return tTInitializer.isInitSuccess();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        TTAdManager adManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, tTAdConfig) == null) || tTAdConfig == null || (adManager = a.getAdManager()) == null) {
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
        TTAdManager adManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, null, z) == null) || (adManager = a.getAdManager()) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, tTAdConfig, initCallback) == null) {
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
            TTInitializer tTInitializer = a;
            if (tTInitializer == null) {
                initCallback.fail(4100, "Load initializer failed");
            } else {
                tTInitializer.init(context, tTAdConfig, initCallback);
            }
        }
    }
}
