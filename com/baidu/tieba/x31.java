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
/* loaded from: classes8.dex */
public class x31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d41 a;
        public final /* synthetic */ mt0 b;

        public a(d41 d41Var, mt0 mt0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d41Var, mt0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d41Var;
            this.b = mt0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x31.g(this.a, this.b);
            }
        }
    }

    public static <T> void f(@NonNull d41 d41Var, @Nullable mt0<T> mt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, d41Var, mt0Var) == null) {
            d41Var.a();
            y41.c(new a(d41Var, mt0Var), "als_async_executor", 2);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return tj0.d().z() + "/clog/clog";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return tj0.d().z() + "/elog/plog";
        }
        return (String) invokeV.objValue;
    }

    public static Boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!u51.a) {
                return Boolean.FALSE;
            }
            w51 w51Var = (w51) t51.a().a(w51.class);
            if (w51Var != null && w51Var.a()) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeV.objValue;
    }

    public static void e(@NonNull d41 d41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, d41Var) == null) {
            f(d41Var, null);
        }
    }

    public static <T> void g(d41 d41Var, @Nullable mt0<T> mt0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, d41Var, mt0Var) == null) && d41Var != null && d41Var.isValid()) {
            String d41Var2 = d41Var.toString();
            if (d41Var instanceof ClogBuilder) {
                if (d().booleanValue()) {
                    str = b();
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (d41Var instanceof e41) {
                if (d().booleanValue()) {
                    str = c();
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (d41Var instanceof b41) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            tt0 tt0Var = new tt0();
            tt0Var.h(d41Var2);
            tt0Var.k(BodyStyle.STRING);
            tt0Var.i("application/x-www-form-urlencoded");
            ut0 ut0Var = new ut0();
            ut0Var.l(str);
            ut0Var.f(tt0Var);
            bt0.b().a().a(ut0Var, mt0Var);
        }
    }
}
