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
public class p13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009143, "Lcom/baidu/tieba/p13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009143, "Lcom/baidu/tieba/p13;");
                return;
            }
        }
        a = vm1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<e23> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (zg2.k()) {
                boolean z = false;
                for (e23 e23Var : e) {
                    String h = zg2.h(e23Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        e23Var.e = h;
                        c(jSONObject, jSONObject2, e23Var);
                        z = true;
                        k32.i("Module-Plugin", "use debug dependencies，name=" + e23Var.a + " path=" + e23Var.e);
                    } else {
                        k32.o("Module-Plugin", "debug dependencies not exist，name=" + e23Var.a + " path=" + e23Var.e);
                    }
                }
                if (!z) {
                    c63.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    k32.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            i23.c("dependenciesPath", jSONObject3);
            i23.c("dependenciesConfig", jSONObject4);
            return;
        }
        i23.c("dependenciesPath", null);
        i23.c("dependenciesConfig", null);
        if (a) {
            c23.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<e23> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (e23 e23Var : list) {
            if (e23Var != null) {
                if (e23Var.g) {
                    c(jSONObject, jSONObject2, e23Var);
                } else {
                    lf4 q = he4.i().q(e23Var.a, e23Var.h, e23Var.i);
                    if (q == null) {
                        c23.a(Log.getStackTraceString(new Throwable(e23Var.a + " query db fail")));
                    } else {
                        File t = gp2.t(e23Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            e23Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, e23Var);
                        } else {
                            c23.a(Log.getStackTraceString(new Throwable(e23Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull e23 e23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, e23Var) == null) {
            String str = e23Var.e;
            String str2 = e23Var.f;
            if (a) {
                c23.b("apply dep path, name = " + e23Var.a + "; inline = " + e23Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                c23.b(Log.getStackTraceString(new Throwable(e23Var.a + " path is empty")));
                return;
            }
            kj3.f(jSONObject, e23Var.a, str);
            if (!TextUtils.isEmpty(e23Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    kj3.f(jSONObject2, e23Var.a, kj3.d(nm4.E(file)));
                }
            }
        }
    }
}
