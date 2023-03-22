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
public class k11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q11 a;
        public final /* synthetic */ hr0 b;

        public a(q11 q11Var, hr0 hr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q11Var, hr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q11Var;
            this.b = hr0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k11.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull q11 q11Var, @Nullable hr0<T> hr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, q11Var, hr0Var) == null) {
            q11Var.a();
            l21.c(new a(q11Var, hr0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull q11 q11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, q11Var) == null) {
            c(q11Var, null);
        }
    }

    public static <T> void d(q11 q11Var, @Nullable hr0<T> hr0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, q11Var, hr0Var) == null) && q11Var != null && q11Var.isValid()) {
            String q11Var2 = q11Var.toString();
            if (q11Var instanceof ClogBuilder) {
                if (sf0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (q11Var instanceof r11) {
                if (sf0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (q11Var instanceof o11) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            or0 or0Var = new or0();
            or0Var.h(q11Var2);
            or0Var.k(BodyStyle.STRING);
            or0Var.i("application/x-www-form-urlencoded");
            pr0 pr0Var = new pr0();
            pr0Var.l(str);
            pr0Var.f(or0Var);
            wq0.b().a().a(pr0Var, hr0Var);
        }
    }
}
