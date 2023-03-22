package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes5.dex */
public class o16 implements jt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o16() {
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, q83Var) == null) && q83Var != null) {
            q83Var.b(new q16(q83Var));
            q83Var.b(new j16(q83Var));
            q83Var.b(new jp3(q83Var));
            q83Var.b(new lp3(q83Var));
            q83Var.b(new np3(q83Var));
            q83Var.b(new ha3(q83Var));
            q83Var.b(new ia3(q83Var));
            q83Var.b(new ic3(q83Var));
            q83Var.b(new op3(q83Var));
            q83Var.b(new lu1(q83Var));
            q83Var.b(new n16(q83Var));
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
