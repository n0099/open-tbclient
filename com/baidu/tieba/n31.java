package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t31 a;
        public final /* synthetic */ kt0 b;

        public a(t31 t31Var, kt0 kt0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t31Var, kt0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t31Var;
            this.b = kt0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n31.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull t31 t31Var, @Nullable kt0<T> kt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, t31Var, kt0Var) == null) {
            t31Var.a();
            o41.c(new a(t31Var, kt0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull t31 t31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, t31Var) == null) {
            c(t31Var, null);
        }
    }

    public static <T> void d(t31 t31Var, @Nullable kt0<T> kt0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, t31Var, kt0Var) == null) && t31Var != null && t31Var.isValid()) {
            String t31Var2 = t31Var.toString();
            if (t31Var instanceof ClogBuilder) {
                if (vh0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (t31Var instanceof u31) {
                if (vh0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (t31Var instanceof r31) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            rt0 rt0Var = new rt0();
            rt0Var.h(t31Var2);
            rt0Var.k(BodyStyle.STRING);
            rt0Var.i("application/x-www-form-urlencoded");
            st0 st0Var = new st0();
            st0Var.l(str);
            st0Var.f(rt0Var);
            zs0.b().a().a(st0Var, kt0Var);
        }
    }
}
