package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes6.dex */
public class ld4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends f83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kd4 c;

        public a(kd4 kd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kd4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f83, com.baidu.tieba.g83, com.baidu.tieba.e83
        public void onEvent(@NonNull c83 c83Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c83Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (c83Var.a() != null) {
                    i = c83Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (ld4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                kd4 kd4Var = this.c;
                kd4Var.m = i;
                si3.x("976", kd4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947939021, "Lcom/baidu/tieba/ld4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947939021, "Lcom/baidu/tieba/ld4;");
                return;
            }
        }
        a = js1.a;
    }

    public static void b(kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, kd4Var) != null) || kd4Var == null) {
            return;
        }
        u83.Q().X(null, n33.class, new a(kd4Var));
    }

    public static void c(ip1 ip1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, ip1Var) != null) || ip1Var == null || (a2 = ip1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(j84.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= j84.a()) {
            return;
        }
        kd4 kd4Var = new kd4();
        kd4Var.b = "stuck";
        kd4Var.e = "jserror";
        kd4Var.f = zb3.g0();
        if (zb3.M() != null && zb3.M().Y() != null) {
            ww2.a Y = zb3.M().Y();
            kd4Var.c = Y.T();
            kd4Var.a = si3.n(Y.G());
        }
        kd4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (wc4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        kd4Var.k = i;
        kd4Var.n = j84.b();
        kd4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(kd4Var);
    }
}
