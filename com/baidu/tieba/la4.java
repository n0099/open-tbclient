package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.ia4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class la4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947936138, "Lcom/baidu/tieba/la4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947936138, "Lcom/baidu/tieba/la4;");
                return;
            }
        }
        a = vm1.a;
    }

    public static void a(@NonNull k63 k63Var, @NonNull ia4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, k63Var, eVar) == null) {
            long k = k63Var.X().k("launch_time", 0L);
            if (k <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            md3 md3Var = new md3();
            md3Var.a = dd3.n(k63Var.X().H());
            md3Var.f = k63Var.getAppId();
            md3Var.c = k63Var.X().U();
            md3Var.b = "startup";
            md3Var.g = eVar.a;
            md3Var.e = eVar.b;
            md3Var.a("na_start", Long.valueOf(k));
            md3Var.a("h5_start", Long.valueOf(eVar.c));
            md3Var.a("h5_finish", Long.valueOf(eVar.d));
            dd3.x("1235", md3Var);
        }
    }
}
