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
/* loaded from: classes5.dex */
public class oz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948049474, "Lcom/baidu/tieba/oz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948049474, "Lcom/baidu/tieba/oz2;");
                return;
            }
        }
        a = tk1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<d03> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ye2.k()) {
                boolean z = false;
                for (d03 d03Var : e) {
                    String h = ye2.h(d03Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        d03Var.e = h;
                        c(jSONObject, jSONObject2, d03Var);
                        z = true;
                        j12.i("Module-Plugin", "use debug dependencies，name=" + d03Var.a + " path=" + d03Var.e);
                    } else {
                        j12.o("Module-Plugin", "debug dependencies not exist，name=" + d03Var.a + " path=" + d03Var.e);
                    }
                }
                if (!z) {
                    b43.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    j12.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            h03.c("dependenciesPath", jSONObject3);
            h03.c("dependenciesConfig", jSONObject4);
            return;
        }
        h03.c("dependenciesPath", null);
        h03.c("dependenciesConfig", null);
        if (a) {
            b03.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<d03> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (d03 d03Var : list) {
            if (d03Var != null) {
                if (d03Var.g) {
                    c(jSONObject, jSONObject2, d03Var);
                } else {
                    kd4 q = gc4.i().q(d03Var.a, d03Var.h, d03Var.i);
                    if (q == null) {
                        b03.a(Log.getStackTraceString(new Throwable(d03Var.a + " query db fail")));
                    } else {
                        File t = fn2.t(d03Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            d03Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, d03Var);
                        } else {
                            b03.a(Log.getStackTraceString(new Throwable(d03Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull d03 d03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, d03Var) == null) {
            String str = d03Var.e;
            String str2 = d03Var.f;
            if (a) {
                b03.b("apply dep path, name = " + d03Var.a + "; inline = " + d03Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                b03.b(Log.getStackTraceString(new Throwable(d03Var.a + " path is empty")));
                return;
            }
            jh3.f(jSONObject, d03Var.a, str);
            if (!TextUtils.isEmpty(d03Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    jh3.f(jSONObject2, d03Var.a, jh3.d(nk4.E(file)));
                }
            }
        }
    }
}
