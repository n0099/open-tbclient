package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class uh4 {
    public static /* synthetic */ Interceptable $ic;
    public static uh4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public kh4 a;

    public uh4() {
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
        this.a = new kh4();
    }

    public static uh4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            uh4 uh4Var = b;
            if (uh4Var != null) {
                return uh4Var;
            }
            synchronized (uh4.class) {
                if (b == null) {
                    b = new uh4();
                }
            }
            return b;
        }
        return (uh4) invokeV.objValue;
    }

    public gh4 a(wh4 wh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wh4Var)) == null) {
            if (wh4Var == null) {
                return null;
            }
            return new bi4(wh4Var, false);
        }
        return (gh4) invokeL.objValue;
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

    public synchronized void e(sh4 sh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sh4Var) == null) {
            synchronized (this) {
                this.a.c(sh4Var);
            }
        }
    }

    public synchronized <T> void f(wh4<T> wh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wh4Var) == null) {
            synchronized (this) {
                wh4Var.s(false);
                this.a.h(wh4Var);
            }
        }
    }

    public synchronized void g(sh4 sh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sh4Var) == null) {
            synchronized (this) {
                this.a.i(sh4Var);
            }
        }
    }
}
