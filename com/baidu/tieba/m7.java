package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m7 implements l7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public m7(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
    }

    @Override // com.baidu.tieba.l7
    public Object a(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u8Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.l7
    public Object b(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u8Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.l7
    public Object c(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u8Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.l7
    public Object d(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, u8Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.l7
    public Object e(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, u8Var)) == null) {
            return d(u8Var);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.l7
    public Object f(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, u8Var)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
