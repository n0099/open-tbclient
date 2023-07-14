package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class yl {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, bm> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448322810, "Lcom/baidu/tieba/yl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448322810, "Lcom/baidu/tieba/yl;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("com.baidu.searchbox.livenps", new xl());
    }

    public static void a(String str, int i) {
        bm bmVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) && (bmVar = a.get(str)) != null) {
            bmVar.b(i);
        }
    }

    public static void b(String str, int i, long j) {
        bm bmVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bmVar = a.get(str)) != null) {
            bmVar.c(i, j);
        }
    }

    public static void c(String str, int i, int i2) {
        bm bmVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) && (bmVar = a.get(str)) != null) {
            bmVar.d(i, i2);
        }
    }

    public static void d(String str, int i, int i2) {
        bm bmVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) && (bmVar = a.get(str)) != null) {
            bmVar.e(i, i2);
        }
    }
}
