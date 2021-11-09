package com.bytedance.sdk.openadsdk.api.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes11.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f61592a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f61593b = 4;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-678774130, "Lcom/bytedance/sdk/openadsdk/api/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-678774130, "Lcom/bytedance/sdk/openadsdk/api/b/d;");
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f61593b = i2;
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) && f61592a && str2 != null) {
            int i2 = f61593b;
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) && f61592a && str2 != null) {
            int i2 = f61593b;
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) && f61592a && str2 != null) {
            int i2 = f61593b;
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f61592a = true;
            a(3);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, str, str2, th) == null) && f61592a) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = f61593b;
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && f61592a && str2 != null) {
            int i2 = f61593b;
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && f61592a) {
            c("TTLogger", str);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, th) == null) && f61592a) {
            if (str2 == null && th == null) {
                return;
            }
            int i2 = f61593b;
        }
    }
}
