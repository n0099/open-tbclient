package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class l93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            return str + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, str, z) == null) {
            ac3.a().putBoolean(a("SwanAppStabilitySp-autoObtain", str), z);
        }
    }

    public static void j(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, str, i) == null) {
            ac3.a().putInt(a("SwanAppStabilitySp-autoObtainDataLen", str), i);
        }
    }

    public static void k(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, str, i) == null) {
            ac3.a().putInt(a("SwanAppStabilitySp-obtainIntervalMs", str), i);
        }
    }

    public static void l(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65547, null, z, str) == null) {
            ac3.a().putBoolean(a("SwanAppStabilitySp-obtainData", str), z);
        }
    }

    public static void m(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65548, null, z, str) == null) {
            ac3.a().putBoolean(a("SwanAppStabilitySp-stabilityProfile", str), z);
        }
    }

    public static void n(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, str, i) == null) {
            ac3.a().putInt(a("SwanAppStabilitySp-swanStartupStability", str), i);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            String appId = l33.K().getAppId();
            ub3 a = ac3.a();
            a.remove(a("SwanAppStabilitySp-obtainData", appId));
            a.remove(a("SwanAppStabilitySp-autoObtain", appId));
            a.remove(a("SwanAppStabilitySp-swanStartupStability", appId));
            a.remove(a("SwanAppStabilitySp-obtainIntervalMs", appId));
            a.remove(a("SwanAppStabilitySp-autoObtainDataLen", appId));
            a.remove(a("SwanAppStabilitySp-stabilityProfile", appId));
        }
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return ac3.a().getInt(a("SwanAppStabilitySp-autoObtainDataLen", l33.K().getAppId()), i);
        }
        return invokeI.intValue;
    }

    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return ac3.a().getInt(a("SwanAppStabilitySp-obtainIntervalMs", l33.K().getAppId()), i);
        }
        return invokeI.intValue;
    }

    public static int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return ac3.a().getInt(a("SwanAppStabilitySp-swanStartupStability", l33.K().getAppId()), i);
        }
        return invokeI.intValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return ac3.a().getBoolean(a("SwanAppStabilitySp-autoObtain", l33.K().getAppId()), false);
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return ac3.a().getBoolean(a("SwanAppStabilitySp-obtainData", l33.K().getAppId()), false);
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return ac3.a().getBoolean(a("SwanAppStabilitySp-stabilityProfile", l33.K().getAppId()), false);
        }
        return invokeV.booleanValue;
    }
}
