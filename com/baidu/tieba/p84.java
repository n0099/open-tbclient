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
public class p84 implements go2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.go2
    public boolean a(Context context, vq2 vq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, vq2Var, oq2Var, f43Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public p84() {
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

    @Override // com.baidu.tieba.go2
    public boolean b(Context context, qq2 qq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qq2Var, oq2Var, f43Var)) == null) {
            return y84.e().c(context, qq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean c(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, rq2Var, oq2Var, f43Var)) == null) {
            return x84.d().c(context, rq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean e(Context context, pq2 pq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, pq2Var, oq2Var, f43Var)) == null) {
            return v94.h().c(context, pq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean g(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, rq2Var, oq2Var, f43Var)) == null) {
            return s84.e().c(context, rq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean h(Context context, tq2 tq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, tq2Var, oq2Var, f43Var)) == null) {
            return a94.e().c(context, tq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean j(Context context, uq2 uq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, uq2Var, oq2Var, f43Var)) == null) {
            return b94.e().c(context, uq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean k(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, rq2Var, oq2Var, f43Var)) == null) {
            return v84.d().c(context, rq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean l(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, rq2Var, oq2Var, f43Var)) == null) {
            return t84.d().c(context, rq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean m(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, rq2Var, oq2Var, f43Var)) == null) {
            return z84.f().c(context, rq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean n(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, rq2Var, oq2Var, f43Var)) == null) {
            return w84.d().c(context, rq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public boolean update(Context context, rq2 rq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, rq2Var, oq2Var, f43Var)) == null) {
            return u84.d().c(context, rq2Var, oq2Var, f43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.go2
    public void d(lq1 lq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lq1Var) == null) {
            o84.h(lq1Var);
        }
    }

    @Override // com.baidu.tieba.go2
    public void f(lq1 lq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lq1Var) == null) {
            o84.d(lq1Var);
        }
    }

    @Override // com.baidu.tieba.go2
    public void i(lq1 lq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lq1Var) == null) {
            o84.e(lq1Var);
        }
    }
}
