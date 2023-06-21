package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zl4 {
    public static /* synthetic */ Interceptable $ic;
    public static zl4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public pl4 a;

    public zl4() {
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
        this.a = new pl4();
    }

    public static zl4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            zl4 zl4Var = b;
            if (zl4Var != null) {
                return zl4Var;
            }
            synchronized (zl4.class) {
                if (b == null) {
                    b = new zl4();
                }
            }
            return b;
        }
        return (zl4) invokeV.objValue;
    }

    public ll4 a(bm4 bm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bm4Var)) == null) {
            if (bm4Var == null) {
                return null;
            }
            return new gm4(bm4Var, false);
        }
        return (ll4) invokeL.objValue;
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

    public synchronized void e(xl4 xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xl4Var) == null) {
            synchronized (this) {
                this.a.c(xl4Var);
            }
        }
    }

    public synchronized <T> void f(bm4<T> bm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bm4Var) == null) {
            synchronized (this) {
                bm4Var.s(false);
                this.a.h(bm4Var);
            }
        }
    }

    public synchronized void g(xl4 xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xl4Var) == null) {
            synchronized (this) {
                this.a.i(xl4Var);
            }
        }
    }
}
