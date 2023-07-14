package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.tf4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wf4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948268644, "Lcom/baidu/tieba/wf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948268644, "Lcom/baidu/tieba/wf4;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void a(@NonNull vb3 vb3Var, @NonNull tf4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, vb3Var, eVar) == null) {
            long l = vb3Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            xi3 xi3Var = new xi3();
            xi3Var.a = oi3.n(vb3Var.W().G());
            xi3Var.f = vb3Var.getAppId();
            xi3Var.c = vb3Var.W().T();
            xi3Var.b = "startup";
            xi3Var.g = eVar.a;
            xi3Var.e = eVar.b;
            xi3Var.a("na_start", Long.valueOf(l));
            xi3Var.a("h5_start", Long.valueOf(eVar.c));
            xi3Var.a("h5_finish", Long.valueOf(eVar.d));
            oi3.x("1235", xi3Var);
        }
    }
}
