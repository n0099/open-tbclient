package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class m04 implements rk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m04() {
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

    @Override // com.baidu.tieba.rk1
    public List a(j43 j43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j43Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new cz3(j43Var));
            arrayList.add(new dz3(j43Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rk1
    public List c(j43 j43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j43Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new v34(j43Var));
            arrayList.add(new u34(j43Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rk1
    public List b(j43 j43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j43Var)) == null) {
            return Arrays.asList(new pz3(j43Var), new ey3(j43Var), new ny3(j43Var), new az3(j43Var));
        }
        return (List) invokeL.objValue;
    }
}
