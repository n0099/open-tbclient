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
public class nf4 implements ev2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ev2
    public boolean a(Context context, tx2 tx2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, tx2Var, mx2Var, db3Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public nf4() {
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

    @Override // com.baidu.tieba.ev2
    public boolean b(Context context, ox2 ox2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ox2Var, mx2Var, db3Var)) == null) {
            return wf4.e().c(context, ox2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean c(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, px2Var, mx2Var, db3Var)) == null) {
            return vf4.d().c(context, px2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean e(Context context, nx2 nx2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, nx2Var, mx2Var, db3Var)) == null) {
            return tg4.h().c(context, nx2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean g(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, px2Var, mx2Var, db3Var)) == null) {
            return qf4.e().c(context, px2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean h(Context context, rx2 rx2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, rx2Var, mx2Var, db3Var)) == null) {
            return yf4.e().c(context, rx2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean j(Context context, sx2 sx2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, sx2Var, mx2Var, db3Var)) == null) {
            return zf4.e().c(context, sx2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean k(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, px2Var, mx2Var, db3Var)) == null) {
            return tf4.d().c(context, px2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean l(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, px2Var, mx2Var, db3Var)) == null) {
            return rf4.d().c(context, px2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean m(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, px2Var, mx2Var, db3Var)) == null) {
            return xf4.f().c(context, px2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean n(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, px2Var, mx2Var, db3Var)) == null) {
            return uf4.d().c(context, px2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public boolean update(Context context, px2 px2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, px2Var, mx2Var, db3Var)) == null) {
            return sf4.d().c(context, px2Var, mx2Var, db3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ev2
    public void d(jx1 jx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jx1Var) == null) {
            mf4.h(jx1Var);
        }
    }

    @Override // com.baidu.tieba.ev2
    public void f(jx1 jx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jx1Var) == null) {
            mf4.d(jx1Var);
        }
    }

    @Override // com.baidu.tieba.ev2
    public void i(jx1 jx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jx1Var) == null) {
            mf4.e(jx1Var);
        }
    }
}
