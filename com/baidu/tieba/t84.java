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
public class t84 implements ko2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ko2
    public boolean a(Context context, zq2 zq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, zq2Var, sq2Var, j43Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public t84() {
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

    @Override // com.baidu.tieba.ko2
    public boolean b(Context context, uq2 uq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, uq2Var, sq2Var, j43Var)) == null) {
            return c94.e().c(context, uq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean c(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, vq2Var, sq2Var, j43Var)) == null) {
            return b94.d().c(context, vq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean e(Context context, tq2 tq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, tq2Var, sq2Var, j43Var)) == null) {
            return z94.h().c(context, tq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean g(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, vq2Var, sq2Var, j43Var)) == null) {
            return w84.e().c(context, vq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean h(Context context, xq2 xq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, xq2Var, sq2Var, j43Var)) == null) {
            return e94.e().c(context, xq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean j(Context context, yq2 yq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, yq2Var, sq2Var, j43Var)) == null) {
            return f94.e().c(context, yq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean k(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, vq2Var, sq2Var, j43Var)) == null) {
            return z84.d().c(context, vq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean l(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, vq2Var, sq2Var, j43Var)) == null) {
            return x84.d().c(context, vq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean m(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, vq2Var, sq2Var, j43Var)) == null) {
            return d94.f().c(context, vq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean n(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, vq2Var, sq2Var, j43Var)) == null) {
            return a94.d().c(context, vq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public boolean update(Context context, vq2 vq2Var, sq2 sq2Var, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, vq2Var, sq2Var, j43Var)) == null) {
            return y84.d().c(context, vq2Var, sq2Var, j43Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ko2
    public void d(pq1 pq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pq1Var) == null) {
            s84.h(pq1Var);
        }
    }

    @Override // com.baidu.tieba.ko2
    public void f(pq1 pq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pq1Var) == null) {
            s84.d(pq1Var);
        }
    }

    @Override // com.baidu.tieba.ko2
    public void i(pq1 pq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pq1Var) == null) {
            s84.e(pq1Var);
        }
    }
}
