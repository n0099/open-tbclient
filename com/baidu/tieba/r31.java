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
public class r31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x31 a;
        public final /* synthetic */ ot0 b;

        public a(x31 x31Var, ot0 ot0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x31Var, ot0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x31Var;
            this.b = ot0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r31.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull x31 x31Var, @Nullable ot0<T> ot0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, x31Var, ot0Var) == null) {
            x31Var.a();
            s41.c(new a(x31Var, ot0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull x31 x31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, x31Var) == null) {
            c(x31Var, null);
        }
    }

    public static <T> void d(x31 x31Var, @Nullable ot0<T> ot0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, x31Var, ot0Var) == null) && x31Var != null && x31Var.isValid()) {
            String x31Var2 = x31Var.toString();
            if (x31Var instanceof ClogBuilder) {
                if (zh0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (x31Var instanceof y31) {
                if (zh0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (x31Var instanceof v31) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            vt0 vt0Var = new vt0();
            vt0Var.h(x31Var2);
            vt0Var.k(BodyStyle.STRING);
            vt0Var.i("application/x-www-form-urlencoded");
            wt0 wt0Var = new wt0();
            wt0Var.l(str);
            wt0Var.f(vt0Var);
            dt0.b().a().a(wt0Var, ot0Var);
        }
    }
}
