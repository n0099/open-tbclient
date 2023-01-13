package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.h84;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class k84 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947866946, "Lcom/baidu/tieba/k84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947866946, "Lcom/baidu/tieba/k84;");
                return;
            }
        }
        a = tk1.a;
    }

    public static void a(@NonNull j43 j43Var, @NonNull h84.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, j43Var, eVar) == null) {
            long l = j43Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            lb3 lb3Var = new lb3();
            lb3Var.a = cb3.n(j43Var.W().G());
            lb3Var.f = j43Var.getAppId();
            lb3Var.c = j43Var.W().T();
            lb3Var.b = "startup";
            lb3Var.g = eVar.a;
            lb3Var.e = eVar.b;
            lb3Var.a("na_start", Long.valueOf(l));
            lb3Var.a("h5_start", Long.valueOf(eVar.c));
            lb3Var.a("h5_finish", Long.valueOf(eVar.d));
            cb3.x("1235", lb3Var);
        }
    }
}
