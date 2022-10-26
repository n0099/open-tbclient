package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class kj3 implements dp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kj3() {
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

    @Override // com.baidu.tieba.ep3
    public void a(j43 j43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, j43Var) == null) {
            j43Var.b(new cl3(j43Var));
            j43Var.b(new gl3(j43Var));
            j43Var.b(new am3(j43Var));
            j43Var.b(new zl3(j43Var));
            j43Var.b(new pl3(j43Var));
            j43Var.b(new hl3(j43Var));
            j43Var.b(new el3(j43Var));
            j43Var.b(new nl3(j43Var));
            j43Var.b(new dl3(j43Var));
            j43Var.b(new bl3(j43Var));
            j43Var.b(new al3(j43Var));
            j43Var.b(new fl3(j43Var));
            j43Var.b(new em3(j43Var));
        }
    }

    @Override // com.baidu.tieba.ep3
    public Map b(nr1 nr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nr1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(nr1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ep3
    public Map c(nr1 nr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nr1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(nr1Var);
        }
        return (Map) invokeL.objValue;
    }
}
