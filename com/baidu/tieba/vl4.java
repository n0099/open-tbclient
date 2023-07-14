package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vl4 {
    public static /* synthetic */ Interceptable $ic;
    public static vl4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ll4 a;

    public vl4() {
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
        this.a = new ll4();
    }

    public static vl4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            vl4 vl4Var = b;
            if (vl4Var != null) {
                return vl4Var;
            }
            synchronized (vl4.class) {
                if (b == null) {
                    b = new vl4();
                }
            }
            return b;
        }
        return (vl4) invokeV.objValue;
    }

    public hl4 a(xl4 xl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xl4Var)) == null) {
            if (xl4Var == null) {
                return null;
            }
            return new cm4(xl4Var, false);
        }
        return (hl4) invokeL.objValue;
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

    public synchronized void e(tl4 tl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tl4Var) == null) {
            synchronized (this) {
                this.a.c(tl4Var);
            }
        }
    }

    public synchronized <T> void f(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xl4Var) == null) {
            synchronized (this) {
                xl4Var.s(false);
                this.a.h(xl4Var);
            }
        }
    }

    public synchronized void g(tl4 tl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tl4Var) == null) {
            synchronized (this) {
                this.a.i(tl4Var);
            }
        }
    }
}
