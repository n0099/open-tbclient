package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.w64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311889, "Lcom/baidu/tieba/z64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311889, "Lcom/baidu/tieba/z64;");
                return;
            }
        }
        a = ij1.a;
    }

    public static void a(@NonNull y23 y23Var, @NonNull w64.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, y23Var, eVar) == null) {
            long l = y23Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            aa3 aa3Var = new aa3();
            aa3Var.a = r93.n(y23Var.W().G());
            aa3Var.f = y23Var.getAppId();
            aa3Var.c = y23Var.W().T();
            aa3Var.b = "startup";
            aa3Var.g = eVar.a;
            aa3Var.e = eVar.b;
            aa3Var.a("na_start", Long.valueOf(l));
            aa3Var.a("h5_start", Long.valueOf(eVar.c));
            aa3Var.a("h5_finish", Long.valueOf(eVar.d));
            r93.x("1235", aa3Var);
        }
    }
}
