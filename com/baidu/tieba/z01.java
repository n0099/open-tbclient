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
public class z01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f11 a;
        public final /* synthetic */ cr0 b;

        public a(f11 f11Var, cr0 cr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f11Var, cr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f11Var;
            this.b = cr0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z01.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull f11 f11Var, @Nullable cr0<T> cr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, f11Var, cr0Var) == null) {
            f11Var.a();
            a21.c(new a(f11Var, cr0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull f11 f11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, f11Var) == null) {
            c(f11Var, null);
        }
    }

    public static <T> void d(f11 f11Var, @Nullable cr0<T> cr0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, f11Var, cr0Var) == null) && f11Var != null && f11Var.isValid()) {
            String f11Var2 = f11Var.toString();
            if (f11Var instanceof ClogBuilder) {
                if (ng0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (f11Var instanceof g11) {
                if (ng0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (f11Var instanceof d11) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            jr0 jr0Var = new jr0();
            jr0Var.h(f11Var2);
            jr0Var.k(BodyStyle.STRING);
            jr0Var.i("application/x-www-form-urlencoded");
            kr0 kr0Var = new kr0();
            kr0Var.l(str);
            kr0Var.f(jr0Var);
            rq0.b().a().a(kr0Var, cr0Var);
        }
    }
}
