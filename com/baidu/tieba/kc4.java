package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.vv2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes6.dex */
public class kc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends e73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc4 c;

        public a(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jc4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e73, com.baidu.tieba.f73, com.baidu.tieba.d73
        public void onEvent(@NonNull b73 b73Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b73Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (b73Var.a() != null) {
                    i = b73Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (kc4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                jc4 jc4Var = this.c;
                jc4Var.m = i;
                rh3.x("976", jc4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947908269, "Lcom/baidu/tieba/kc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947908269, "Lcom/baidu/tieba/kc4;");
                return;
            }
        }
        a = ir1.a;
    }

    public static void b(jc4 jc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, jc4Var) != null) || jc4Var == null) {
            return;
        }
        t73.Q().X(null, m23.class, new a(jc4Var));
    }

    public static void c(ho1 ho1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, ho1Var) != null) || ho1Var == null || (a2 = ho1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(i74.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= i74.a()) {
            return;
        }
        jc4 jc4Var = new jc4();
        jc4Var.b = "stuck";
        jc4Var.e = "jserror";
        jc4Var.f = ya3.g0();
        if (ya3.M() != null && ya3.M().Y() != null) {
            vv2.a Y = ya3.M().Y();
            jc4Var.c = Y.T();
            jc4Var.a = rh3.n(Y.G());
        }
        jc4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (vb4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        jc4Var.k = i;
        jc4Var.n = i74.b();
        jc4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(jc4Var);
    }
}
