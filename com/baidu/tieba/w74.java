package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes8.dex */
public class w74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends q23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v74 c;

        public a(v74 v74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v74Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q23, com.baidu.tieba.r23, com.baidu.tieba.p23
        public void onEvent(@NonNull n23 n23Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, n23Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (n23Var.a() != null) {
                    i = n23Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (w74.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                v74 v74Var = this.c;
                v74Var.m = i;
                dd3.x("976", v74Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223477, "Lcom/baidu/tieba/w74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223477, "Lcom/baidu/tieba/w74;");
                return;
            }
        }
        a = vm1.a;
    }

    public static void b(v74 v74Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, v74Var) != null) || v74Var == null) {
            return;
        }
        f33.Q().X(null, yx2.class, new a(v74Var));
    }

    public static void c(uj1 uj1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, uj1Var) != null) || uj1Var == null || (a2 = uj1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(u24.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= u24.a()) {
            return;
        }
        v74 v74Var = new v74();
        v74Var.b = "stuck";
        v74Var.e = "jserror";
        v74Var.f = k63.h0();
        if (k63.M() != null && k63.M().Z() != null) {
            hr2.a Z = k63.M().Z();
            v74Var.c = Z.U();
            v74Var.a = dd3.n(Z.H());
        }
        v74Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (h74.d()) {
            i = 20;
        } else {
            i = 10;
        }
        v74Var.k = i;
        v74Var.n = u24.b();
        v74Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(v74Var);
    }
}
