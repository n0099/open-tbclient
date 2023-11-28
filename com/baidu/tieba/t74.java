package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.er2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes8.dex */
public class t74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends n23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s74 c;

        public a(s74 s74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s74Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n23, com.baidu.tieba.o23, com.baidu.tieba.m23
        public void onEvent(@NonNull k23 k23Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k23Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (k23Var.a() != null) {
                    i = k23Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (t74.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                s74 s74Var = this.c;
                s74Var.m = i;
                ad3.x("976", s74Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948134104, "Lcom/baidu/tieba/t74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948134104, "Lcom/baidu/tieba/t74;");
                return;
            }
        }
        a = sm1.a;
    }

    public static void b(s74 s74Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, s74Var) != null) || s74Var == null) {
            return;
        }
        c33.Q().X(null, vx2.class, new a(s74Var));
    }

    public static void c(rj1 rj1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, rj1Var) != null) || rj1Var == null || (a2 = rj1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(r24.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= r24.a()) {
            return;
        }
        s74 s74Var = new s74();
        s74Var.b = "stuck";
        s74Var.e = "jserror";
        s74Var.f = h63.h0();
        if (h63.M() != null && h63.M().Z() != null) {
            er2.a Z = h63.M().Z();
            s74Var.c = Z.U();
            s74Var.a = ad3.n(Z.H());
        }
        s74Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (e74.d()) {
            i = 20;
        } else {
            i = 10;
        }
        s74Var.k = i;
        s74Var.n = r24.b();
        s74Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(s74Var);
    }
}
