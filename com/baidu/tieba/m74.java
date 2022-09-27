package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.j74;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class m74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925567, "Lcom/baidu/tieba/m74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925567, "Lcom/baidu/tieba/m74;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a(@NonNull l33 l33Var, @NonNull j74.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, l33Var, eVar) == null) {
            long l = l33Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            na3 na3Var = new na3();
            na3Var.a = ea3.n(l33Var.W().G());
            na3Var.f = l33Var.getAppId();
            na3Var.c = l33Var.W().T();
            na3Var.b = "startup";
            na3Var.g = eVar.a;
            na3Var.e = eVar.b;
            na3Var.a("na_start", Long.valueOf(l));
            na3Var.a("h5_start", Long.valueOf(eVar.c));
            na3Var.a("h5_finish", Long.valueOf(eVar.d));
            ea3.x("1235", na3Var);
        }
    }
}
