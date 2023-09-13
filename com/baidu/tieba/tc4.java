package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes8.dex */
public class tc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends n73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sc4 c;

        public a(sc4 sc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sc4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n73, com.baidu.tieba.o73, com.baidu.tieba.m73
        public void onEvent(@NonNull k73 k73Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k73Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (k73Var.a() != null) {
                    i = k73Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (tc4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                sc4 sc4Var = this.c;
                sc4Var.m = i;
                ai3.x("976", sc4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948176388, "Lcom/baidu/tieba/tc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948176388, "Lcom/baidu/tieba/tc4;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void b(sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, sc4Var) != null) || sc4Var == null) {
            return;
        }
        c83.Q().X(null, v23.class, new a(sc4Var));
    }

    public static void c(qo1 qo1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, qo1Var) != null) || qo1Var == null || (a2 = qo1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(r74.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= r74.a()) {
            return;
        }
        sc4 sc4Var = new sc4();
        sc4Var.b = "stuck";
        sc4Var.e = "jserror";
        sc4Var.f = hb3.g0();
        if (hb3.M() != null && hb3.M().Y() != null) {
            ew2.a Y = hb3.M().Y();
            sc4Var.c = Y.T();
            sc4Var.a = ai3.n(Y.G());
        }
        sc4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (ec4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        sc4Var.k = i;
        sc4Var.n = r74.b();
        sc4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(sc4Var);
    }
}
