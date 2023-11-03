package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes8.dex */
public class s74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends m23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r74 c;

        public a(r74 r74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r74Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m23, com.baidu.tieba.n23, com.baidu.tieba.l23
        public void onEvent(@NonNull j23 j23Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j23Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (j23Var.a() != null) {
                    i = j23Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (s74.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                r74 r74Var = this.c;
                r74Var.m = i;
                zc3.x("976", r74Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948104313, "Lcom/baidu/tieba/s74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948104313, "Lcom/baidu/tieba/s74;");
                return;
            }
        }
        a = rm1.a;
    }

    public static void b(r74 r74Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, r74Var) != null) || r74Var == null) {
            return;
        }
        b33.Q().X(null, ux2.class, new a(r74Var));
    }

    public static void c(qj1 qj1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, qj1Var) != null) || qj1Var == null || (a2 = qj1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(q24.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= q24.a()) {
            return;
        }
        r74 r74Var = new r74();
        r74Var.b = "stuck";
        r74Var.e = "jserror";
        r74Var.f = g63.h0();
        if (g63.M() != null && g63.M().Z() != null) {
            dr2.a Z = g63.M().Z();
            r74Var.c = Z.U();
            r74Var.a = zc3.n(Z.H());
        }
        r74Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (d74.d()) {
            i = 20;
        } else {
            i = 10;
        }
        r74Var.k = i;
        r74Var.n = q24.b();
        r74Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(r74Var);
    }
}
