package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.sb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948235009, "Lcom/baidu/tieba/vb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948235009, "Lcom/baidu/tieba/vb4;");
                return;
            }
        }
        a = eo1.a;
    }

    public static void a(@NonNull u73 u73Var, @NonNull sb4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, u73Var, eVar) == null) {
            long l = u73Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            we3 we3Var = new we3();
            we3Var.a = ne3.n(u73Var.W().G());
            we3Var.f = u73Var.getAppId();
            we3Var.c = u73Var.W().T();
            we3Var.b = "startup";
            we3Var.g = eVar.a;
            we3Var.e = eVar.b;
            we3Var.a("na_start", Long.valueOf(l));
            we3Var.a("h5_start", Long.valueOf(eVar.c));
            we3Var.a("h5_finish", Long.valueOf(eVar.d));
            ne3.x("1235", we3Var);
        }
    }
}
