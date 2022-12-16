package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.bp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends k03 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p54 c;

        public a(p54 p54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p54Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k03, com.baidu.tieba.l03, com.baidu.tieba.j03
        public void onEvent(@NonNull h03 h03Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h03Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (h03Var.a() != null) {
                    i = h03Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (q54.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                p54 p54Var = this.c;
                p54Var.m = i;
                xa3.x("976", p54Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948042809, "Lcom/baidu/tieba/q54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948042809, "Lcom/baidu/tieba/q54;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void b(p54 p54Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, p54Var) != null) || p54Var == null) {
            return;
        }
        z03.Q().X(null, sv2.class, new a(p54Var));
    }

    public static void c(xh1 xh1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, xh1Var) != null) || xh1Var == null || (a2 = xh1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(o04.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= o04.a()) {
            return;
        }
        p54 p54Var = new p54();
        p54Var.b = "stuck";
        p54Var.e = "jserror";
        p54Var.f = e43.g0();
        if (e43.M() != null && e43.M().Y() != null) {
            bp2.a Y = e43.M().Y();
            p54Var.c = Y.T();
            p54Var.a = xa3.n(Y.G());
        }
        p54Var.l = str + ";" + str2;
        if (b54.d()) {
            i = 20;
        } else {
            i = 10;
        }
        p54Var.k = i;
        p54Var.n = o04.b();
        p54Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(p54Var);
    }
}
