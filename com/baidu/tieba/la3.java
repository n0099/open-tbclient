package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class la3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ka3 a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Flow d = kj4.d(str);
            if (g()) {
                obj = ln2.A0().beginFlow(str);
            } else {
                obj = null;
            }
            return new ka3(obj, d);
        }
        return (ka3) invokeL.objValue;
    }

    public static void b(@NonNull ka3 ka3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ka3Var) == null) {
            if (g()) {
                ln2.A0().b(ka3Var.b());
            }
            Flow a = ka3Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull ka3 ka3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ka3Var) == null) {
            if (g()) {
                ln2.A0().c(ka3Var.b());
            }
            Flow a = ka3Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull ka3 ka3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, ka3Var, str, str2) == null) {
            if (g()) {
                ln2.A0().a(ka3Var.b(), str, str2);
            }
            Flow a = ka3Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                ln2.A0().f(str, jSONObject);
            }
            kj4.l(str2, jSONObject);
        }
    }

    public static void e(@NonNull ka3 ka3Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ka3Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                ln2.A0().g(ka3Var.b(), str, str2, j);
            }
            Flow a = ka3Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull ka3 ka3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ka3Var, str) == null) {
            if (g()) {
                ln2.A0().h(ka3Var.b(), str);
            }
            Flow a = ka3Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                ln2.A0().i(str, str2);
            }
            kj4.h(str, str2);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                ln2.A0().d(str, map);
            }
            kj4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                ln2.A0().f(str, jSONObject);
            }
            kj4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            ln2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            ln2.A0().f(str, jSONObject);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return ln2.A0().e();
        }
        return invokeV.booleanValue;
    }
}
