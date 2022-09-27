package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes6.dex */
public class x44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends rz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w44 c;

        public a(w44 w44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w44Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rz2, com.baidu.tieba.sz2, com.baidu.tieba.qz2
        public void onEvent(@NonNull oz2 oz2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oz2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = oz2Var.a() != null ? oz2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (x44.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                w44 w44Var = this.c;
                w44Var.m = i;
                ea3.x("976", w44Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948250385, "Lcom/baidu/tieba/x44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948250385, "Lcom/baidu/tieba/x44;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void b(w44 w44Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, w44Var) == null) || w44Var == null) {
            return;
        }
        g03.Q().X(null, zu2.class, new a(w44Var));
    }

    public static void c(eh1 eh1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, eh1Var) == null) || eh1Var == null || (a2 = eh1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(vz3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= vz3.a()) {
            return;
        }
        w44 w44Var = new w44();
        w44Var.b = "stuck";
        w44Var.e = "jserror";
        w44Var.f = l33.g0();
        if (l33.M() != null && l33.M().Y() != null) {
            io2.a Y = l33.M().Y();
            w44Var.c = Y.T();
            w44Var.a = ea3.n(Y.G());
        }
        w44Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        w44Var.k = i44.d() ? 20 : 10;
        w44Var.n = vz3.b();
        w44Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(w44Var);
    }
}
