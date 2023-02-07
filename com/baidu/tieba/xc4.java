package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.uc4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948295552, "Lcom/baidu/tieba/xc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948295552, "Lcom/baidu/tieba/xc4;");
                return;
            }
        }
        a = gp1.a;
    }

    public static void a(@NonNull w83 w83Var, @NonNull uc4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, w83Var, eVar) == null) {
            long l = w83Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            yf3 yf3Var = new yf3();
            yf3Var.a = pf3.n(w83Var.W().G());
            yf3Var.f = w83Var.getAppId();
            yf3Var.c = w83Var.W().T();
            yf3Var.b = "startup";
            yf3Var.g = eVar.a;
            yf3Var.e = eVar.b;
            yf3Var.a("na_start", Long.valueOf(l));
            yf3Var.a("h5_start", Long.valueOf(eVar.c));
            yf3Var.a("h5_finish", Long.valueOf(eVar.d));
            pf3.x("1235", yf3Var);
        }
    }
}
