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
/* loaded from: classes7.dex */
public class na6 implements ww3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public na6() {
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

    @Override // com.baidu.tieba.yw3
    public void a(dc3 dc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dc3Var) == null) && dc3Var != null) {
            dc3Var.b(new pa6(dc3Var));
            dc3Var.b(new ia6(dc3Var));
            dc3Var.b(new ws3(dc3Var));
            dc3Var.b(new ys3(dc3Var));
            dc3Var.b(new at3(dc3Var));
            dc3Var.b(new ud3(dc3Var));
            dc3Var.b(new vd3(dc3Var));
            dc3Var.b(new vf3(dc3Var));
            dc3Var.b(new bt3(dc3Var));
            dc3Var.b(new yx1(dc3Var));
            dc3Var.b(new ma6(dc3Var));
        }
    }

    @Override // com.baidu.tieba.yw3
    @Nullable
    public Map<String, Object> b(@NonNull hz1 hz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(hz1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yw3
    @Nullable
    public Map<String, Object> c(@NonNull hz1 hz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hz1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(hz1Var);
        }
        return (Map) invokeL.objValue;
    }
}
