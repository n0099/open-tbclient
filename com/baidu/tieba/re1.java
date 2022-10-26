package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class re1 implements te1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;
    public qe1 b;
    public qe1 c;

    public re1() {
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

    public static re1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new re1();
        }
        return (re1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.te1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.a;
            if (obj != null) {
                return obj;
            }
            qe1 qe1Var = this.b;
            if (qe1Var != null) {
                Object obj2 = qe1Var.get();
                this.a = obj2;
                return obj2;
            }
            qe1 qe1Var2 = this.c;
            if (qe1Var2 != null) {
                return qe1Var2.get();
            }
            return null;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.te1
    public void a(qe1 qe1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qe1Var) == null) {
            this.b = qe1Var;
            this.a = null;
        }
    }
}
