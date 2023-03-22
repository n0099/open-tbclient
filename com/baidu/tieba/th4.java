package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class th4 {
    public static /* synthetic */ Interceptable $ic;
    public static th4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public jh4 a;

    public th4() {
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
        this.a = new jh4();
    }

    public static th4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            th4 th4Var = b;
            if (th4Var != null) {
                return th4Var;
            }
            synchronized (th4.class) {
                if (b == null) {
                    b = new th4();
                }
            }
            return b;
        }
        return (th4) invokeV.objValue;
    }

    public fh4 a(vh4 vh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vh4Var)) == null) {
            if (vh4Var == null) {
                return null;
            }
            return new ai4(vh4Var, false);
        }
        return (fh4) invokeL.objValue;
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

    public synchronized void e(rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rh4Var) == null) {
            synchronized (this) {
                this.a.c(rh4Var);
            }
        }
    }

    public synchronized <T> void f(vh4<T> vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vh4Var) == null) {
            synchronized (this) {
                vh4Var.s(false);
                this.a.h(vh4Var);
            }
        }
    }

    public synchronized void g(rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rh4Var) == null) {
            synchronized (this) {
                this.a.i(rh4Var);
            }
        }
    }
}
