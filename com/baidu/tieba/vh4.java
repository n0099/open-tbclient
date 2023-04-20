package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vh4 {
    public static /* synthetic */ Interceptable $ic;
    public static vh4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public lh4 a;

    public vh4() {
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
        this.a = new lh4();
    }

    public static vh4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            vh4 vh4Var = b;
            if (vh4Var != null) {
                return vh4Var;
            }
            synchronized (vh4.class) {
                if (b == null) {
                    b = new vh4();
                }
            }
            return b;
        }
        return (vh4) invokeV.objValue;
    }

    public hh4 a(xh4 xh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xh4Var)) == null) {
            if (xh4Var == null) {
                return null;
            }
            return new ci4(xh4Var, false);
        }
        return (hh4) invokeL.objValue;
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

    public synchronized void e(th4 th4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, th4Var) == null) {
            synchronized (this) {
                this.a.c(th4Var);
            }
        }
    }

    public synchronized <T> void f(xh4<T> xh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xh4Var) == null) {
            synchronized (this) {
                xh4Var.s(false);
                this.a.h(xh4Var);
            }
        }
    }

    public synchronized void g(th4 th4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, th4Var) == null) {
            synchronized (this) {
                this.a.i(th4Var);
            }
        }
    }
}
