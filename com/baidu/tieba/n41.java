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
/* loaded from: classes7.dex */
public class n41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t41 a;
        public final /* synthetic */ cu0 b;

        public a(t41 t41Var, cu0 cu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t41Var, cu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t41Var;
            this.b = cu0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n41.g(this.a, this.b);
            }
        }
    }

    public static <T> void f(@NonNull t41 t41Var, @Nullable cu0<T> cu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, t41Var, cu0Var) == null) {
            t41Var.a();
            o51.c(new a(t41Var, cu0Var), "als_async_executor", 2);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return rk0.d().z() + "/clog/clog";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return rk0.d().z() + "/elog/plog";
        }
        return (String) invokeV.objValue;
    }

    public static Boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!i61.a) {
                return Boolean.FALSE;
            }
            k61 k61Var = (k61) h61.a().a(k61.class);
            if (k61Var != null && k61Var.a()) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeV.objValue;
    }

    public static void e(@NonNull t41 t41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t41Var) == null) {
            f(t41Var, null);
        }
    }

    public static <T> void g(t41 t41Var, @Nullable cu0<T> cu0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, t41Var, cu0Var) == null) && t41Var != null && t41Var.isValid()) {
            String t41Var2 = t41Var.toString();
            if (t41Var instanceof ClogBuilder) {
                if (d().booleanValue()) {
                    str = b();
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (t41Var instanceof u41) {
                if (d().booleanValue()) {
                    str = c();
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (t41Var instanceof r41) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            ju0 ju0Var = new ju0();
            ju0Var.h(t41Var2);
            ju0Var.k(BodyStyle.STRING);
            ju0Var.i("application/x-www-form-urlencoded");
            ku0 ku0Var = new ku0();
            ku0Var.l(str);
            ku0Var.f(ju0Var);
            rt0.b().a().a(ku0Var, cu0Var);
        }
    }
}
