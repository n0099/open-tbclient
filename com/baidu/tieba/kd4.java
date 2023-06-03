package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.vw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes6.dex */
public class kd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends e83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd4 c;

        public a(jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jd4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e83, com.baidu.tieba.f83, com.baidu.tieba.d83
        public void onEvent(@NonNull b83 b83Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b83Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (b83Var.a() != null) {
                    i = b83Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (kd4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                jd4 jd4Var = this.c;
                jd4Var.m = i;
                ri3.x("976", jd4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947909230, "Lcom/baidu/tieba/kd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947909230, "Lcom/baidu/tieba/kd4;");
                return;
            }
        }
        a = is1.a;
    }

    public static void b(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, jd4Var) != null) || jd4Var == null) {
            return;
        }
        t83.Q().X(null, m33.class, new a(jd4Var));
    }

    public static void c(hp1 hp1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, hp1Var) != null) || hp1Var == null || (a2 = hp1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(i84.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= i84.a()) {
            return;
        }
        jd4 jd4Var = new jd4();
        jd4Var.b = "stuck";
        jd4Var.e = "jserror";
        jd4Var.f = yb3.g0();
        if (yb3.M() != null && yb3.M().Y() != null) {
            vw2.a Y = yb3.M().Y();
            jd4Var.c = Y.T();
            jd4Var.a = ri3.n(Y.G());
        }
        jd4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (vc4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        jd4Var.k = i;
        jd4Var.n = i84.b();
        jd4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(jd4Var);
    }
}
