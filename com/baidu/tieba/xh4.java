package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xh4 {
    public static /* synthetic */ Interceptable $ic;
    public static xh4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public nh4 a;

    public xh4() {
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
        this.a = new nh4();
    }

    public static xh4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            xh4 xh4Var = b;
            if (xh4Var != null) {
                return xh4Var;
            }
            synchronized (xh4.class) {
                if (b == null) {
                    b = new xh4();
                }
            }
            return b;
        }
        return (xh4) invokeV.objValue;
    }

    public jh4 a(zh4 zh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zh4Var)) == null) {
            if (zh4Var == null) {
                return null;
            }
            return new ei4(zh4Var, false);
        }
        return (jh4) invokeL.objValue;
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

    public synchronized void e(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vh4Var) == null) {
            synchronized (this) {
                this.a.c(vh4Var);
            }
        }
    }

    public synchronized <T> void f(zh4<T> zh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zh4Var) == null) {
            synchronized (this) {
                zh4Var.s(false);
                this.a.h(zh4Var);
            }
        }
    }

    public synchronized void g(vh4 vh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vh4Var) == null) {
            synchronized (this) {
                this.a.i(vh4Var);
            }
        }
    }
}
