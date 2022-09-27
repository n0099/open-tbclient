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
/* loaded from: classes6.dex */
public class v74 implements mn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v74() {
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

    @Override // com.baidu.tieba.mn2
    public boolean a(Context context, bq2 bq2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, bq2Var, up2Var, l33Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public boolean b(Context context, wp2 wp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wp2Var, up2Var, l33Var)) == null) ? e84.e().c(context, wp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public boolean c(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, xp2Var, up2Var, l33Var)) == null) ? d84.d().c(context, xp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public void d(rp1 rp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rp1Var) == null) {
            u74.h(rp1Var);
        }
    }

    @Override // com.baidu.tieba.mn2
    public boolean e(Context context, vp2 vp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, vp2Var, up2Var, l33Var)) == null) ? b94.h().c(context, vp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public void f(rp1 rp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rp1Var) == null) {
            u74.d(rp1Var);
        }
    }

    @Override // com.baidu.tieba.mn2
    public boolean g(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, xp2Var, up2Var, l33Var)) == null) ? y74.e().c(context, xp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public boolean h(Context context, zp2 zp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, zp2Var, up2Var, l33Var)) == null) ? g84.e().c(context, zp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public void i(rp1 rp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rp1Var) == null) {
            u74.e(rp1Var);
        }
    }

    @Override // com.baidu.tieba.mn2
    public boolean j(Context context, aq2 aq2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, aq2Var, up2Var, l33Var)) == null) ? h84.e().c(context, aq2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public boolean k(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, xp2Var, up2Var, l33Var)) == null) ? b84.d().c(context, xp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public boolean l(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, xp2Var, up2Var, l33Var)) == null) ? z74.d().c(context, xp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public boolean m(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, xp2Var, up2Var, l33Var)) == null) ? f84.f().c(context, xp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public boolean n(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, xp2Var, up2Var, l33Var)) == null) ? c84.d().c(context, xp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.mn2
    public boolean update(Context context, xp2 xp2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, xp2Var, up2Var, l33Var)) == null) ? a84.d().c(context, xp2Var, up2Var, l33Var) : invokeLLLL.booleanValue;
    }
}
