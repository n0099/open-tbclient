package com.baidu.tieba;

import android.util.Log;
import com.baidu.tieba.k74;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955358, "Lcom/baidu/tieba/n74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955358, "Lcom/baidu/tieba/n74;");
                return;
            }
        }
        a = wj1.a;
    }

    public static void a(m33 m33Var, k74.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, m33Var, eVar) == null) {
            long l = m33Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            oa3 oa3Var = new oa3();
            oa3Var.a = fa3.n(m33Var.W().G());
            oa3Var.f = m33Var.getAppId();
            oa3Var.c = m33Var.W().T();
            oa3Var.b = "startup";
            oa3Var.g = eVar.a;
            oa3Var.e = eVar.b;
            oa3Var.a("na_start", Long.valueOf(l));
            oa3Var.a("h5_start", Long.valueOf(eVar.c));
            oa3Var.a("h5_finish", Long.valueOf(eVar.d));
            fa3.x("1235", oa3Var);
        }
    }
}
