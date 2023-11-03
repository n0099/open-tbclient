package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class pc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id3 a;

        public a(id3 id3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nc3.k("934", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948057193, "Lcom/baidu/tieba/pc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948057193, "Lcom/baidu/tieba/pc3;");
                return;
            }
        }
        a = rm1.a;
    }

    public static void a(id3 id3Var, dr2 dr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, id3Var, dr2Var) == null) && id3Var != null && dr2Var != null) {
            id3Var.a = zc3.n(dr2Var.H());
            id3Var.f = dr2Var.I();
            id3Var.c = dr2Var.U();
            id3Var.a("swan", lf3.h(dr2Var.H()));
            id3Var.a("appversion", dr2Var.x1());
            id3Var.a("thirdversion", dr2Var.y1());
            id3Var.b(zc3.k(dr2Var.X()));
            id3Var.d(dr2Var.t0().getString("ubc"));
        }
    }

    public static void b(jd3 jd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jd3Var) == null) {
            if (jd3Var == null) {
                if (a) {
                    Log.w("SwanAppFuncUbc", "event is null");
                    return;
                }
                return;
            }
            id3 id3Var = new id3();
            id3Var.f = jd3Var.f;
            id3Var.a = jd3Var.a;
            id3Var.g = jd3Var.g;
            id3Var.c = jd3Var.c;
            id3Var.b = jd3Var.b;
            id3Var.e = jd3Var.e;
            id3Var.e(jd3Var.c());
            c(id3Var);
        }
    }

    public static void c(id3 id3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, id3Var) == null) {
            aj3.j(new a(id3Var), "SwanAppFuncClickUBC");
        }
    }
}
