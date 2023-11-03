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
public class qa4 implements hq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hq2
    public boolean a(Context context, ws2 ws2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ws2Var, ps2Var, g63Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public qa4() {
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

    @Override // com.baidu.tieba.hq2
    public boolean b(Context context, rs2 rs2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rs2Var, ps2Var, g63Var)) == null) {
            return za4.e().c(context, rs2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean c(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ss2Var, ps2Var, g63Var)) == null) {
            return ya4.d().c(context, ss2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean e(Context context, qs2 qs2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, qs2Var, ps2Var, g63Var)) == null) {
            return wb4.h().c(context, qs2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean g(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, ss2Var, ps2Var, g63Var)) == null) {
            return ta4.e().c(context, ss2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean h(Context context, us2 us2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, us2Var, ps2Var, g63Var)) == null) {
            return bb4.e().c(context, us2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean j(Context context, vs2 vs2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, vs2Var, ps2Var, g63Var)) == null) {
            return cb4.e().c(context, vs2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean k(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, ss2Var, ps2Var, g63Var)) == null) {
            return wa4.d().c(context, ss2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean l(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, ss2Var, ps2Var, g63Var)) == null) {
            return ua4.d().c(context, ss2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean m(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, ss2Var, ps2Var, g63Var)) == null) {
            return ab4.f().c(context, ss2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean n(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, ss2Var, ps2Var, g63Var)) == null) {
            return xa4.d().c(context, ss2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public boolean o(Context context, ss2 ss2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, ss2Var, ps2Var, g63Var)) == null) {
            return va4.d().c(context, ss2Var, ps2Var, g63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hq2
    public void d(ns1 ns1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ns1Var) == null) {
            pa4.h(ns1Var);
        }
    }

    @Override // com.baidu.tieba.hq2
    public void f(ns1 ns1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ns1Var) == null) {
            pa4.d(ns1Var);
        }
    }

    @Override // com.baidu.tieba.hq2
    public void i(ns1 ns1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ns1Var) == null) {
            pa4.e(ns1Var);
        }
    }
}
