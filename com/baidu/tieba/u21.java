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
public class u21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a31 a;
        public final /* synthetic */ rs0 b;

        public a(a31 a31Var, rs0 rs0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a31Var, rs0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a31Var;
            this.b = rs0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u21.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull a31 a31Var, @Nullable rs0<T> rs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, a31Var, rs0Var) == null) {
            a31Var.a();
            v31.c(new a(a31Var, rs0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull a31 a31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, a31Var) == null) {
            c(a31Var, null);
        }
    }

    public static <T> void d(a31 a31Var, @Nullable rs0<T> rs0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, a31Var, rs0Var) == null) && a31Var != null && a31Var.isValid()) {
            String a31Var2 = a31Var.toString();
            if (a31Var instanceof ClogBuilder) {
                if (ch0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (a31Var instanceof b31) {
                if (ch0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (a31Var instanceof y21) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            ys0 ys0Var = new ys0();
            ys0Var.h(a31Var2);
            ys0Var.k(BodyStyle.STRING);
            ys0Var.i("application/x-www-form-urlencoded");
            zs0 zs0Var = new zs0();
            zs0Var.l(str);
            zs0Var.f(ys0Var);
            gs0.b().a().a(zs0Var, rs0Var);
        }
    }
}
