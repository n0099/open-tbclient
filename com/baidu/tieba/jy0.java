package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py0 a;
        public final /* synthetic */ io0 b;

        public a(py0 py0Var, io0 io0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py0Var, io0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py0Var;
            this.b = io0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jy0.g(this.a, this.b);
            }
        }
    }

    public static <T> void f(@NonNull py0 py0Var, @Nullable io0<T> io0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, py0Var, io0Var) == null) {
            py0Var.a();
            kz0.c(new a(py0Var, io0Var), "als_async_executor", 2);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return pe0.d().A() + "/clog/clog";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return pe0.d().A() + "/elog/plog";
        }
        return (String) invokeV.objValue;
    }

    public static Boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!g01.a) {
                return Boolean.FALSE;
            }
            i01 i01Var = (i01) f01.a().a(i01.class);
            if (i01Var != null && i01Var.a()) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeV.objValue;
    }

    public static void e(@NonNull py0 py0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, py0Var) == null) {
            f(py0Var, null);
        }
    }

    public static <T> void g(py0 py0Var, @Nullable io0<T> io0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, py0Var, io0Var) == null) && py0Var != null && py0Var.isValid()) {
            String py0Var2 = py0Var.toString();
            if (py0Var instanceof ClogBuilder) {
                if (d().booleanValue()) {
                    str = b();
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (py0Var instanceof qy0) {
                if (d().booleanValue()) {
                    str = c();
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (py0Var instanceof ny0) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            po0 po0Var = new po0();
            po0Var.h(py0Var2);
            po0Var.k(BodyStyle.STRING);
            po0Var.i("application/x-www-form-urlencoded");
            qo0 qo0Var = new qo0();
            qo0Var.l(str);
            qo0Var.f(po0Var);
            xn0.b().a().a(qo0Var, io0Var);
        }
    }
}
