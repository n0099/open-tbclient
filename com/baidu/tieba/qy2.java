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
public class qy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948108095, "Lcom/baidu/tieba/qy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948108095, "Lcom/baidu/tieba/qy2;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<fz2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ae2.k()) {
                boolean z = false;
                for (fz2 fz2Var : e) {
                    String h = ae2.h(fz2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        fz2Var.e = h;
                        c(jSONObject, jSONObject2, fz2Var);
                        z = true;
                        l02.i("Module-Plugin", "use debug dependencies，name=" + fz2Var.a + " path=" + fz2Var.e);
                    } else {
                        l02.o("Module-Plugin", "debug dependencies not exist，name=" + fz2Var.a + " path=" + fz2Var.e);
                    }
                }
                if (!z) {
                    d33.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    l02.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            jz2.c("dependenciesPath", jSONObject3);
            jz2.c("dependenciesConfig", jSONObject4);
            return;
        }
        jz2.c("dependenciesPath", null);
        jz2.c("dependenciesConfig", null);
        if (a) {
            dz2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<fz2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (fz2 fz2Var : list) {
            if (fz2Var != null) {
                if (fz2Var.g) {
                    c(jSONObject, jSONObject2, fz2Var);
                } else {
                    mc4 q = ib4.i().q(fz2Var.a, fz2Var.h, fz2Var.i);
                    if (q == null) {
                        dz2.a(Log.getStackTraceString(new Throwable(fz2Var.a + " query db fail")));
                    } else {
                        File t = hm2.t(fz2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            fz2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, fz2Var);
                        } else {
                            dz2.a(Log.getStackTraceString(new Throwable(fz2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull fz2 fz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, fz2Var) == null) {
            String str = fz2Var.e;
            String str2 = fz2Var.f;
            if (a) {
                dz2.b("apply dep path, name = " + fz2Var.a + "; inline = " + fz2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                dz2.b(Log.getStackTraceString(new Throwable(fz2Var.a + " path is empty")));
                return;
            }
            lg3.f(jSONObject, fz2Var.a, str);
            if (TextUtils.isEmpty(fz2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                lg3.f(jSONObject2, fz2Var.a, lg3.d(pj4.E(file)));
            }
        }
    }
}
