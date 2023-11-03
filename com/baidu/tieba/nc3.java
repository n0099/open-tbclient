package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mc3 a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Flow d = ll4.d(str);
            if (g()) {
                obj = np2.A0().beginFlow(str);
            } else {
                obj = null;
            }
            return new mc3(obj, d);
        }
        return (mc3) invokeL.objValue;
    }

    public static void b(@NonNull mc3 mc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, mc3Var) == null) {
            if (g()) {
                np2.A0().b(mc3Var.b());
            }
            Flow a = mc3Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull mc3 mc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mc3Var) == null) {
            if (g()) {
                np2.A0().c(mc3Var.b());
            }
            Flow a = mc3Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull mc3 mc3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, mc3Var, str, str2) == null) {
            if (g()) {
                np2.A0().a(mc3Var.b(), str, str2);
            }
            Flow a = mc3Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                np2.A0().f(str, jSONObject);
            }
            ll4.m(str2, jSONObject);
        }
    }

    public static void e(@NonNull mc3 mc3Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{mc3Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                np2.A0().g(mc3Var.b(), str, str2, j);
            }
            Flow a = mc3Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull mc3 mc3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, mc3Var, str) == null) {
            if (g()) {
                np2.A0().h(mc3Var.b(), str);
            }
            Flow a = mc3Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                np2.A0().i(str, str2);
            }
            ll4.i(str, str2);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                np2.A0().d(str, map);
            }
            ll4.k(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                np2.A0().f(str, jSONObject);
            }
            ll4.m(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            np2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            np2.A0().f(str, jSONObject);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return np2.A0().e();
        }
        return invokeV.booleanValue;
    }
}
