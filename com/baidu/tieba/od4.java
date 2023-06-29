package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes7.dex */
public class od4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends i83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd4 c;

        public a(nd4 nd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nd4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i83, com.baidu.tieba.j83, com.baidu.tieba.h83
        public void onEvent(@NonNull f83 f83Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f83Var) == null) {
                if (!SwanAppNetworkUtils.i(null)) {
                    i = -2;
                } else if (f83Var.a() != null) {
                    i = f83Var.a().getInt("net_quality");
                } else {
                    i = -1;
                }
                if (od4.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                nd4 nd4Var = this.c;
                nd4Var.m = i;
                vi3.x("976", nd4Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948028394, "Lcom/baidu/tieba/od4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948028394, "Lcom/baidu/tieba/od4;");
                return;
            }
        }
        a = ms1.a;
    }

    public static void b(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, nd4Var) != null) || nd4Var == null) {
            return;
        }
        x83.Q().X(null, q33.class, new a(nd4Var));
    }

    public static void c(lp1 lp1Var) {
        V8ExceptionInfo a2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, lp1Var) != null) || lp1Var == null || (a2 = lp1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(m84.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= m84.a()) {
            return;
        }
        nd4 nd4Var = new nd4();
        nd4Var.b = "stuck";
        nd4Var.e = "jserror";
        nd4Var.f = cc3.g0();
        if (cc3.M() != null && cc3.M().Y() != null) {
            zw2.a Y = cc3.M().Y();
            nd4Var.c = Y.T();
            nd4Var.a = vi3.n(Y.G());
        }
        nd4Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        if (zc4.d()) {
            i = 20;
        } else {
            i = 10;
        }
        nd4Var.k = i;
        nd4Var.n = m84.b();
        nd4Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(nd4Var);
    }
}
