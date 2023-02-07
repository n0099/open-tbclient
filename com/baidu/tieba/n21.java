package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t21 a;
        public final /* synthetic */ ls0 b;

        public a(t21 t21Var, ls0 ls0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t21Var, ls0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t21Var;
            this.b = ls0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n21.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull t21 t21Var, @Nullable ls0<T> ls0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, t21Var, ls0Var) == null) {
            t21Var.a();
            o31.c(new a(t21Var, ls0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull t21 t21Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, t21Var) == null) {
            c(t21Var, null);
        }
    }

    public static <T> void d(t21 t21Var, @Nullable ls0<T> ls0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, t21Var, ls0Var) == null) && t21Var != null && t21Var.isValid()) {
            String t21Var2 = t21Var.toString();
            if (t21Var instanceof ClogBuilder) {
                if (yg0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (t21Var instanceof u21) {
                if (yg0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (t21Var instanceof r21) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            ss0 ss0Var = new ss0();
            ss0Var.h(t21Var2);
            ss0Var.k(BodyStyle.STRING);
            ss0Var.i("application/x-www-form-urlencoded");
            ts0 ts0Var = new ts0();
            ts0Var.l(str);
            ts0Var.f(ss0Var);
            as0.b().a().a(ts0Var, ls0Var);
        }
    }
}
