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
public class m11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s11 a;
        public final /* synthetic */ jr0 b;

        public a(s11 s11Var, jr0 jr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s11Var, jr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s11Var;
            this.b = jr0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m11.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull s11 s11Var, @Nullable jr0<T> jr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, s11Var, jr0Var) == null) {
            s11Var.a();
            n21.c(new a(s11Var, jr0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull s11 s11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, s11Var) == null) {
            c(s11Var, null);
        }
    }

    public static <T> void d(s11 s11Var, @Nullable jr0<T> jr0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, s11Var, jr0Var) == null) && s11Var != null && s11Var.isValid()) {
            String s11Var2 = s11Var.toString();
            if (s11Var instanceof ClogBuilder) {
                if (uf0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (s11Var instanceof t11) {
                if (uf0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (s11Var instanceof q11) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            qr0 qr0Var = new qr0();
            qr0Var.h(s11Var2);
            qr0Var.k(BodyStyle.STRING);
            qr0Var.i("application/x-www-form-urlencoded");
            rr0 rr0Var = new rr0();
            rr0Var.l(str);
            rr0Var.f(qr0Var);
            yq0.b().a().a(rr0Var, jr0Var);
        }
    }
}
