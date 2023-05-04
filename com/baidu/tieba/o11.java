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
public class o11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u11 a;
        public final /* synthetic */ lr0 b;

        public a(u11 u11Var, lr0 lr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u11Var, lr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u11Var;
            this.b = lr0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o11.d(this.a, this.b);
            }
        }
    }

    public static <T> void c(@NonNull u11 u11Var, @Nullable lr0<T> lr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, u11Var, lr0Var) == null) {
            u11Var.a();
            p21.c(new a(u11Var, lr0Var), "als_async_executor", 2);
        }
    }

    public static void b(@NonNull u11 u11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, u11Var) == null) {
            c(u11Var, null);
        }
    }

    public static <T> void d(u11 u11Var, @Nullable lr0<T> lr0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, u11Var, lr0Var) == null) && u11Var != null && u11Var.isValid()) {
            String u11Var2 = u11Var.toString();
            if (u11Var instanceof ClogBuilder) {
                if (wf0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog";
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (u11Var instanceof v11) {
                if (wf0.a) {
                    str = "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog";
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (u11Var instanceof s11) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            sr0 sr0Var = new sr0();
            sr0Var.h(u11Var2);
            sr0Var.k(BodyStyle.STRING);
            sr0Var.i("application/x-www-form-urlencoded");
            tr0 tr0Var = new tr0();
            tr0Var.l(str);
            tr0Var.f(sr0Var);
            ar0.b().a().a(tr0Var, lr0Var);
        }
    }
}
