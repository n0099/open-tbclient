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
/* loaded from: classes7.dex */
public class qd4 implements ht2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ht2
    public boolean a(Context context, wv2 wv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, wv2Var, pv2Var, g93Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public qd4() {
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

    @Override // com.baidu.tieba.ht2
    public boolean b(Context context, rv2 rv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rv2Var, pv2Var, g93Var)) == null) {
            return zd4.e().c(context, rv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean c(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, sv2Var, pv2Var, g93Var)) == null) {
            return yd4.d().c(context, sv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean e(Context context, qv2 qv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, qv2Var, pv2Var, g93Var)) == null) {
            return we4.h().c(context, qv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean g(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, sv2Var, pv2Var, g93Var)) == null) {
            return td4.e().c(context, sv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean h(Context context, uv2 uv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, uv2Var, pv2Var, g93Var)) == null) {
            return be4.e().c(context, uv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean j(Context context, vv2 vv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, vv2Var, pv2Var, g93Var)) == null) {
            return ce4.e().c(context, vv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean k(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, sv2Var, pv2Var, g93Var)) == null) {
            return wd4.d().c(context, sv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean l(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, sv2Var, pv2Var, g93Var)) == null) {
            return ud4.d().c(context, sv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean m(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, sv2Var, pv2Var, g93Var)) == null) {
            return ae4.f().c(context, sv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean n(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, sv2Var, pv2Var, g93Var)) == null) {
            return xd4.d().c(context, sv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public boolean update(Context context, sv2 sv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, sv2Var, pv2Var, g93Var)) == null) {
            return vd4.d().c(context, sv2Var, pv2Var, g93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ht2
    public void d(mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mv1Var) == null) {
            pd4.h(mv1Var);
        }
    }

    @Override // com.baidu.tieba.ht2
    public void f(mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mv1Var) == null) {
            pd4.d(mv1Var);
        }
    }

    @Override // com.baidu.tieba.ht2
    public void i(mv1 mv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mv1Var) == null) {
            pd4.e(mv1Var);
        }
    }
}
