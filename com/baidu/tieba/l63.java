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
/* loaded from: classes6.dex */
public class l63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947894784, "Lcom/baidu/tieba/l63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947894784, "Lcom/baidu/tieba/l63;");
                return;
            }
        }
        a = qr1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<a73> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (vl2.k()) {
                boolean z = false;
                for (a73 a73Var : e) {
                    String h = vl2.h(a73Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        a73Var.e = h;
                        c(jSONObject, jSONObject2, a73Var);
                        z = true;
                        g82.i("Module-Plugin", "use debug dependencies，name=" + a73Var.a + " path=" + a73Var.e);
                    } else {
                        g82.o("Module-Plugin", "debug dependencies not exist，name=" + a73Var.a + " path=" + a73Var.e);
                    }
                }
                if (!z) {
                    ya3.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    g82.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            e73.c("dependenciesPath", jSONObject3);
            e73.c("dependenciesConfig", jSONObject4);
            return;
        }
        e73.c("dependenciesPath", null);
        e73.c("dependenciesConfig", null);
        if (a) {
            y63.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<a73> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (a73 a73Var : list) {
            if (a73Var != null) {
                if (a73Var.g) {
                    c(jSONObject, jSONObject2, a73Var);
                } else {
                    hk4 q = dj4.i().q(a73Var.a, a73Var.h, a73Var.i);
                    if (q == null) {
                        y63.a(Log.getStackTraceString(new Throwable(a73Var.a + " query db fail")));
                    } else {
                        File t = cu2.t(a73Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            a73Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, a73Var);
                        } else {
                            y63.a(Log.getStackTraceString(new Throwable(a73Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull a73 a73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, a73Var) == null) {
            String str = a73Var.e;
            String str2 = a73Var.f;
            if (a) {
                y63.b("apply dep path, name = " + a73Var.a + "; inline = " + a73Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                y63.b(Log.getStackTraceString(new Throwable(a73Var.a + " path is empty")));
                return;
            }
            go3.f(jSONObject, a73Var.a, str);
            if (!TextUtils.isEmpty(a73Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    go3.f(jSONObject2, a73Var.a, go3.d(kr4.E(file)));
                }
            }
        }
    }
}
