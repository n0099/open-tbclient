package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class zc implements bd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;

    public zc(double d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d;
    }

    @Override // com.baidu.tieba.bd
    public Object a(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, reVar)) == null) ? Double.valueOf(this.a) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object b(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reVar)) == null) ? Double.valueOf(this.a) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object c(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, reVar)) == null) ? Double.valueOf(this.a) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object d(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, reVar)) == null) ? Double.valueOf(this.a) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object e(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, reVar)) == null) ? d(reVar) : invokeL.objValue;
    }

    @Override // com.baidu.tieba.bd
    public Object f(re reVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, reVar)) == null) ? Double.valueOf(this.a) : invokeL.objValue;
    }
}
