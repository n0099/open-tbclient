package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class kf1<T> implements mf1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> a;
    public if1<List<T>> b;
    public if1<List<T>> c;

    public kf1() {
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

    public static kf1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new kf1();
        }
        return (kf1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mf1
    public List<T> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<T> list = this.a;
            if (list != null) {
                return list;
            }
            if1<List<T>> if1Var = this.b;
            if (if1Var != null) {
                List<T> list2 = if1Var.get();
                this.a = list2;
                return list2;
            }
            if1<List<T>> if1Var2 = this.c;
            if (if1Var2 != null) {
                return if1Var2.get();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mf1
    public void a(if1<List<T>> if1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, if1Var) == null) {
            this.b = if1Var;
            this.a = null;
        }
    }
}
