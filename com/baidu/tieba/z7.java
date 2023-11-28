package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class z7 implements c8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public char a;

    public z7(char c) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Character.valueOf(c)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c;
    }

    @Override // com.baidu.tieba.c8
    public Object a(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l9Var)) == null) {
            return String.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.c8
    public Object b(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l9Var)) == null) {
            return Character.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.c8
    public Object c(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l9Var)) == null) {
            return Character.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.c8
    public Object d(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, l9Var)) == null) {
            return Character.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.c8
    public Object e(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, l9Var)) == null) {
            return d(l9Var);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.c8
    public Object f(l9 l9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, l9Var)) == null) {
            return String.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
