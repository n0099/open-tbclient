package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.tb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948264800, "Lcom/baidu/tieba/wb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948264800, "Lcom/baidu/tieba/wb4;");
                return;
            }
        }
        a = fo1.a;
    }

    public static void a(@NonNull v73 v73Var, @NonNull tb4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, v73Var, eVar) == null) {
            long l = v73Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            xe3 xe3Var = new xe3();
            xe3Var.a = oe3.n(v73Var.W().G());
            xe3Var.f = v73Var.getAppId();
            xe3Var.c = v73Var.W().T();
            xe3Var.b = "startup";
            xe3Var.g = eVar.a;
            xe3Var.e = eVar.b;
            xe3Var.a("na_start", Long.valueOf(l));
            xe3Var.a("h5_start", Long.valueOf(eVar.c));
            xe3Var.a("h5_finish", Long.valueOf(eVar.d));
            oe3.x("1235", xe3Var);
        }
    }
}
