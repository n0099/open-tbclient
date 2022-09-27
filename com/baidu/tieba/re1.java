package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class re1<T> implements te1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public pe1<List<T>> b;
    public pe1<List<T>> c;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new re1() : (re1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.te1
    public void a(pe1<List<T>> pe1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pe1Var) == null) {
            this.b = pe1Var;
            this.a = null;
        }
    }

    @Override // com.baidu.tieba.te1
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.a;
            if (list != null) {
                return list;
            }
            pe1<List<T>> pe1Var = this.b;
            if (pe1Var != null) {
                List<T> list2 = pe1Var.get();
                this.a = list2;
                return list2;
            }
            pe1<List<T>> pe1Var2 = this.c;
            if (pe1Var2 != null) {
                return pe1Var2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }
}
