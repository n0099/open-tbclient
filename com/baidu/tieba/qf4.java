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
public class qf4 implements hv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hv2
    public boolean a(Context context, wx2 wx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, wx2Var, px2Var, gb3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public qf4() {
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

    @Override // com.baidu.tieba.hv2
    public boolean b(Context context, rx2 rx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rx2Var, px2Var, gb3Var)) == null) {
            return zf4.e().c(context, rx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean c(Context context, sx2 sx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, sx2Var, px2Var, gb3Var)) == null) {
            return yf4.d().c(context, sx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean e(Context context, qx2 qx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, qx2Var, px2Var, gb3Var)) == null) {
            return wg4.h().c(context, qx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean g(Context context, sx2 sx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, sx2Var, px2Var, gb3Var)) == null) {
            return tf4.e().c(context, sx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean h(Context context, ux2 ux2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, ux2Var, px2Var, gb3Var)) == null) {
            return bg4.e().c(context, ux2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean j(Context context, vx2 vx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, vx2Var, px2Var, gb3Var)) == null) {
            return cg4.e().c(context, vx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean k(Context context, sx2 sx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, sx2Var, px2Var, gb3Var)) == null) {
            return wf4.d().c(context, sx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean l(Context context, sx2 sx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, sx2Var, px2Var, gb3Var)) == null) {
            return uf4.d().c(context, sx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean m(Context context, sx2 sx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, sx2Var, px2Var, gb3Var)) == null) {
            return ag4.f().c(context, sx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean n(Context context, sx2 sx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, sx2Var, px2Var, gb3Var)) == null) {
            return xf4.d().c(context, sx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public boolean update(Context context, sx2 sx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, sx2Var, px2Var, gb3Var)) == null) {
            return vf4.d().c(context, sx2Var, px2Var, gb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.hv2
    public void d(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mx1Var) == null) {
            pf4.h(mx1Var);
        }
    }

    @Override // com.baidu.tieba.hv2
    public void f(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mx1Var) == null) {
            pf4.d(mx1Var);
        }
    }

    @Override // com.baidu.tieba.hv2
    public void i(mx1 mx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mx1Var) == null) {
            pf4.e(mx1Var);
        }
    }
}
