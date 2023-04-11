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
public class z23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948308014, "Lcom/baidu/tieba/z23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948308014, "Lcom/baidu/tieba/z23;");
                return;
            }
        }
        a = eo1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<o33> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ji2.k()) {
                boolean z = false;
                for (o33 o33Var : e) {
                    String h = ji2.h(o33Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        o33Var.e = h;
                        c(jSONObject, jSONObject2, o33Var);
                        z = true;
                        u42.i("Module-Plugin", "use debug dependencies，name=" + o33Var.a + " path=" + o33Var.e);
                    } else {
                        u42.o("Module-Plugin", "debug dependencies not exist，name=" + o33Var.a + " path=" + o33Var.e);
                    }
                }
                if (!z) {
                    m73.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    u42.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            s33.c("dependenciesPath", jSONObject3);
            s33.c("dependenciesConfig", jSONObject4);
            return;
        }
        s33.c("dependenciesPath", null);
        s33.c("dependenciesConfig", null);
        if (a) {
            m33.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<o33> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (o33 o33Var : list) {
            if (o33Var != null) {
                if (o33Var.g) {
                    c(jSONObject, jSONObject2, o33Var);
                } else {
                    vg4 q = rf4.i().q(o33Var.a, o33Var.h, o33Var.i);
                    if (q == null) {
                        m33.a(Log.getStackTraceString(new Throwable(o33Var.a + " query db fail")));
                    } else {
                        File t = qq2.t(o33Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            o33Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, o33Var);
                        } else {
                            m33.a(Log.getStackTraceString(new Throwable(o33Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull o33 o33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, o33Var) == null) {
            String str = o33Var.e;
            String str2 = o33Var.f;
            if (a) {
                m33.b("apply dep path, name = " + o33Var.a + "; inline = " + o33Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                m33.b(Log.getStackTraceString(new Throwable(o33Var.a + " path is empty")));
                return;
            }
            uk3.f(jSONObject, o33Var.a, str);
            if (!TextUtils.isEmpty(o33Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    uk3.f(jSONObject2, o33Var.a, uk3.d(yn4.E(file)));
                }
            }
        }
    }
}
