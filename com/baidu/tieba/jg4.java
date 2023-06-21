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
public class jg4 implements aw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.aw2
    public boolean a(Context context, py2 py2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, py2Var, iy2Var, zb3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public jg4() {
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

    @Override // com.baidu.tieba.aw2
    public boolean b(Context context, ky2 ky2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ky2Var, iy2Var, zb3Var)) == null) {
            return sg4.e().c(context, ky2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean c(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ly2Var, iy2Var, zb3Var)) == null) {
            return rg4.d().c(context, ly2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean e(Context context, jy2 jy2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, jy2Var, iy2Var, zb3Var)) == null) {
            return ph4.h().c(context, jy2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean g(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, ly2Var, iy2Var, zb3Var)) == null) {
            return mg4.e().c(context, ly2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean h(Context context, ny2 ny2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, ny2Var, iy2Var, zb3Var)) == null) {
            return ug4.e().c(context, ny2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean j(Context context, oy2 oy2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, oy2Var, iy2Var, zb3Var)) == null) {
            return vg4.e().c(context, oy2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean k(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, ly2Var, iy2Var, zb3Var)) == null) {
            return pg4.d().c(context, ly2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean l(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, ly2Var, iy2Var, zb3Var)) == null) {
            return ng4.d().c(context, ly2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean m(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, ly2Var, iy2Var, zb3Var)) == null) {
            return tg4.f().c(context, ly2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean n(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, ly2Var, iy2Var, zb3Var)) == null) {
            return qg4.d().c(context, ly2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public boolean update(Context context, ly2 ly2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, ly2Var, iy2Var, zb3Var)) == null) {
            return og4.d().c(context, ly2Var, iy2Var, zb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.aw2
    public void d(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fy1Var) == null) {
            ig4.h(fy1Var);
        }
    }

    @Override // com.baidu.tieba.aw2
    public void f(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fy1Var) == null) {
            ig4.d(fy1Var);
        }
    }

    @Override // com.baidu.tieba.aw2
    public void i(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fy1Var) == null) {
            ig4.e(fy1Var);
        }
    }
}
