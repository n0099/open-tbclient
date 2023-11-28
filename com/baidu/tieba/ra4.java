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
/* loaded from: classes8.dex */
public class ra4 implements iq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.iq2
    public boolean a(Context context, xs2 xs2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xs2Var, qs2Var, h63Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public ra4() {
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

    @Override // com.baidu.tieba.iq2
    public boolean b(Context context, ss2 ss2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ss2Var, qs2Var, h63Var)) == null) {
            return ab4.e().c(context, ss2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean c(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ts2Var, qs2Var, h63Var)) == null) {
            return za4.d().c(context, ts2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean e(Context context, rs2 rs2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, rs2Var, qs2Var, h63Var)) == null) {
            return xb4.h().c(context, rs2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean g(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, ts2Var, qs2Var, h63Var)) == null) {
            return ua4.e().c(context, ts2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean h(Context context, vs2 vs2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, vs2Var, qs2Var, h63Var)) == null) {
            return cb4.e().c(context, vs2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean j(Context context, ws2 ws2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, ws2Var, qs2Var, h63Var)) == null) {
            return db4.e().c(context, ws2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean k(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, ts2Var, qs2Var, h63Var)) == null) {
            return xa4.d().c(context, ts2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean l(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, ts2Var, qs2Var, h63Var)) == null) {
            return va4.d().c(context, ts2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean m(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, ts2Var, qs2Var, h63Var)) == null) {
            return bb4.f().c(context, ts2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean n(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, ts2Var, qs2Var, h63Var)) == null) {
            return ya4.d().c(context, ts2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public boolean o(Context context, ts2 ts2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, ts2Var, qs2Var, h63Var)) == null) {
            return wa4.d().c(context, ts2Var, qs2Var, h63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.iq2
    public void d(os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, os1Var) == null) {
            qa4.h(os1Var);
        }
    }

    @Override // com.baidu.tieba.iq2
    public void f(os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, os1Var) == null) {
            qa4.d(os1Var);
        }
    }

    @Override // com.baidu.tieba.iq2
    public void i(os1 os1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, os1Var) == null) {
            qa4.e(os1Var);
        }
    }
}
