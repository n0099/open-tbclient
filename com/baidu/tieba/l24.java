package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes4.dex */
public class l24 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends gx2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k24 c;

        public a(k24 k24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k24Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gx2, com.baidu.tieba.hx2, com.baidu.tieba.fx2
        public void onEvent(@NonNull dx2 dx2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dx2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = dx2Var.a() != null ? dx2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (l24.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                k24 k24Var = this.c;
                k24Var.m = i;
                t73.x("976", k24Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890971, "Lcom/baidu/tieba/l24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890971, "Lcom/baidu/tieba/l24;");
                return;
            }
        }
        a = kh1.a;
    }

    public static void b(k24 k24Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, k24Var) == null) || k24Var == null) {
            return;
        }
        vx2.Q().X(null, os2.class, new a(k24Var));
    }

    public static void c(ue1 ue1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, ue1Var) == null) || ue1Var == null || (a2 = ue1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(jx3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= jx3.a()) {
            return;
        }
        k24 k24Var = new k24();
        k24Var.b = "stuck";
        k24Var.e = "jserror";
        k24Var.f = a13.g0();
        if (a13.M() != null && a13.M().Y() != null) {
            xl2.a Y = a13.M().Y();
            k24Var.c = Y.T();
            k24Var.a = t73.n(Y.G());
        }
        k24Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        k24Var.k = w14.d() ? 20 : 10;
        k24Var.n = jx3.b();
        k24Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(k24Var);
    }
}
