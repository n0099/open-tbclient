package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes6.dex */
public class y44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a extends sz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x44 c;

        public a(x44 x44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x44Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sz2, com.baidu.tieba.tz2, com.baidu.tieba.rz2
        public void onEvent(pz2 pz2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pz2Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (pz2Var.a() != null) {
                    i = ((Bundle) pz2Var.a()).getInt("net_quality");
                } else {
                    i = -1;
                }
                if (y44.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                x44 x44Var = this.c;
                x44Var.m = i;
                fa3.x("976", x44Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948280176, "Lcom/baidu/tieba/y44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948280176, "Lcom/baidu/tieba/y44;");
                return;
            }
        }
        a = wj1.a;
    }

    public static void b(x44 x44Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, x44Var) != null) || x44Var == null) {
            return;
        }
        h03.Q().X(null, av2.class, new a(x44Var));
    }

    public static void c(fh1 fh1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, fh1Var) != null) || fh1Var == null || (a2 = fh1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(wz3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= wz3.a()) {
            return;
        }
        x44 x44Var = new x44();
        x44Var.b = "stuck";
        x44Var.e = "jserror";
        x44Var.f = m33.g0();
        if (m33.M() != null && m33.M().Y() != null) {
            jo2.a Y = m33.M().Y();
            x44Var.c = Y.T();
            x44Var.a = fa3.n(Y.G());
        }
        x44Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (j44.d()) {
            i = 20;
        } else {
            i = 10;
        }
        x44Var.k = i;
        x44Var.n = wz3.b();
        x44Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(x44Var);
    }
}
