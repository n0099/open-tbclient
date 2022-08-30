package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class iy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy0 a;
        public final /* synthetic */ lo0 b;

        public a(oy0 oy0Var, lo0 lo0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy0Var, lo0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy0Var;
            this.b = lo0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iy0.d(this.a, this.b);
            }
        }
    }

    public static void b(@NonNull oy0 oy0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, oy0Var) == null) {
            c(oy0Var, null);
        }
    }

    public static <T> void c(@NonNull oy0 oy0Var, @Nullable lo0<T> lo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, oy0Var, lo0Var) == null) {
            oy0Var.a();
            gz0.c(new a(oy0Var, lo0Var), "als_async_executor", 2);
        }
    }

    public static <T> void d(oy0 oy0Var, @Nullable lo0<T> lo0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, oy0Var, lo0Var) == null) && oy0Var != null && oy0Var.isValid()) {
            String oy0Var2 = oy0Var.toString();
            if (oy0Var instanceof ClogBuilder) {
                str = ue0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/clog/clog" : "https://als.baidu.com/clog/clog";
            } else if (oy0Var instanceof py0) {
                str = ue0.a ? "http://x1250658afd00.als.nativeads-afd.otp.baidu.com/elog/plog" : TbConfig.REPORT_PLOG;
            } else if (!(oy0Var instanceof my0)) {
                return;
            } else {
                str = "https://afd.baidu.com/afd/close";
            }
            so0 so0Var = new so0();
            so0Var.h(oy0Var2);
            so0Var.k(BodyStyle.STRING);
            so0Var.i("application/x-www-form-urlencoded");
            to0 to0Var = new to0();
            to0Var.k(str);
            to0Var.f(so0Var);
            ao0.b().a().a(to0Var, lo0Var);
        }
    }
}
