package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.dw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes7.dex */
public class sc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends m73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rc4 c;

        public a(rc4 rc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rc4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m73, com.baidu.tieba.n73, com.baidu.tieba.l73
        public void onEvent(@NonNull j73 j73Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j73Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (j73Var.a() != null) {
                    i = j73Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (sc4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                rc4 rc4Var = this.c;
                rc4Var.m = i;
                zh3.x("976", rc4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948146597, "Lcom/baidu/tieba/sc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948146597, "Lcom/baidu/tieba/sc4;");
                return;
            }
        }
        a = qr1.a;
    }

    public static void b(rc4 rc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, rc4Var) != null) || rc4Var == null) {
            return;
        }
        b83.Q().X(null, u23.class, new a(rc4Var));
    }

    public static void c(po1 po1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, po1Var) != null) || po1Var == null || (a2 = po1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(q74.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= q74.a()) {
            return;
        }
        rc4 rc4Var = new rc4();
        rc4Var.b = "stuck";
        rc4Var.e = "jserror";
        rc4Var.f = gb3.g0();
        if (gb3.M() != null && gb3.M().Y() != null) {
            dw2.a Y = gb3.M().Y();
            rc4Var.c = Y.T();
            rc4Var.a = zh3.n(Y.G());
        }
        rc4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (dc4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        rc4Var.k = i;
        rc4Var.n = q74.b();
        rc4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(rc4Var);
    }
}
