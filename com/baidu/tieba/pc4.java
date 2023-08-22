package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.aw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes7.dex */
public class pc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends j73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc4 c;

        public a(oc4 oc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oc4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j73, com.baidu.tieba.k73, com.baidu.tieba.i73
        public void onEvent(@NonNull g73 g73Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g73Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (g73Var.a() != null) {
                    i = g73Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (pc4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                oc4 oc4Var = this.c;
                oc4Var.m = i;
                wh3.x("976", oc4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948057224, "Lcom/baidu/tieba/pc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948057224, "Lcom/baidu/tieba/pc4;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void b(oc4 oc4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, oc4Var) != null) || oc4Var == null) {
            return;
        }
        y73.Q().X(null, r23.class, new a(oc4Var));
    }

    public static void c(mo1 mo1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, mo1Var) != null) || mo1Var == null || (a2 = mo1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(n74.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= n74.a()) {
            return;
        }
        oc4 oc4Var = new oc4();
        oc4Var.b = "stuck";
        oc4Var.e = "jserror";
        oc4Var.f = db3.g0();
        if (db3.M() != null && db3.M().Y() != null) {
            aw2.a Y = db3.M().Y();
            oc4Var.c = Y.T();
            oc4Var.a = wh3.n(Y.G());
        }
        oc4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (ac4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        oc4Var.k = i;
        oc4Var.n = n74.b();
        oc4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(oc4Var);
    }
}
