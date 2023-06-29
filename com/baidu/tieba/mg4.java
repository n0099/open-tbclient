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
public class mg4 implements dw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.dw2
    public boolean a(Context context, sy2 sy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, sy2Var, ly2Var, cc3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public mg4() {
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

    @Override // com.baidu.tieba.dw2
    public boolean b(Context context, ny2 ny2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ny2Var, ly2Var, cc3Var)) == null) {
            return vg4.e().c(context, ny2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean c(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, oy2Var, ly2Var, cc3Var)) == null) {
            return ug4.d().c(context, oy2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean e(Context context, my2 my2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, my2Var, ly2Var, cc3Var)) == null) {
            return sh4.h().c(context, my2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean g(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, oy2Var, ly2Var, cc3Var)) == null) {
            return pg4.e().c(context, oy2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean h(Context context, qy2 qy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, qy2Var, ly2Var, cc3Var)) == null) {
            return xg4.e().c(context, qy2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean j(Context context, ry2 ry2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, ry2Var, ly2Var, cc3Var)) == null) {
            return yg4.e().c(context, ry2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean k(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, oy2Var, ly2Var, cc3Var)) == null) {
            return sg4.d().c(context, oy2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean l(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, oy2Var, ly2Var, cc3Var)) == null) {
            return qg4.d().c(context, oy2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean m(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, oy2Var, ly2Var, cc3Var)) == null) {
            return wg4.f().c(context, oy2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean n(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, oy2Var, ly2Var, cc3Var)) == null) {
            return tg4.d().c(context, oy2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public boolean update(Context context, oy2 oy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, oy2Var, ly2Var, cc3Var)) == null) {
            return rg4.d().c(context, oy2Var, ly2Var, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.dw2
    public void d(iy1 iy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iy1Var) == null) {
            lg4.h(iy1Var);
        }
    }

    @Override // com.baidu.tieba.dw2
    public void f(iy1 iy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iy1Var) == null) {
            lg4.d(iy1Var);
        }
    }

    @Override // com.baidu.tieba.dw2
    public void i(iy1 iy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iy1Var) == null) {
            lg4.e(iy1Var);
        }
    }
}
