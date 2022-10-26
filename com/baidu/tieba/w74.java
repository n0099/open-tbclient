package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w74 implements nn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nn2
    public boolean a(Context context, cq2 cq2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, cq2Var, vp2Var, m33Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public w74() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.nn2
    public boolean b(Context context, xp2 xp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xp2Var, vp2Var, m33Var)) == null) {
            return f84.e().c(context, xp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean c(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, yp2Var, vp2Var, m33Var)) == null) {
            return e84.d().c(context, yp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean e(Context context, wp2 wp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, wp2Var, vp2Var, m33Var)) == null) {
            return c94.h().c(context, wp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean g(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, yp2Var, vp2Var, m33Var)) == null) {
            return z74.e().c(context, yp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean h(Context context, aq2 aq2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, aq2Var, vp2Var, m33Var)) == null) {
            return h84.e().c(context, aq2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean j(Context context, bq2 bq2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, bq2Var, vp2Var, m33Var)) == null) {
            return i84.e().c(context, bq2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean k(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, yp2Var, vp2Var, m33Var)) == null) {
            return c84.d().c(context, yp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean l(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, yp2Var, vp2Var, m33Var)) == null) {
            return a84.d().c(context, yp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean m(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, yp2Var, vp2Var, m33Var)) == null) {
            return g84.f().c(context, yp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean n(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, yp2Var, vp2Var, m33Var)) == null) {
            return d84.d().c(context, yp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public boolean update(Context context, yp2 yp2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, yp2Var, vp2Var, m33Var)) == null) {
            return b84.d().c(context, yp2Var, vp2Var, m33Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nn2
    public void d(sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sp1Var) == null) {
            v74.h(sp1Var);
        }
    }

    @Override // com.baidu.tieba.nn2
    public void f(sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sp1Var) == null) {
            v74.d(sp1Var);
        }
    }

    @Override // com.baidu.tieba.nn2
    public void i(sp1 sp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sp1Var) == null) {
            v74.e(sp1Var);
        }
    }
}
