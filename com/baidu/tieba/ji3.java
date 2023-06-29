package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ji3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ii3 a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Flow d = ir4.d(str);
            if (g()) {
                obj = jv2.A0().beginFlow(str);
            } else {
                obj = null;
            }
            return new ii3(obj, d);
        }
        return (ii3) invokeL.objValue;
    }

    public static void b(@NonNull ii3 ii3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ii3Var) == null) {
            if (g()) {
                jv2.A0().b(ii3Var.b());
            }
            Flow a = ii3Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull ii3 ii3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ii3Var) == null) {
            if (g()) {
                jv2.A0().c(ii3Var.b());
            }
            Flow a = ii3Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull ii3 ii3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, ii3Var, str, str2) == null) {
            if (g()) {
                jv2.A0().a(ii3Var.b(), str, str2);
            }
            Flow a = ii3Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                jv2.A0().f(str, jSONObject);
            }
            ir4.l(str2, jSONObject);
        }
    }

    public static void e(@NonNull ii3 ii3Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ii3Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                jv2.A0().g(ii3Var.b(), str, str2, j);
            }
            Flow a = ii3Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull ii3 ii3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ii3Var, str) == null) {
            if (g()) {
                jv2.A0().h(ii3Var.b(), str);
            }
            Flow a = ii3Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                jv2.A0().i(str, str2);
            }
            ir4.h(str, str2);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                jv2.A0().d(str, map);
            }
            ir4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                jv2.A0().f(str, jSONObject);
            }
            ir4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            jv2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            jv2.A0().f(str, jSONObject);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return jv2.A0().e();
        }
        return invokeV.booleanValue;
    }
}
