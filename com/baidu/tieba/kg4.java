package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class kg4 {
    public static /* synthetic */ Interceptable $ic;
    public static kg4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ag4 a;

    public kg4() {
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
        this.a = new ag4();
    }

    public static kg4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            kg4 kg4Var = b;
            if (kg4Var != null) {
                return kg4Var;
            }
            synchronized (kg4.class) {
                if (b == null) {
                    b = new kg4();
                }
            }
            return b;
        }
        return (kg4) invokeV.objValue;
    }

    public wf4 a(mg4 mg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mg4Var)) == null) {
            if (mg4Var == null) {
                return null;
            }
            return new rg4(mg4Var, false);
        }
        return (wf4) invokeL.objValue;
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

    public synchronized void e(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ig4Var) == null) {
            synchronized (this) {
                this.a.c(ig4Var);
            }
        }
    }

    public synchronized <T> void f(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mg4Var) == null) {
            synchronized (this) {
                mg4Var.s(false);
                this.a.h(mg4Var);
            }
        }
    }

    public synchronized void g(ig4 ig4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ig4Var) == null) {
            synchronized (this) {
                this.a.i(ig4Var);
            }
        }
    }
}
