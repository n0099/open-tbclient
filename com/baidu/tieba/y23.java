package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class y23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948278223, "Lcom/baidu/tieba/y23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948278223, "Lcom/baidu/tieba/y23;");
                return;
            }
        }
        a = do1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<n33> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ii2.k()) {
                boolean z = false;
                for (n33 n33Var : e) {
                    String h = ii2.h(n33Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        n33Var.e = h;
                        c(jSONObject, jSONObject2, n33Var);
                        z = true;
                        t42.i("Module-Plugin", "use debug dependencies，name=" + n33Var.a + " path=" + n33Var.e);
                    } else {
                        t42.o("Module-Plugin", "debug dependencies not exist，name=" + n33Var.a + " path=" + n33Var.e);
                    }
                }
                if (!z) {
                    l73.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    t42.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            r33.c("dependenciesPath", jSONObject3);
            r33.c("dependenciesConfig", jSONObject4);
            return;
        }
        r33.c("dependenciesPath", null);
        r33.c("dependenciesConfig", null);
        if (a) {
            l33.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<n33> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (n33 n33Var : list) {
            if (n33Var != null) {
                if (n33Var.g) {
                    c(jSONObject, jSONObject2, n33Var);
                } else {
                    ug4 q = qf4.i().q(n33Var.a, n33Var.h, n33Var.i);
                    if (q == null) {
                        l33.a(Log.getStackTraceString(new Throwable(n33Var.a + " query db fail")));
                    } else {
                        File t = pq2.t(n33Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            n33Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, n33Var);
                        } else {
                            l33.a(Log.getStackTraceString(new Throwable(n33Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull n33 n33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, n33Var) == null) {
            String str = n33Var.e;
            String str2 = n33Var.f;
            if (a) {
                l33.b("apply dep path, name = " + n33Var.a + "; inline = " + n33Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                l33.b(Log.getStackTraceString(new Throwable(n33Var.a + " path is empty")));
                return;
            }
            tk3.f(jSONObject, n33Var.a, str);
            if (!TextUtils.isEmpty(n33Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    tk3.f(jSONObject2, n33Var.a, tk3.d(xn4.E(file)));
                }
            }
        }
    }
}
