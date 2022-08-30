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
/* loaded from: classes4.dex */
public class j54 implements bl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j54() {
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

    @Override // com.baidu.tieba.bl2
    public boolean a(Context context, qn2 qn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, qn2Var, jn2Var, a13Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public boolean b(Context context, ln2 ln2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ln2Var, jn2Var, a13Var)) == null) ? s54.e().c(context, ln2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public boolean c(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, mn2Var, jn2Var, a13Var)) == null) ? r54.d().c(context, mn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public void d(gn1 gn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gn1Var) == null) {
            i54.h(gn1Var);
        }
    }

    @Override // com.baidu.tieba.bl2
    public boolean e(Context context, kn2 kn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, kn2Var, jn2Var, a13Var)) == null) ? p64.h().c(context, kn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public void f(gn1 gn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gn1Var) == null) {
            i54.d(gn1Var);
        }
    }

    @Override // com.baidu.tieba.bl2
    public boolean g(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, mn2Var, jn2Var, a13Var)) == null) ? m54.e().c(context, mn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public boolean h(Context context, on2 on2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, context, on2Var, jn2Var, a13Var)) == null) ? u54.e().c(context, on2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public void i(gn1 gn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gn1Var) == null) {
            i54.e(gn1Var);
        }
    }

    @Override // com.baidu.tieba.bl2
    public boolean j(Context context, pn2 pn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, context, pn2Var, jn2Var, a13Var)) == null) ? v54.e().c(context, pn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public boolean k(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, context, mn2Var, jn2Var, a13Var)) == null) ? p54.d().c(context, mn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public boolean l(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, context, mn2Var, jn2Var, a13Var)) == null) ? n54.d().c(context, mn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public boolean m(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, context, mn2Var, jn2Var, a13Var)) == null) ? t54.f().c(context, mn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public boolean n(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, context, mn2Var, jn2Var, a13Var)) == null) ? q54.d().c(context, mn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.bl2
    public boolean update(Context context, mn2 mn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, context, mn2Var, jn2Var, a13Var)) == null) ? o54.d().c(context, mn2Var, jn2Var, a13Var) : invokeLLLL.booleanValue;
    }
}
