package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.kd4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947998603, "Lcom/baidu/tieba/nd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947998603, "Lcom/baidu/tieba/nd4;");
                return;
            }
        }
        a = wp1.a;
    }

    public static void a(@NonNull m93 m93Var, @NonNull kd4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, m93Var, eVar) == null) {
            long l = m93Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            og3 og3Var = new og3();
            og3Var.a = fg3.n(m93Var.W().G());
            og3Var.f = m93Var.getAppId();
            og3Var.c = m93Var.W().T();
            og3Var.b = "startup";
            og3Var.g = eVar.a;
            og3Var.e = eVar.b;
            og3Var.a("na_start", Long.valueOf(l));
            og3Var.a("h5_start", Long.valueOf(eVar.c));
            og3Var.a("h5_finish", Long.valueOf(eVar.d));
            fg3.x("1235", og3Var);
        }
    }
}
