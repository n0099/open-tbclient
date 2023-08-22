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
/* loaded from: classes6.dex */
public class k64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static long b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947865024, "Lcom/baidu/tieba/k64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947865024, "Lcom/baidu/tieba/k64;");
                return;
            }
        }
        a = nr1.a;
        b = 86400000L;
        c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        l64 l64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            db3 M = db3.M();
            k32 k32Var = null;
            if (jsObject != null && M != null && b(M)) {
                if (a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                k32 F = k32.F(jsObject);
                String B = F.B("swanGameId");
                if (!TextUtils.isEmpty(B)) {
                    lj3 a2 = rj3.a();
                    if (!c(Long.valueOf(a2.getLong(B + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(B + "_Duration", 0L);
                    }
                    l64Var = new l64();
                    l64Var.duration = a2.getLong(B + "_Duration", 0L);
                } else {
                    l64Var = null;
                }
                k32Var = F;
            } else {
                l64Var = null;
            }
            pd4.call(k32Var, true, l64Var);
        }
    }

    public static boolean b(db3 db3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, db3Var)) == null) {
            String string = rj3.a().getString(c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (db3.g0().contains(jSONArray.optString(i))) {
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
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && j2 > j && db3.M() != null && !TextUtils.isEmpty(db3.g0())) {
            String g0 = db3.g0();
            lj3 a2 = rj3.a();
            long j3 = a2.getLong(g0 + "_LastPause", 0L);
            long j4 = a2.getLong(g0 + "_Duration", 0L);
            if (c(Long.valueOf(j), Long.valueOf(j2))) {
                if (c(Long.valueOf(j3), Long.valueOf(j))) {
                    a2.putLong(g0 + "_Duration", (j4 + j2) - j);
                } else {
                    a2.putLong(g0 + "_Duration", j2 - j);
                }
            } else {
                a2.putLong(g0 + "_Duration", j2 % b);
            }
            a2.putLong(g0 + "_LastPause", System.currentTimeMillis());
        }
    }
}
