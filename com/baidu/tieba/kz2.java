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
public class kz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947930310, "Lcom/baidu/tieba/kz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947930310, "Lcom/baidu/tieba/kz2;");
                return;
            }
        }
        a = pk1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<zz2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ue2.k()) {
                boolean z = false;
                for (zz2 zz2Var : e) {
                    String h = ue2.h(zz2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        zz2Var.e = h;
                        c(jSONObject, jSONObject2, zz2Var);
                        z = true;
                        f12.i("Module-Plugin", "use debug dependencies，name=" + zz2Var.a + " path=" + zz2Var.e);
                    } else {
                        f12.o("Module-Plugin", "debug dependencies not exist，name=" + zz2Var.a + " path=" + zz2Var.e);
                    }
                }
                if (!z) {
                    x33.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    f12.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            d03.c("dependenciesPath", jSONObject3);
            d03.c("dependenciesConfig", jSONObject4);
            return;
        }
        d03.c("dependenciesPath", null);
        d03.c("dependenciesConfig", null);
        if (a) {
            xz2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<zz2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (zz2 zz2Var : list) {
            if (zz2Var != null) {
                if (zz2Var.g) {
                    c(jSONObject, jSONObject2, zz2Var);
                } else {
                    gd4 q = cc4.i().q(zz2Var.a, zz2Var.h, zz2Var.i);
                    if (q == null) {
                        xz2.a(Log.getStackTraceString(new Throwable(zz2Var.a + " query db fail")));
                    } else {
                        File t = bn2.t(zz2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            zz2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, zz2Var);
                        } else {
                            xz2.a(Log.getStackTraceString(new Throwable(zz2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull zz2 zz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, zz2Var) == null) {
            String str = zz2Var.e;
            String str2 = zz2Var.f;
            if (a) {
                xz2.b("apply dep path, name = " + zz2Var.a + "; inline = " + zz2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                xz2.b(Log.getStackTraceString(new Throwable(zz2Var.a + " path is empty")));
                return;
            }
            fh3.f(jSONObject, zz2Var.a, str);
            if (!TextUtils.isEmpty(zz2Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    fh3.f(jSONObject2, zz2Var.a, fh3.d(jk4.E(file)));
                }
            }
        }
    }
}
