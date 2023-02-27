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
public class r43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948071608, "Lcom/baidu/tieba/r43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948071608, "Lcom/baidu/tieba/r43;");
                return;
            }
        }
        a = wp1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<g53> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (bk2.k()) {
                boolean z = false;
                for (g53 g53Var : e) {
                    String h = bk2.h(g53Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        g53Var.e = h;
                        c(jSONObject, jSONObject2, g53Var);
                        z = true;
                        m62.i("Module-Plugin", "use debug dependencies，name=" + g53Var.a + " path=" + g53Var.e);
                    } else {
                        m62.o("Module-Plugin", "debug dependencies not exist，name=" + g53Var.a + " path=" + g53Var.e);
                    }
                }
                if (!z) {
                    e93.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    m62.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            k53.c("dependenciesPath", jSONObject3);
            k53.c("dependenciesConfig", jSONObject4);
            return;
        }
        k53.c("dependenciesPath", null);
        k53.c("dependenciesConfig", null);
        if (a) {
            e53.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<g53> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (g53 g53Var : list) {
            if (g53Var != null) {
                if (g53Var.g) {
                    c(jSONObject, jSONObject2, g53Var);
                } else {
                    ni4 q = jh4.i().q(g53Var.a, g53Var.h, g53Var.i);
                    if (q == null) {
                        e53.a(Log.getStackTraceString(new Throwable(g53Var.a + " query db fail")));
                    } else {
                        File t = is2.t(g53Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            g53Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, g53Var);
                        } else {
                            e53.a(Log.getStackTraceString(new Throwable(g53Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull g53 g53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, g53Var) == null) {
            String str = g53Var.e;
            String str2 = g53Var.f;
            if (a) {
                e53.b("apply dep path, name = " + g53Var.a + "; inline = " + g53Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                e53.b(Log.getStackTraceString(new Throwable(g53Var.a + " path is empty")));
                return;
            }
            mm3.f(jSONObject, g53Var.a, str);
            if (!TextUtils.isEmpty(g53Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    mm3.f(jSONObject2, g53Var.a, mm3.d(qp4.E(file)));
                }
            }
        }
    }
}
