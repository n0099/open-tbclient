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
public class wd4 implements nt2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nt2
    public boolean a(Context context, cw2 cw2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, cw2Var, vv2Var, m93Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public wd4() {
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

    @Override // com.baidu.tieba.nt2
    public boolean b(Context context, xv2 xv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xv2Var, vv2Var, m93Var)) == null) {
            return fe4.e().c(context, xv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean c(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, yv2Var, vv2Var, m93Var)) == null) {
            return ee4.d().c(context, yv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean e(Context context, wv2 wv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, wv2Var, vv2Var, m93Var)) == null) {
            return cf4.h().c(context, wv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean g(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, yv2Var, vv2Var, m93Var)) == null) {
            return zd4.e().c(context, yv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean h(Context context, aw2 aw2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, aw2Var, vv2Var, m93Var)) == null) {
            return he4.e().c(context, aw2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean j(Context context, bw2 bw2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, bw2Var, vv2Var, m93Var)) == null) {
            return ie4.e().c(context, bw2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean k(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, yv2Var, vv2Var, m93Var)) == null) {
            return ce4.d().c(context, yv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean l(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, yv2Var, vv2Var, m93Var)) == null) {
            return ae4.d().c(context, yv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean m(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, yv2Var, vv2Var, m93Var)) == null) {
            return ge4.f().c(context, yv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean n(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, yv2Var, vv2Var, m93Var)) == null) {
            return de4.d().c(context, yv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public boolean update(Context context, yv2 yv2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, yv2Var, vv2Var, m93Var)) == null) {
            return be4.d().c(context, yv2Var, vv2Var, m93Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.nt2
    public void d(sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sv1Var) == null) {
            vd4.h(sv1Var);
        }
    }

    @Override // com.baidu.tieba.nt2
    public void f(sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sv1Var) == null) {
            vd4.d(sv1Var);
        }
    }

    @Override // com.baidu.tieba.nt2
    public void i(sv1 sv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sv1Var) == null) {
            vd4.e(sv1Var);
        }
    }
}
