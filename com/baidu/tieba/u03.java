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
/* loaded from: classes8.dex */
public class u03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948157137, "Lcom/baidu/tieba/u03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948157137, "Lcom/baidu/tieba/u03;");
                return;
            }
        }
        a = am1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<j13> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (eg2.k()) {
                boolean z = false;
                for (j13 j13Var : e) {
                    String h = eg2.h(j13Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        j13Var.e = h;
                        c(jSONObject, jSONObject2, j13Var);
                        z = true;
                        p22.i("Module-Plugin", "use debug dependencies，name=" + j13Var.a + " path=" + j13Var.e);
                    } else {
                        p22.o("Module-Plugin", "debug dependencies not exist，name=" + j13Var.a + " path=" + j13Var.e);
                    }
                }
                if (!z) {
                    h53.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    p22.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            n13.c("dependenciesPath", jSONObject3);
            n13.c("dependenciesConfig", jSONObject4);
            return;
        }
        n13.c("dependenciesPath", null);
        n13.c("dependenciesConfig", null);
        if (a) {
            h13.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<j13> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (j13 j13Var : list) {
            if (j13Var != null) {
                if (j13Var.g) {
                    c(jSONObject, jSONObject2, j13Var);
                } else {
                    qe4 q = md4.i().q(j13Var.a, j13Var.h, j13Var.i);
                    if (q == null) {
                        h13.a(Log.getStackTraceString(new Throwable(j13Var.a + " query db fail")));
                    } else {
                        File t = lo2.t(j13Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            j13Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, j13Var);
                        } else {
                            h13.a(Log.getStackTraceString(new Throwable(j13Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull j13 j13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, j13Var) == null) {
            String str = j13Var.e;
            String str2 = j13Var.f;
            if (a) {
                h13.b("apply dep path, name = " + j13Var.a + "; inline = " + j13Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                h13.b(Log.getStackTraceString(new Throwable(j13Var.a + " path is empty")));
                return;
            }
            pi3.f(jSONObject, j13Var.a, str);
            if (!TextUtils.isEmpty(j13Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    pi3.f(jSONObject2, j13Var.a, pi3.d(sl4.E(file)));
                }
            }
        }
    }
}
