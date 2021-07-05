package com.bytedance.sdk.component.video.d;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f28851a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f28852b = 4;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2068726180, "Lcom/bytedance/sdk/component/video/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2068726180, "Lcom/bytedance/sdk/component/video/d/c;");
        }
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            f28852b = i2;
        }
    }

    public static void b(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, objArr) == null) || !f28851a || objArr == null || f28852b > 4) {
            return;
        }
        Log.v(str, a(objArr));
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f28851a = true;
            a(3);
        }
    }

    public static void a(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, objArr) == null) || !f28851a || objArr == null || f28852b > 3) {
            return;
        }
        Log.v(str, a(objArr));
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, null, str) == null) && f28851a) {
            a("VideoLog", str);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) || !f28851a || str2 == null || f28852b > 4) {
            return;
        }
        Log.i(str, str2);
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
