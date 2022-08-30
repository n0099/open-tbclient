package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vc implements nc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public short a;

    public vc(short s) {
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

    @Override // com.baidu.tieba.nc
    public Object a(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, deVar)) == null) ? Short.valueOf(this.a) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object b(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, deVar)) == null) ? Short.valueOf(this.a) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object c(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, deVar)) == null) ? Short.valueOf(this.a) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object d(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, deVar)) == null) ? Short.valueOf(this.a) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object e(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, deVar)) == null) ? d(deVar) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.nc
    public Object f(de deVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, deVar)) == null) ? Integer.valueOf(this.a) : invokeL.objValue;
    }
}
