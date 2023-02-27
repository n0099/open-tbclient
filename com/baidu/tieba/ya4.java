package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.ju2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes7.dex */
public class ya4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends s53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa4 c;

        public a(xa4 xa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xa4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s53, com.baidu.tieba.t53, com.baidu.tieba.r53
        public void onEvent(@NonNull p53 p53Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p53Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (p53Var.a() != null) {
                    i = p53Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (ya4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                xa4 xa4Var = this.c;
                xa4Var.m = i;
                fg3.x("976", xa4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948323421, "Lcom/baidu/tieba/ya4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948323421, "Lcom/baidu/tieba/ya4;");
                return;
            }
        }
        a = wp1.a;
    }

    public static void b(xa4 xa4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, xa4Var) != null) || xa4Var == null) {
            return;
        }
        h63.Q().X(null, a13.class, new a(xa4Var));
    }

    public static void c(an1 an1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, an1Var) != null) || an1Var == null || (a2 = an1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(w54.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= w54.a()) {
            return;
        }
        xa4 xa4Var = new xa4();
        xa4Var.b = "stuck";
        xa4Var.e = "jserror";
        xa4Var.f = m93.g0();
        if (m93.M() != null && m93.M().Y() != null) {
            ju2.a Y = m93.M().Y();
            xa4Var.c = Y.T();
            xa4Var.a = fg3.n(Y.G());
        }
        xa4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (ja4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        xa4Var.k = i;
        xa4Var.n = w54.b();
        xa4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(xa4Var);
    }
}
