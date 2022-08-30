package com.baidu.tieba;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                return Integer.parseInt(Build.VERSION.SDK);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a() >= 14 : invokeV.booleanValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Resources resources;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (!b() || (identifier = (resources = activity.getResources()).getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android")) <= 0) {
                return false;
            }
            return resources.getBoolean(identifier);
        }
        return invokeL.booleanValue;
    }
}
