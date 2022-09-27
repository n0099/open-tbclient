package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Singleton
@Service
/* loaded from: classes4.dex */
public class l04 implements qk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l04() {
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

    @Override // com.baidu.tieba.qk1
    public List<i53> a(i43 i43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i43Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new bz3(i43Var));
            arrayList.add(new cz3(i43Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qk1
    public List<i53> b(i43 i43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i43Var)) == null) ? Arrays.asList(new oz3(i43Var), new dy3(i43Var), new my3(i43Var), new zy3(i43Var)) : (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qk1
    public List<i53> c(i43 i43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i43Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new u34(i43Var));
            arrayList.add(new t34(i43Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
