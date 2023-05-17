package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes7.dex */
public class sa4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends m53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra4 c;

        public a(ra4 ra4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ra4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m53, com.baidu.tieba.n53, com.baidu.tieba.l53
        public void onEvent(@NonNull j53 j53Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j53Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (j53Var.a() != null) {
                    i = j53Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (sa4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                ra4 ra4Var = this.c;
                ra4Var.m = i;
                zf3.x("976", ra4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948144675, "Lcom/baidu/tieba/sa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948144675, "Lcom/baidu/tieba/sa4;");
                return;
            }
        }
        a = qp1.a;
    }

    public static void b(ra4 ra4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, ra4Var) != null) || ra4Var == null) {
            return;
        }
        b63.Q().X(null, u03.class, new a(ra4Var));
    }

    public static void c(pm1 pm1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, pm1Var) != null) || pm1Var == null || (a2 = pm1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(q54.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= q54.a()) {
            return;
        }
        ra4 ra4Var = new ra4();
        ra4Var.b = "stuck";
        ra4Var.e = "jserror";
        ra4Var.f = g93.g0();
        if (g93.M() != null && g93.M().Y() != null) {
            du2.a Y = g93.M().Y();
            ra4Var.c = Y.T();
            ra4Var.a = zf3.n(Y.G());
        }
        ra4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (da4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        ra4Var.k = i;
        ra4Var.n = q54.b();
        ra4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(ra4Var);
    }
}
