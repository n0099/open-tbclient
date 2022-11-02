package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activity)) == null) {
            if (g(activity)) {
                return c(activity);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.h, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @RequiresApi(api = 17)
    public static int d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (h(context)) {
                return 0;
            }
            return a((Activity) context);
        }
        return invokeL.intValue;
    }

    public static boolean g(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, activity)) == null) {
            View findViewById = activity.findViewById(16908336);
            if (findViewById == null || findViewById.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @RequiresApi(api = 17)
    public static boolean h(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (Settings.Global.getInt(context.getContentResolver(), b(), 0) == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) {
                return "navigationbar_is_min";
            }
            if (str.equalsIgnoreCase("XIAOMI")) {
                return "force_fsg_nav_bar";
            }
            if (!str.equalsIgnoreCase("VIVO") && !str.equalsIgnoreCase("OPPO")) {
                return "navigationbar_is_min";
            }
            return "navigation_gesture_on";
        }
        return (String) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i != 29 && i != 30) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String d = zi0.c().a().d();
            if (TextUtils.isEmpty(d)) {
                return false;
            }
            if (!d.contains("MI 8") && !d.contains("MI 9")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
