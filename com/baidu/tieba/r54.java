package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes5.dex */
public class r54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends l03 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q54 c;

        public a(q54 q54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q54Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l03, com.baidu.tieba.m03, com.baidu.tieba.k03
        public void onEvent(@NonNull i03 i03Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i03Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (i03Var.a() != null) {
                    i = i03Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (r54.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                q54 q54Var = this.c;
                q54Var.m = i;
                ya3.x("976", q54Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948072600, "Lcom/baidu/tieba/r54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948072600, "Lcom/baidu/tieba/r54;");
                return;
            }
        }
        a = pk1.a;
    }

    public static void b(q54 q54Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, q54Var) != null) || q54Var == null) {
            return;
        }
        a13.Q().X(null, tv2.class, new a(q54Var));
    }

    public static void c(yh1 yh1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, yh1Var) != null) || yh1Var == null || (a2 = yh1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(p04.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= p04.a()) {
            return;
        }
        q54 q54Var = new q54();
        q54Var.b = "stuck";
        q54Var.e = "jserror";
        q54Var.f = f43.g0();
        if (f43.M() != null && f43.M().Y() != null) {
            cp2.a Y = f43.M().Y();
            q54Var.c = Y.T();
            q54Var.a = ya3.n(Y.G());
        }
        q54Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (c54.d()) {
            i = 20;
        } else {
            i = 10;
        }
        q54Var.k = i;
        q54Var.n = p04.b();
        q54Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(q54Var);
    }
}
