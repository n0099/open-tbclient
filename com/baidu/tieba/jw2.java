package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class jw2<ValueT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ValueT a;

    public abstract ValueT c(Bundle bundle, String str, ValueT valuet);

    public abstract void e(Bundle bundle, String str, ValueT valuet);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jw2() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public jw2(ValueT valuet) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {valuet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = valuet;
    }

    public ValueT a(kw2 kw2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kw2Var, str)) == null) {
            return b(kw2Var, str, this.a);
        }
        return (ValueT) invokeLL.objValue;
    }

    public ValueT b(kw2 kw2Var, String str, ValueT valuet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kw2Var, str, valuet)) == null) {
            return c(kw2Var.C(), str, valuet);
        }
        return (ValueT) invokeLLL.objValue;
    }

    public void d(kw2 kw2Var, String str, ValueT valuet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, kw2Var, str, valuet) == null) {
            e(kw2Var.C(), str, valuet);
        }
    }
}
