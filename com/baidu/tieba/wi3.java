package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.bdprivate.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Service
/* loaded from: classes6.dex */
public class wi3 implements po3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wi3() {
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

    @Override // com.baidu.tieba.qo3
    public void a(v33 v33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v33Var) == null) {
            v33Var.b(new ok3(v33Var));
            v33Var.b(new sk3(v33Var));
            v33Var.b(new ml3(v33Var));
            v33Var.b(new ll3(v33Var));
            v33Var.b(new bl3(v33Var));
            v33Var.b(new tk3(v33Var));
            v33Var.b(new qk3(v33Var));
            v33Var.b(new zk3(v33Var));
            v33Var.b(new pk3(v33Var));
            v33Var.b(new nk3(v33Var));
            v33Var.b(new mk3(v33Var));
            v33Var.b(new rk3(v33Var));
            v33Var.b(new ql3(v33Var));
        }
    }

    @Override // com.baidu.tieba.qo3
    @Nullable
    public Map<String, Object> b(@NonNull zq1 zq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zq1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(zq1Var) : (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qo3
    @Nullable
    public Map<String, Object> c(@NonNull zq1 zq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zq1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(zq1Var) : (Map) invokeL.objValue;
    }
}
