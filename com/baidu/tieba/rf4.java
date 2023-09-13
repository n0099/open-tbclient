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
public class rf4 implements iv2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.iv2
    public boolean a(Context context, xx2 xx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xx2Var, qx2Var, hb3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public rf4() {
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

    @Override // com.baidu.tieba.iv2
    public boolean b(Context context, sx2 sx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sx2Var, qx2Var, hb3Var)) == null) {
            return ag4.e().c(context, sx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean c(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tx2Var, qx2Var, hb3Var)) == null) {
            return zf4.d().c(context, tx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean e(Context context, rx2 rx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, rx2Var, qx2Var, hb3Var)) == null) {
            return xg4.h().c(context, rx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean g(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, tx2Var, qx2Var, hb3Var)) == null) {
            return uf4.e().c(context, tx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean h(Context context, vx2 vx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, vx2Var, qx2Var, hb3Var)) == null) {
            return cg4.e().c(context, vx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean j(Context context, wx2 wx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, wx2Var, qx2Var, hb3Var)) == null) {
            return dg4.e().c(context, wx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean k(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, tx2Var, qx2Var, hb3Var)) == null) {
            return xf4.d().c(context, tx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean l(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, tx2Var, qx2Var, hb3Var)) == null) {
            return vf4.d().c(context, tx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean m(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, tx2Var, qx2Var, hb3Var)) == null) {
            return bg4.f().c(context, tx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean n(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, tx2Var, qx2Var, hb3Var)) == null) {
            return yf4.d().c(context, tx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public boolean update(Context context, tx2 tx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, tx2Var, qx2Var, hb3Var)) == null) {
            return wf4.d().c(context, tx2Var, qx2Var, hb3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iv2
    public void d(nx1 nx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nx1Var) == null) {
            qf4.h(nx1Var);
        }
    }

    @Override // com.baidu.tieba.iv2
    public void f(nx1 nx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nx1Var) == null) {
            qf4.d(nx1Var);
        }
    }

    @Override // com.baidu.tieba.iv2
    public void i(nx1 nx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nx1Var) == null) {
            qf4.e(nx1Var);
        }
    }
}
