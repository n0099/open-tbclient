package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ya4 {
    public static /* synthetic */ Interceptable $ic;
    public static ya4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public oa4 a;

    public ya4() {
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
        this.a = new oa4();
    }

    public static ya4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ya4 ya4Var = b;
            if (ya4Var != null) {
                return ya4Var;
            }
            synchronized (ya4.class) {
                if (b == null) {
                    b = new ya4();
                }
            }
            return b;
        }
        return (ya4) invokeV.objValue;
    }

    public ka4 a(ab4 ab4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ab4Var)) == null) {
            if (ab4Var == null) {
                return null;
            }
            return new fb4(ab4Var, false);
        }
        return (ka4) invokeL.objValue;
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

    public synchronized void e(wa4 wa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wa4Var) == null) {
            synchronized (this) {
                this.a.c(wa4Var);
            }
        }
    }

    public synchronized <T> void f(ab4<T> ab4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ab4Var) == null) {
            synchronized (this) {
                ab4Var.s(false);
                this.a.h(ab4Var);
            }
        }
    }

    public synchronized void g(wa4 wa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wa4Var) == null) {
            synchronized (this) {
                this.a.i(wa4Var);
            }
        }
    }
}
