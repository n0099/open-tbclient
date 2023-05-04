package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.vb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948324382, "Lcom/baidu/tieba/yb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948324382, "Lcom/baidu/tieba/yb4;");
                return;
            }
        }
        a = ho1.a;
    }

    public static void a(@NonNull x73 x73Var, @NonNull vb4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, x73Var, eVar) == null) {
            long l = x73Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            ze3 ze3Var = new ze3();
            ze3Var.a = qe3.n(x73Var.W().G());
            ze3Var.f = x73Var.getAppId();
            ze3Var.c = x73Var.W().T();
            ze3Var.b = "startup";
            ze3Var.g = eVar.a;
            ze3Var.e = eVar.b;
            ze3Var.a("na_start", Long.valueOf(l));
            ze3Var.a("h5_start", Long.valueOf(eVar.c));
            ze3Var.a("h5_finish", Long.valueOf(eVar.d));
            qe3.x("1235", ze3Var);
        }
    }
}
