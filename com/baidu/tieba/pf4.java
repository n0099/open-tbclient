package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pf4 {
    public static /* synthetic */ Interceptable $ic;
    public static pf4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ff4 a;

    public pf4() {
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
        this.a = new ff4();
    }

    public static pf4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            pf4 pf4Var = b;
            if (pf4Var != null) {
                return pf4Var;
            }
            synchronized (pf4.class) {
                if (b == null) {
                    b = new pf4();
                }
            }
            return b;
        }
        return (pf4) invokeV.objValue;
    }

    public bf4 a(rf4 rf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rf4Var)) == null) {
            if (rf4Var == null) {
                return null;
            }
            return new wf4(rf4Var, false);
        }
        return (bf4) invokeL.objValue;
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

    public synchronized void e(nf4 nf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nf4Var) == null) {
            synchronized (this) {
                this.a.c(nf4Var);
            }
        }
    }

    public synchronized <T> void f(rf4<T> rf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rf4Var) == null) {
            synchronized (this) {
                rf4Var.s(false);
                this.a.h(rf4Var);
            }
        }
    }

    public synchronized void g(nf4 nf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nf4Var) == null) {
            synchronized (this) {
                this.a.i(nf4Var);
            }
        }
    }
}
