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
public class l11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r11 a;
        public final /* synthetic */ ir0 b;

        public a(r11 r11Var, ir0 ir0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r11Var, ir0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r11Var;
            this.b = ir0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l11.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull r11 r11Var, @Nullable ir0<T> ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, r11Var, ir0Var) == null) {
            r11Var.a();
            m21.c(new a(r11Var, ir0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull r11 r11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, r11Var) == null) {
            c(r11Var, null);
        }
    }

    public static <T> void d(r11 r11Var, @Nullable ir0<T> ir0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, r11Var, ir0Var) == null) && r11Var != null && r11Var.isValid()) {
            String r11Var2 = r11Var.toString();
            if (r11Var instanceof ClogBuilder) {
                if (tf0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (r11Var instanceof s11) {
                if (tf0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (r11Var instanceof p11) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            pr0 pr0Var = new pr0();
            pr0Var.h(r11Var2);
            pr0Var.k(BodyStyle.STRING);
            pr0Var.i("application/x-www-form-urlencoded");
            qr0 qr0Var = new qr0();
            qr0Var.l(str);
            qr0Var.f(pr0Var);
            xq0.b().a().a(qr0Var, ir0Var);
        }
    }
}
