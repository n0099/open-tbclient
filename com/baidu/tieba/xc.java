package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xc implements wc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public xc(int i) {
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

    @Override // com.baidu.tieba.wc
    public Object a(fe feVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, feVar)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.wc
    public Object b(fe feVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, feVar)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.wc
    public Object c(fe feVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, feVar)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.wc
    public Object d(fe feVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, feVar)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.wc
    public Object e(fe feVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, feVar)) == null) {
            return d(feVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.wc
    public Object f(fe feVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, feVar)) == null) {
            return Integer.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
