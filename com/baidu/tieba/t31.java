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
public class t31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z31 a;
        public final /* synthetic */ it0 b;

        public a(z31 z31Var, it0 it0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z31Var, it0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z31Var;
            this.b = it0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t31.g(this.a, this.b);
            }
        }
    }

    public static <T> void f(@NonNull z31 z31Var, @Nullable it0<T> it0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, z31Var, it0Var) == null) {
            z31Var.a();
            u41.c(new a(z31Var, it0Var), "als_async_executor", 2);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return sj0.d().z() + "/clog/clog";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return sj0.d().z() + "/elog/plog";
        }
        return (String) invokeV.objValue;
    }

    public static Boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!q51.a) {
                return Boolean.FALSE;
            }
            s51 s51Var = (s51) p51.a().a(s51.class);
            if (s51Var != null && s51Var.a()) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeV.objValue;
    }

    public static void e(@NonNull z31 z31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, z31Var) == null) {
            f(z31Var, null);
        }
    }

    public static <T> void g(z31 z31Var, @Nullable it0<T> it0Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, z31Var, it0Var) == null) && z31Var != null && z31Var.isValid()) {
            String z31Var2 = z31Var.toString();
            if (z31Var instanceof ClogBuilder) {
                if (d().booleanValue()) {
                    str = b();
                } else {
                    str = "https://als.baidu.com/clog/clog";
                }
            } else if (z31Var instanceof a41) {
                if (d().booleanValue()) {
                    str = c();
                } else {
                    str = "https://als.baidu.com/elog/plog";
                }
            } else if (z31Var instanceof x31) {
                str = "https://afd.baidu.com/afd/close";
            } else {
                return;
            }
            pt0 pt0Var = new pt0();
            pt0Var.h(z31Var2);
            pt0Var.k(BodyStyle.STRING);
            pt0Var.i("application/x-www-form-urlencoded");
            qt0 qt0Var = new qt0();
            qt0Var.l(str);
            qt0Var.f(pt0Var);
            xs0.b().a().a(qt0Var, it0Var);
        }
    }
}
