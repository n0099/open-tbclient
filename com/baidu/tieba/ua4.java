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
public class ua4 implements lq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lq2
    public boolean a(Context context, at2 at2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, at2Var, ts2Var, k63Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public ua4() {
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

    @Override // com.baidu.tieba.lq2
    public boolean b(Context context, vs2 vs2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vs2Var, ts2Var, k63Var)) == null) {
            return db4.e().c(context, vs2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean c(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ws2Var, ts2Var, k63Var)) == null) {
            return cb4.d().c(context, ws2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean e(Context context, us2 us2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, us2Var, ts2Var, k63Var)) == null) {
            return ac4.h().c(context, us2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean g(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, ws2Var, ts2Var, k63Var)) == null) {
            return xa4.e().c(context, ws2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean h(Context context, ys2 ys2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, ys2Var, ts2Var, k63Var)) == null) {
            return fb4.e().c(context, ys2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean j(Context context, zs2 zs2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, zs2Var, ts2Var, k63Var)) == null) {
            return gb4.e().c(context, zs2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean k(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, ws2Var, ts2Var, k63Var)) == null) {
            return ab4.d().c(context, ws2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean l(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, ws2Var, ts2Var, k63Var)) == null) {
            return ya4.d().c(context, ws2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean m(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, ws2Var, ts2Var, k63Var)) == null) {
            return eb4.f().c(context, ws2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean n(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, ws2Var, ts2Var, k63Var)) == null) {
            return bb4.d().c(context, ws2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public boolean o(Context context, ws2 ws2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, ws2Var, ts2Var, k63Var)) == null) {
            return za4.d().c(context, ws2Var, ts2Var, k63Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.lq2
    public void d(rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rs1Var) == null) {
            ta4.h(rs1Var);
        }
    }

    @Override // com.baidu.tieba.lq2
    public void f(rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rs1Var) == null) {
            ta4.d(rs1Var);
        }
    }

    @Override // com.baidu.tieba.lq2
    public void i(rs1 rs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rs1Var) == null) {
            ta4.e(rs1Var);
        }
    }
}
