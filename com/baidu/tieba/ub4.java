package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tieba.rb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ub4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948205218, "Lcom/baidu/tieba/ub4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948205218, "Lcom/baidu/tieba/ub4;");
                return;
            }
        }
        a = do1.a;
    }

    public static void a(@NonNull t73 t73Var, @NonNull rb4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, t73Var, eVar) == null) {
            long l = t73Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            ve3 ve3Var = new ve3();
            ve3Var.a = me3.n(t73Var.W().G());
            ve3Var.f = t73Var.getAppId();
            ve3Var.c = t73Var.W().T();
            ve3Var.b = "startup";
            ve3Var.g = eVar.a;
            ve3Var.e = eVar.b;
            ve3Var.a("na_start", Long.valueOf(l));
            ve3Var.a("h5_start", Long.valueOf(eVar.c));
            ve3Var.a("h5_finish", Long.valueOf(eVar.d));
            me3.x("1235", ve3Var);
        }
    }
}
