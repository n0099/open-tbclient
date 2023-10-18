package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.n94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046653, "Lcom/baidu/tieba/q94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046653, "Lcom/baidu/tieba/q94;");
                return;
            }
        }
        a = am1.a;
    }

    public static void a(@NonNull p53 p53Var, @NonNull n94.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, p53Var, eVar) == null) {
            long l = p53Var.X().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            rc3 rc3Var = new rc3();
            rc3Var.a = ic3.n(p53Var.X().H());
            rc3Var.f = p53Var.getAppId();
            rc3Var.c = p53Var.X().U();
            rc3Var.b = "startup";
            rc3Var.g = eVar.a;
            rc3Var.e = eVar.b;
            rc3Var.a("na_start", Long.valueOf(l));
            rc3Var.a("h5_start", Long.valueOf(eVar.c));
            rc3Var.a("h5_finish", Long.valueOf(eVar.d));
            ic3.x("1235", rc3Var);
        }
    }
}
