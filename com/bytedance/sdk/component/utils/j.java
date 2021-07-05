package com.bytedance.sdk.component.utils;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f28791a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f28792b = 4;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1410335756, "Lcom/bytedance/sdk/component/utils/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1410335756, "Lcom/bytedance/sdk/component/utils/j;");
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f28792b = i2;
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            f28791a = true;
            a(3);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f28791a : invokeV.booleanValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) || !f28791a || str2 == null || f28792b > 5) {
            return;
        }
        Log.w(str, str2);
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) || str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        Log.i(str, str2);
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, str, str2) == null) || !f28791a || str2 == null || f28792b > 6) {
            return;
        }
        Log.e(str, str2);
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f28792b <= 3 : invokeV.booleanValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) || !f28791a || str2 == null || f28792b > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65540, null, str, str2) == null) || !f28791a || str2 == null || f28792b > 2) {
            return;
        }
        Log.v(str, str2);
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) || !f28791a || str2 == null || f28792b > 3) {
            return;
        }
        Log.d(str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, null, str, str2, th) == null) && f28791a) {
            if (!(str2 == null && th == null) && f28792b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && f28791a) {
            b("Logger", str);
        }
    }

    public static void b(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, str, objArr) == null) || !f28791a || objArr == null || f28792b > 4) {
            return;
        }
        Log.v(str, a(objArr));
    }

    public static void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, th) == null) && f28791a) {
            if (!(str2 == null && th == null) && f28792b <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void c(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, str, objArr) == null) || !f28791a || objArr == null || f28792b > 6) {
            return;
        }
        Log.v(str, a(objArr));
    }

    public static void b(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65547, null, str, str2, th) == null) && f28791a) {
            if (!(str2 == null && th == null) && f28792b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, objArr) == null) || !f28791a || objArr == null || f28792b > 3) {
            return;
        }
        Log.v(str, a(objArr));
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, str) == null) && f28791a) {
            f("Logger", str);
        }
    }

    public static String a(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, objArr)) == null) {
            if (objArr == null || objArr.length == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                } else {
                    sb.append(" null ");
                }
                sb.append(" ");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
