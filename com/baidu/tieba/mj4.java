package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mj4 {
    public static /* synthetic */ Interceptable $ic;
    public static mj4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public cj4 a;

    public mj4() {
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
        this.a = new cj4();
    }

    public static mj4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            mj4 mj4Var = b;
            if (mj4Var != null) {
                return mj4Var;
            }
            synchronized (mj4.class) {
                if (b == null) {
                    b = new mj4();
                }
            }
            return b;
        }
        return (mj4) invokeV.objValue;
    }

    public yi4 a(oj4 oj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oj4Var)) == null) {
            if (oj4Var == null) {
                return null;
            }
            return new tj4(oj4Var, false);
        }
        return (yi4) invokeL.objValue;
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

    public synchronized void e(kj4 kj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kj4Var) == null) {
            synchronized (this) {
                this.a.c(kj4Var);
            }
        }
    }

    public synchronized <T> void f(oj4<T> oj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oj4Var) == null) {
            synchronized (this) {
                oj4Var.s(false);
                this.a.h(oj4Var);
            }
        }
    }

    public synchronized void g(kj4 kj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kj4Var) == null) {
            synchronized (this) {
                this.a.i(kj4Var);
            }
        }
    }
}
