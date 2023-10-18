package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes9.dex */
public class z94 implements qp2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qp2
    public boolean a(Context context, fs2 fs2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, fs2Var, yr2Var, p53Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public z94() {
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

    @Override // com.baidu.tieba.qp2
    public boolean b(Context context, as2 as2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, as2Var, yr2Var, p53Var)) == null) {
            return ia4.e().c(context, as2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean c(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, bs2Var, yr2Var, p53Var)) == null) {
            return ha4.d().c(context, bs2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean e(Context context, zr2 zr2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, zr2Var, yr2Var, p53Var)) == null) {
            return fb4.h().c(context, zr2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean g(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, bs2Var, yr2Var, p53Var)) == null) {
            return ca4.e().c(context, bs2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean h(Context context, ds2 ds2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, ds2Var, yr2Var, p53Var)) == null) {
            return ka4.e().c(context, ds2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean j(Context context, es2 es2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, es2Var, yr2Var, p53Var)) == null) {
            return la4.e().c(context, es2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean k(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, bs2Var, yr2Var, p53Var)) == null) {
            return fa4.d().c(context, bs2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean l(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, bs2Var, yr2Var, p53Var)) == null) {
            return da4.d().c(context, bs2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean m(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, bs2Var, yr2Var, p53Var)) == null) {
            return ja4.f().c(context, bs2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean n(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, bs2Var, yr2Var, p53Var)) == null) {
            return ga4.d().c(context, bs2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public boolean o(Context context, bs2 bs2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, bs2Var, yr2Var, p53Var)) == null) {
            return ea4.d().c(context, bs2Var, yr2Var, p53Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.qp2
    public void d(wr1 wr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wr1Var) == null) {
            y94.h(wr1Var);
        }
    }

    @Override // com.baidu.tieba.qp2
    public void f(wr1 wr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wr1Var) == null) {
            y94.d(wr1Var);
        }
    }

    @Override // com.baidu.tieba.qp2
    public void i(wr1 wr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wr1Var) == null) {
            y94.e(wr1Var);
        }
    }
}
