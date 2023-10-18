package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class zf {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, cg> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448323585, "Lcom/baidu/tieba/zf;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448323585, "Lcom/baidu/tieba/zf;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("com.baidu.searchbox.livenps", new yf());
    }

    public static void a(String str, int i) {
        cg cgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) && (cgVar = a.get(str)) != null) {
            cgVar.b(i);
        }
    }

    public static void b(String str, int i, long j) {
        cg cgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cgVar = a.get(str)) != null) {
            cgVar.c(i, j);
        }
    }

    public static void c(String str, int i, int i2) {
        cg cgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) && (cgVar = a.get(str)) != null) {
            cgVar.d(i, i2);
        }
    }

    public static void d(String str, int i, int i2) {
        cg cgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) && (cgVar = a.get(str)) != null) {
            cgVar.e(i, i2);
        }
    }
}
