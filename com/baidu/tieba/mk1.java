package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mk1<T> implements ok1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;
    public lk1<T> b;
    public lk1<T> c;

    public mk1() {
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

    public static mk1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new mk1();
        }
        return (mk1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ok1
    public T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = this.a;
            if (t != null) {
                return t;
            }
            lk1<T> lk1Var = this.b;
            if (lk1Var != null) {
                T t2 = lk1Var.get();
                this.a = t2;
                return t2;
            }
            lk1<T> lk1Var2 = this.c;
            if (lk1Var2 != null) {
                return lk1Var2.get();
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ok1
    public void a(lk1<T> lk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lk1Var) == null) {
            this.b = lk1Var;
            this.a = null;
        }
    }
}
