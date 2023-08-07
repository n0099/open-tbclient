package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.we4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ze4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948357056, "Lcom/baidu/tieba/ze4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948357056, "Lcom/baidu/tieba/ze4;");
                return;
            }
        }
        a = ir1.a;
    }

    public static void a(@NonNull ya3 ya3Var, @NonNull we4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ya3Var, eVar) == null) {
            long l = ya3Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            ai3 ai3Var = new ai3();
            ai3Var.a = rh3.n(ya3Var.W().G());
            ai3Var.f = ya3Var.getAppId();
            ai3Var.c = ya3Var.W().T();
            ai3Var.b = "startup";
            ai3Var.g = eVar.a;
            ai3Var.e = eVar.b;
            ai3Var.a("na_start", Long.valueOf(l));
            ai3Var.a("h5_start", Long.valueOf(eVar.c));
            ai3Var.a("h5_finish", Long.valueOf(eVar.d));
            rh3.x("1235", ai3Var);
        }
    }
}
