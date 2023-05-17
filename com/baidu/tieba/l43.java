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
public class l43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947892862, "Lcom/baidu/tieba/l43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947892862, "Lcom/baidu/tieba/l43;");
                return;
            }
        }
        a = qp1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<a53> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (vj2.k()) {
                boolean z = false;
                for (a53 a53Var : e) {
                    String h = vj2.h(a53Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        a53Var.e = h;
                        c(jSONObject, jSONObject2, a53Var);
                        z = true;
                        g62.i("Module-Plugin", "use debug dependencies，name=" + a53Var.a + " path=" + a53Var.e);
                    } else {
                        g62.o("Module-Plugin", "debug dependencies not exist，name=" + a53Var.a + " path=" + a53Var.e);
                    }
                }
                if (!z) {
                    y83.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    g62.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            e53.c("dependenciesPath", jSONObject3);
            e53.c("dependenciesConfig", jSONObject4);
            return;
        }
        e53.c("dependenciesPath", null);
        e53.c("dependenciesConfig", null);
        if (a) {
            y43.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<a53> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (a53 a53Var : list) {
            if (a53Var != null) {
                if (a53Var.g) {
                    c(jSONObject, jSONObject2, a53Var);
                } else {
                    hi4 q = dh4.i().q(a53Var.a, a53Var.h, a53Var.i);
                    if (q == null) {
                        y43.a(Log.getStackTraceString(new Throwable(a53Var.a + " query db fail")));
                    } else {
                        File t = cs2.t(a53Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            a53Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, a53Var);
                        } else {
                            y43.a(Log.getStackTraceString(new Throwable(a53Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull a53 a53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, a53Var) == null) {
            String str = a53Var.e;
            String str2 = a53Var.f;
            if (a) {
                y43.b("apply dep path, name = " + a53Var.a + "; inline = " + a53Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                y43.b(Log.getStackTraceString(new Throwable(a53Var.a + " path is empty")));
                return;
            }
            gm3.f(jSONObject, a53Var.a, str);
            if (!TextUtils.isEmpty(a53Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    gm3.f(jSONObject2, a53Var.a, gm3.d(kp4.E(file)));
                }
            }
        }
    }
}
