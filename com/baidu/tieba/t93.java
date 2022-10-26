package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class t93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static s93 a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Flow d = si4.d(str);
            if (g()) {
                obj = tm2.A0().beginFlow(str);
            } else {
                obj = null;
            }
            return new s93(obj, d);
        }
        return (s93) invokeL.objValue;
    }

    public static void b(s93 s93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, s93Var) == null) {
            if (g()) {
                tm2.A0().b(s93Var.b());
            }
            Flow a = s93Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(s93 s93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, s93Var) == null) {
            if (g()) {
                tm2.A0().c(s93Var.b());
            }
            Flow a = s93Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(s93 s93Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, s93Var, str, str2) == null) {
            if (g()) {
                tm2.A0().a(s93Var.b(), str, str2);
            }
            Flow a = s93Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                tm2.A0().f(str, jSONObject);
            }
            si4.l(str2, jSONObject);
        }
    }

    public static void e(s93 s93Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{s93Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                tm2.A0().g(s93Var.b(), str, str2, j);
            }
            Flow a = s93Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(s93 s93Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, s93Var, str) == null) {
            if (g()) {
                tm2.A0().h(s93Var.b(), str);
            }
            Flow a = s93Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                tm2.A0().i(str, str2);
            }
            si4.h(str, str2);
        }
    }

    public static void j(String str, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                tm2.A0().d(str, map);
            }
            si4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                tm2.A0().f(str, jSONObject);
            }
            si4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            tm2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            tm2.A0().f(str, jSONObject);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return tm2.A0().e();
        }
        return invokeV.booleanValue;
    }
}
