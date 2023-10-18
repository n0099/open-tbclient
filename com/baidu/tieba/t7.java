package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t7 implements l7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public short a;

    public t7(short s) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Short.valueOf(s)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = s;
    }

    @Override // com.baidu.tieba.l7
    public Object a(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, u8Var)) == null) {
            return Short.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.l7
    public Object b(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u8Var)) == null) {
            return Short.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.l7
    public Object c(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u8Var)) == null) {
            return Short.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.l7
    public Object d(u8 u8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, u8Var)) == null) {
            return Short.valueOf(this.a);
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
