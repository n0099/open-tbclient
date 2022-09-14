package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yc4 {
    public static /* synthetic */ Interceptable $ic;
    public static yc4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public oc4 a;

    public yc4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new oc4();
    }

    public static yc4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            yc4 yc4Var = b;
            if (yc4Var != null) {
                return yc4Var;
            }
            synchronized (yc4.class) {
                if (b == null) {
                    b = new yc4();
                }
            }
            return b;
        }
        return (yc4) invokeV.objValue;
    }

    public kc4 a(ad4 ad4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ad4Var)) == null) {
            if (ad4Var == null) {
                return null;
            }
            return new fd4(ad4Var, false);
        }
        return (kc4) invokeL.objValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        boolean e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                e = this.a.e(str);
            }
            return e;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        boolean f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                f = this.a.f(str);
            }
            return f;
        }
        return invokeL.booleanValue;
    }

    public synchronized void e(wc4 wc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wc4Var) == null) {
            synchronized (this) {
                this.a.c(wc4Var);
            }
        }
    }

    public synchronized <T> void f(ad4<T> ad4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ad4Var) == null) {
            synchronized (this) {
                ad4Var.s(false);
                this.a.h(ad4Var);
            }
        }
    }

    public synchronized void g(wc4 wc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wc4Var) == null) {
            synchronized (this) {
                this.a.i(wc4Var);
            }
        }
    }
}
