package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kd implements cd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public short a;

    public kd(short s) {
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

    @Override // com.baidu.tieba.cd
    public Object a(se seVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, seVar)) == null) {
            return Short.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object b(se seVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seVar)) == null) {
            return Short.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object c(se seVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seVar)) == null) {
            return Short.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object d(se seVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, seVar)) == null) {
            return Short.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object e(se seVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, seVar)) == null) {
            return d(seVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.cd
    public Object f(se seVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, seVar)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
