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
public class nh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mh3 a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Flow d = mq4.d(str);
            if (g()) {
                obj = nu2.A0().beginFlow(str);
            } else {
                obj = null;
            }
            return new mh3(obj, d);
        }
        return (mh3) invokeL.objValue;
    }

    public static void b(@NonNull mh3 mh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, mh3Var) == null) {
            if (g()) {
                nu2.A0().b(mh3Var.b());
            }
            Flow a = mh3Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull mh3 mh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mh3Var) == null) {
            if (g()) {
                nu2.A0().c(mh3Var.b());
            }
            Flow a = mh3Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull mh3 mh3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, mh3Var, str, str2) == null) {
            if (g()) {
                nu2.A0().a(mh3Var.b(), str, str2);
            }
            Flow a = mh3Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                nu2.A0().f(str, jSONObject);
            }
            mq4.l(str2, jSONObject);
        }
    }

    public static void e(@NonNull mh3 mh3Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{mh3Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                nu2.A0().g(mh3Var.b(), str, str2, j);
            }
            Flow a = mh3Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull mh3 mh3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, mh3Var, str) == null) {
            if (g()) {
                nu2.A0().h(mh3Var.b(), str);
            }
            Flow a = mh3Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                nu2.A0().i(str, str2);
            }
            mq4.h(str, str2);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                nu2.A0().d(str, map);
            }
            mq4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                nu2.A0().f(str, jSONObject);
            }
            mq4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            nu2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            nu2.A0().f(str, jSONObject);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return nu2.A0().e();
        }
        return invokeV.booleanValue;
    }
}
