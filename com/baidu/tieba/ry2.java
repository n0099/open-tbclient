package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ry2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948137886, "Lcom/baidu/tieba/ry2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948137886, "Lcom/baidu/tieba/ry2;");
                return;
            }
        }
        a = wj1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<gz2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (be2.k()) {
                boolean z = false;
                for (gz2 gz2Var : e) {
                    String h = be2.h(gz2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        gz2Var.e = h;
                        c(jSONObject, jSONObject2, gz2Var);
                        z = true;
                        m02.i("Module-Plugin", "use debug dependencies，name=" + gz2Var.a + " path=" + gz2Var.e);
                    } else {
                        m02.o("Module-Plugin", "debug dependencies not exist，name=" + gz2Var.a + " path=" + gz2Var.e);
                    }
                }
                if (!z) {
                    e33.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    m02.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            kz2.c("dependenciesPath", jSONObject3);
            kz2.c("dependenciesConfig", jSONObject4);
            return;
        }
        kz2.c("dependenciesPath", null);
        kz2.c("dependenciesConfig", null);
        if (a) {
            ez2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(List list, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            gz2 gz2Var = (gz2) it.next();
            if (gz2Var != null) {
                if (gz2Var.g) {
                    c(jSONObject, jSONObject2, gz2Var);
                } else {
                    nc4 q = jb4.i().q(gz2Var.a, gz2Var.h, gz2Var.i);
                    if (q == null) {
                        ez2.a(Log.getStackTraceString(new Throwable(gz2Var.a + " query db fail")));
                    } else {
                        File t = im2.t(gz2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            gz2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, gz2Var);
                        } else {
                            ez2.a(Log.getStackTraceString(new Throwable(gz2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(JSONObject jSONObject, JSONObject jSONObject2, gz2 gz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, gz2Var) == null) {
            String str = gz2Var.e;
            String str2 = gz2Var.f;
            if (a) {
                ez2.b("apply dep path, name = " + gz2Var.a + "; inline = " + gz2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                ez2.b(Log.getStackTraceString(new Throwable(gz2Var.a + " path is empty")));
                return;
            }
            mg3.f(jSONObject, gz2Var.a, str);
            if (!TextUtils.isEmpty(gz2Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    mg3.f(jSONObject2, gz2Var.a, mg3.d(qj4.E(file)));
                }
            }
        }
    }
}
