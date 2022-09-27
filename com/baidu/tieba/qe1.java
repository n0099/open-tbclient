package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qe1<T> implements se1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;
    public pe1<T> b;
    public pe1<T> c;

    public qe1() {
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

    public static qe1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new qe1() : (qe1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.se1
    public void a(pe1<T> pe1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pe1Var) == null) {
            this.b = pe1Var;
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.se1
    public T get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = this.a;
            if (t != null) {
                return t;
            }
            pe1<T> pe1Var = this.b;
            if (pe1Var != null) {
                T t2 = pe1Var.get();
                this.a = t2;
                return t2;
            }
            pe1<T> pe1Var2 = this.c;
            if (pe1Var2 != null) {
                return pe1Var2.get();
            }
            return null;
        }
        return (T) invokeV.objValue;
    }
}
