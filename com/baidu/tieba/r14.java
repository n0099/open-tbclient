package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class r14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948068756, "Lcom/baidu/tieba/r14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948068756, "Lcom/baidu/tieba/r14;");
                return;
            }
        }
        a = vm1.a;
        b = 86400000L;
        c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        s14 s14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            k63 M = k63.M();
            sy1 sy1Var = null;
            if (jsObject != null && M != null && b(M)) {
                if (a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                sy1 G = sy1.G(jsObject);
                String C = G.C("swanGameId");
                if (!TextUtils.isEmpty(C)) {
                    se3 a2 = ye3.a();
                    if (!c(Long.valueOf(a2.getLong(C + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(C + "_Duration", 0L);
                    }
                    s14Var = new s14();
                    s14Var.duration = a2.getLong(C + "_Duration", 0L);
                } else {
                    s14Var = null;
                }
                sy1Var = G;
            } else {
                s14Var = null;
            }
            w84.a(sy1Var, true, s14Var);
        }
    }

    public static boolean b(k63 k63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, k63Var)) == null) {
            String string = ye3.a().getString(c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (k63.h0().contains(jSONArray.optString(i))) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, l, l2)) == null) {
            if (l.longValue() / 86400000 == l2.longValue() / 86400000) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void d(long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && j2 > j && k63.M() != null && !TextUtils.isEmpty(k63.h0())) {
            String h0 = k63.h0();
            se3 a2 = ye3.a();
            long j3 = a2.getLong(h0 + "_LastPause", 0L);
            long j4 = a2.getLong(h0 + "_Duration", 0L);
            if (c(Long.valueOf(j), Long.valueOf(j2))) {
                if (c(Long.valueOf(j3), Long.valueOf(j))) {
                    a2.putLong(h0 + "_Duration", (j4 + j2) - j);
                } else {
                    a2.putLong(h0 + "_Duration", j2 - j);
                }
            } else {
                a2.putLong(h0 + "_Duration", j2 % b);
            }
            a2.putLong(h0 + "_LastPause", System.currentTimeMillis());
        }
    }
}
