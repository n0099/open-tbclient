package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kc implements mc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;

    public kc(double d) {
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

    @Override // com.baidu.tieba.mc
    public Object a(vd vdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vdVar)) == null) {
            return Double.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.mc
    public Object b(vd vdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vdVar)) == null) {
            return Double.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.mc
    public Object c(vd vdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vdVar)) == null) {
            return Double.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.mc
    public Object d(vd vdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vdVar)) == null) {
            return Double.valueOf(this.a);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.mc
    public Object e(vd vdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vdVar)) == null) {
            return d(vdVar);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.mc
    public Object f(vd vdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vdVar)) == null) {
            return Double.valueOf(this.a);
        }
        return invokeL.objValue;
    }
}
