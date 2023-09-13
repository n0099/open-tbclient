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
public class m63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924575, "Lcom/baidu/tieba/m63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924575, "Lcom/baidu/tieba/m63;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<b73> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (wl2.k()) {
                boolean z = false;
                for (b73 b73Var : e) {
                    String h = wl2.h(b73Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        b73Var.e = h;
                        c(jSONObject, jSONObject2, b73Var);
                        z = true;
                        h82.i("Module-Plugin", "use debug dependencies，name=" + b73Var.a + " path=" + b73Var.e);
                    } else {
                        h82.o("Module-Plugin", "debug dependencies not exist，name=" + b73Var.a + " path=" + b73Var.e);
                    }
                }
                if (!z) {
                    za3.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    h82.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            f73.c("dependenciesPath", jSONObject3);
            f73.c("dependenciesConfig", jSONObject4);
            return;
        }
        f73.c("dependenciesPath", null);
        f73.c("dependenciesConfig", null);
        if (a) {
            z63.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<b73> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (b73 b73Var : list) {
            if (b73Var != null) {
                if (b73Var.g) {
                    c(jSONObject, jSONObject2, b73Var);
                } else {
                    ik4 q = ej4.i().q(b73Var.a, b73Var.h, b73Var.i);
                    if (q == null) {
                        z63.a(Log.getStackTraceString(new Throwable(b73Var.a + " query db fail")));
                    } else {
                        File t = du2.t(b73Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            b73Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, b73Var);
                        } else {
                            z63.a(Log.getStackTraceString(new Throwable(b73Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull b73 b73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, b73Var) == null) {
            String str = b73Var.e;
            String str2 = b73Var.f;
            if (a) {
                z63.b("apply dep path, name = " + b73Var.a + "; inline = " + b73Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                z63.b(Log.getStackTraceString(new Throwable(b73Var.a + " path is empty")));
                return;
            }
            ho3.f(jSONObject, b73Var.a, str);
            if (!TextUtils.isEmpty(b73Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    ho3.f(jSONObject2, b73Var.a, ho3.d(lr4.E(file)));
                }
            }
        }
    }
}
