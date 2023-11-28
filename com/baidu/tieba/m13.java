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
public class m13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947919770, "Lcom/baidu/tieba/m13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947919770, "Lcom/baidu/tieba/m13;");
                return;
            }
        }
        a = sm1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<b23> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (wg2.k()) {
                boolean z = false;
                for (b23 b23Var : e) {
                    String h = wg2.h(b23Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        b23Var.e = h;
                        c(jSONObject, jSONObject2, b23Var);
                        z = true;
                        h32.i("Module-Plugin", "use debug dependencies，name=" + b23Var.a + " path=" + b23Var.e);
                    } else {
                        h32.o("Module-Plugin", "debug dependencies not exist，name=" + b23Var.a + " path=" + b23Var.e);
                    }
                }
                if (!z) {
                    z53.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    h32.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            f23.c("dependenciesPath", jSONObject3);
            f23.c("dependenciesConfig", jSONObject4);
            return;
        }
        f23.c("dependenciesPath", null);
        f23.c("dependenciesConfig", null);
        if (a) {
            z13.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<b23> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (b23 b23Var : list) {
            if (b23Var != null) {
                if (b23Var.g) {
                    c(jSONObject, jSONObject2, b23Var);
                } else {
                    if4 q = ee4.i().q(b23Var.a, b23Var.h, b23Var.i);
                    if (q == null) {
                        z13.a(Log.getStackTraceString(new Throwable(b23Var.a + " query db fail")));
                    } else {
                        File t = dp2.t(b23Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            b23Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, b23Var);
                        } else {
                            z13.a(Log.getStackTraceString(new Throwable(b23Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull b23 b23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, b23Var) == null) {
            String str = b23Var.e;
            String str2 = b23Var.f;
            if (a) {
                z13.b("apply dep path, name = " + b23Var.a + "; inline = " + b23Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                z13.b(Log.getStackTraceString(new Throwable(b23Var.a + " path is empty")));
                return;
            }
            hj3.f(jSONObject, b23Var.a, str);
            if (!TextUtils.isEmpty(b23Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    hj3.f(jSONObject2, b23Var.a, hj3.d(km4.E(file)));
                }
            }
        }
    }
}
