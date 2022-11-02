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
/* loaded from: classes4.dex */
public class jz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947900519, "Lcom/baidu/tieba/jz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947900519, "Lcom/baidu/tieba/jz2;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<yz2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (te2.k()) {
                boolean z = false;
                for (yz2 yz2Var : e) {
                    String h = te2.h(yz2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        yz2Var.e = h;
                        c(jSONObject, jSONObject2, yz2Var);
                        z = true;
                        e12.i("Module-Plugin", "use debug dependencies，name=" + yz2Var.a + " path=" + yz2Var.e);
                    } else {
                        e12.o("Module-Plugin", "debug dependencies not exist，name=" + yz2Var.a + " path=" + yz2Var.e);
                    }
                }
                if (!z) {
                    w33.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    e12.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            c03.c("dependenciesPath", jSONObject3);
            c03.c("dependenciesConfig", jSONObject4);
            return;
        }
        c03.c("dependenciesPath", null);
        c03.c("dependenciesConfig", null);
        if (a) {
            wz2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<yz2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (yz2 yz2Var : list) {
            if (yz2Var != null) {
                if (yz2Var.g) {
                    c(jSONObject, jSONObject2, yz2Var);
                } else {
                    fd4 q = bc4.i().q(yz2Var.a, yz2Var.h, yz2Var.i);
                    if (q == null) {
                        wz2.a(Log.getStackTraceString(new Throwable(yz2Var.a + " query db fail")));
                    } else {
                        File t = an2.t(yz2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            yz2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, yz2Var);
                        } else {
                            wz2.a(Log.getStackTraceString(new Throwable(yz2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull yz2 yz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, yz2Var) == null) {
            String str = yz2Var.e;
            String str2 = yz2Var.f;
            if (a) {
                wz2.b("apply dep path, name = " + yz2Var.a + "; inline = " + yz2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                wz2.b(Log.getStackTraceString(new Throwable(yz2Var.a + " path is empty")));
                return;
            }
            eh3.f(jSONObject, yz2Var.a, str);
            if (!TextUtils.isEmpty(yz2Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    eh3.f(jSONObject2, yz2Var.a, eh3.d(ik4.E(file)));
                }
            }
        }
    }
}
