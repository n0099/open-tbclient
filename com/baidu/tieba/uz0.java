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
public class uz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a01 a;
        public final /* synthetic */ xp0 b;

        public a(a01 a01Var, xp0 xp0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a01Var, xp0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a01Var;
            this.b = xp0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uz0.d(this.a, this.b);
            }
        }
    }

    public static void b(@NonNull a01 a01Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, a01Var) == null) {
            c(a01Var, null);
        }
    }

    public static <T> void c(@NonNull a01 a01Var, @Nullable xp0<T> xp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, a01Var, xp0Var) == null) {
            a01Var.a();
            v01.c(new a(a01Var, xp0Var), "als_async_executor", 2);
        }
    }

    public static <T> void d(a01 a01Var, @Nullable xp0<T> xp0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, a01Var, xp0Var) == null) && a01Var != null && a01Var.isValid()) {
            String a01Var2 = a01Var.toString();
            if (a01Var instanceof ClogBuilder) {
                str = ag0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (a01Var instanceof b01) {
                str = ag0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : "https://als.baidu.com/elog/plog";
            } else if (!(a01Var instanceof yz0)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            eq0 eq0Var = new eq0();
            eq0Var.h(a01Var2);
            eq0Var.k(BodyStyle.STRING);
            eq0Var.i("application/x-www-form-urlencoded");
            fq0 fq0Var = new fq0();
            fq0Var.k(str);
            fq0Var.f(eq0Var);
            mp0.b().a().a(fq0Var, xp0Var);
        }
    }
}
