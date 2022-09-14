package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.vn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes4.dex */
public class k44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends ez2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j44 c;

        public a(j44 j44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j44Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ez2, com.baidu.tieba.fz2, com.baidu.tieba.dz2
        public void onEvent(@NonNull bz2 bz2Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bz2Var) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = bz2Var.a() != null ? bz2Var.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (k44.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                j44 j44Var = this.c;
                j44Var.m = i;
                r93.x("976", j44Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947863102, "Lcom/baidu/tieba/k44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947863102, "Lcom/baidu/tieba/k44;");
                return;
            }
        }
        a = ij1.a;
    }

    public static void b(j44 j44Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, j44Var) == null) || j44Var == null) {
            return;
        }
        tz2.Q().X(null, mu2.class, new a(j44Var));
    }

    public static void c(rg1 rg1Var) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, rg1Var) == null) || rg1Var == null || (a2 = rg1Var.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(iz3.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= iz3.a()) {
            return;
        }
        j44 j44Var = new j44();
        j44Var.b = "stuck";
        j44Var.e = "jserror";
        j44Var.f = y23.g0();
        if (y23.M() != null && y23.M().Y() != null) {
            vn2.a Y = y23.M().Y();
            j44Var.c = Y.T();
            j44Var.a = r93.n(Y.G());
        }
        j44Var.l = str + ParamableElem.DIVIDE_PARAM + str2;
        j44Var.k = v34.d() ? 20 : 10;
        j44Var.n = iz3.b();
        j44Var.o = System.currentTimeMillis() - a2.exceptionTime;
        b(j44Var);
    }
}
