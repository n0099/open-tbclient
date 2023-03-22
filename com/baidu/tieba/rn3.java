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
public class rn3 implements kt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rn3() {
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

    @Override // com.baidu.tieba.lt3
    public void a(q83 q83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q83Var) == null) {
            q83Var.b(new jp3(q83Var));
            q83Var.b(new np3(q83Var));
            q83Var.b(new hq3(q83Var));
            q83Var.b(new gq3(q83Var));
            q83Var.b(new wp3(q83Var));
            q83Var.b(new op3(q83Var));
            q83Var.b(new lp3(q83Var));
            q83Var.b(new up3(q83Var));
            q83Var.b(new kp3(q83Var));
            q83Var.b(new ip3(q83Var));
            q83Var.b(new hp3(q83Var));
            q83Var.b(new mp3(q83Var));
            q83Var.b(new lq3(q83Var));
        }
    }

    @Override // com.baidu.tieba.lt3
    @Nullable
    public Map<String, Object> b(@NonNull uv1 uv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uv1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(uv1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lt3
    @Nullable
    public Map<String, Object> c(@NonNull uv1 uv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uv1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(uv1Var);
        }
        return (Map) invokeL.objValue;
    }
}
