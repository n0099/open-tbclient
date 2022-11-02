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
/* loaded from: classes5.dex */
public class o84 implements fo2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.fo2
    public boolean a(Context context, uq2 uq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, uq2Var, nq2Var, e43Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public o84() {
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

    @Override // com.baidu.tieba.fo2
    public boolean b(Context context, pq2 pq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pq2Var, nq2Var, e43Var)) == null) {
            return x84.e().c(context, pq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean c(Context context, qq2 qq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, qq2Var, nq2Var, e43Var)) == null) {
            return w84.d().c(context, qq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean e(Context context, oq2 oq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, oq2Var, nq2Var, e43Var)) == null) {
            return u94.h().c(context, oq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean g(Context context, qq2 qq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, qq2Var, nq2Var, e43Var)) == null) {
            return r84.e().c(context, qq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean h(Context context, sq2 sq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, sq2Var, nq2Var, e43Var)) == null) {
            return z84.e().c(context, sq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean j(Context context, tq2 tq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, tq2Var, nq2Var, e43Var)) == null) {
            return a94.e().c(context, tq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean k(Context context, qq2 qq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, qq2Var, nq2Var, e43Var)) == null) {
            return u84.d().c(context, qq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean l(Context context, qq2 qq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, qq2Var, nq2Var, e43Var)) == null) {
            return s84.d().c(context, qq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean m(Context context, qq2 qq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, qq2Var, nq2Var, e43Var)) == null) {
            return y84.f().c(context, qq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean n(Context context, qq2 qq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, qq2Var, nq2Var, e43Var)) == null) {
            return v84.d().c(context, qq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public boolean update(Context context, qq2 qq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, qq2Var, nq2Var, e43Var)) == null) {
            return t84.d().c(context, qq2Var, nq2Var, e43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.fo2
    public void d(kq1 kq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kq1Var) == null) {
            n84.h(kq1Var);
        }
    }

    @Override // com.baidu.tieba.fo2
    public void f(kq1 kq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kq1Var) == null) {
            n84.d(kq1Var);
        }
    }

    @Override // com.baidu.tieba.fo2
    public void i(kq1 kq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kq1Var) == null) {
            n84.e(kq1Var);
        }
    }
}
