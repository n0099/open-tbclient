package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes5.dex */
public class j94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends d43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i94 c;

        public a(i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.d43, com.baidu.tieba.e43, com.baidu.tieba.c43
        public void onEvent(@NonNull a43 a43Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a43Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (a43Var.a() != null) {
                    i = a43Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (j94.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                i94 i94Var = this.c;
                i94Var.m = i;
                qe3.x("976", i94Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947838116, "Lcom/baidu/tieba/j94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947838116, "Lcom/baidu/tieba/j94;");
                return;
            }
        }
        a = ho1.a;
    }

    public static void b(i94 i94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, i94Var) != null) || i94Var == null) {
            return;
        }
        s43.Q().X(null, lz2.class, new a(i94Var));
    }

    public static void c(ll1 ll1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, ll1Var) != null) || ll1Var == null || (a2 = ll1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(h44.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= h44.a()) {
            return;
        }
        i94 i94Var = new i94();
        i94Var.b = "stuck";
        i94Var.e = "jserror";
        i94Var.f = x73.g0();
        if (x73.M() != null && x73.M().Y() != null) {
            us2.a Y = x73.M().Y();
            i94Var.c = Y.T();
            i94Var.a = qe3.n(Y.G());
        }
        i94Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (u84.d()) {
            i = 20;
        } else {
            i = 10;
        }
        i94Var.k = i;
        i94Var.n = h44.b();
        i94Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(i94Var);
    }
}
