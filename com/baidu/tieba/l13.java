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
public class l13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947889979, "Lcom/baidu/tieba/l13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947889979, "Lcom/baidu/tieba/l13;");
                return;
            }
        }
        a = rm1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<a23> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (vg2.k()) {
                boolean z = false;
                for (a23 a23Var : e) {
                    String h = vg2.h(a23Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        a23Var.e = h;
                        c(jSONObject, jSONObject2, a23Var);
                        z = true;
                        g32.i("Module-Plugin", "use debug dependencies，name=" + a23Var.a + " path=" + a23Var.e);
                    } else {
                        g32.o("Module-Plugin", "debug dependencies not exist，name=" + a23Var.a + " path=" + a23Var.e);
                    }
                }
                if (!z) {
                    y53.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    g32.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            e23.c("dependenciesPath", jSONObject3);
            e23.c("dependenciesConfig", jSONObject4);
            return;
        }
        e23.c("dependenciesPath", null);
        e23.c("dependenciesConfig", null);
        if (a) {
            y13.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<a23> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (a23 a23Var : list) {
            if (a23Var != null) {
                if (a23Var.g) {
                    c(jSONObject, jSONObject2, a23Var);
                } else {
                    hf4 q = de4.i().q(a23Var.a, a23Var.h, a23Var.i);
                    if (q == null) {
                        y13.a(Log.getStackTraceString(new Throwable(a23Var.a + " query db fail")));
                    } else {
                        File t = cp2.t(a23Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            a23Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, a23Var);
                        } else {
                            y13.a(Log.getStackTraceString(new Throwable(a23Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull a23 a23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, a23Var) == null) {
            String str = a23Var.e;
            String str2 = a23Var.f;
            if (a) {
                y13.b("apply dep path, name = " + a23Var.a + "; inline = " + a23Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                y13.b(Log.getStackTraceString(new Throwable(a23Var.a + " path is empty")));
                return;
            }
            gj3.f(jSONObject, a23Var.a, str);
            if (!TextUtils.isEmpty(a23Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    gj3.f(jSONObject2, a23Var.a, gj3.d(jm4.E(file)));
                }
            }
        }
    }
}
