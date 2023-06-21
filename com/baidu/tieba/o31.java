package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u31 a;
        public final /* synthetic */ lt0 b;

        public a(u31 u31Var, lt0 lt0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u31Var, lt0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u31Var;
            this.b = lt0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o31.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull u31 u31Var, @Nullable lt0<T> lt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, u31Var, lt0Var) == null) {
            u31Var.a();
            p41.c(new a(u31Var, lt0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull u31 u31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, u31Var) == null) {
            c(u31Var, null);
        }
    }

    public static <T> void d(u31 u31Var, @Nullable lt0<T> lt0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, u31Var, lt0Var) == null) && u31Var != null && u31Var.isValid()) {
            String u31Var2 = u31Var.toString();
            if (u31Var instanceof ClogBuilder) {
                if (wh0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (u31Var instanceof v31) {
                if (wh0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (u31Var instanceof s31) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            st0 st0Var = new st0();
            st0Var.h(u31Var2);
            st0Var.k(BodyStyle.STRING);
            st0Var.i("application/x-www-form-urlencoded");
            tt0 tt0Var = new tt0();
            tt0Var.l(str);
            tt0Var.f(st0Var);
            at0.b().a().a(tt0Var, lt0Var);
        }
    }
}
