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
/* loaded from: classes8.dex */
public class y96 implements sx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y96() {
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

    @Override // com.baidu.tieba.ux3
    public void a(zc3 zc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, zc3Var) == null) && zc3Var != null) {
            zc3Var.b(new aa6(zc3Var));
            zc3Var.b(new t96(zc3Var));
            zc3Var.b(new st3(zc3Var));
            zc3Var.b(new ut3(zc3Var));
            zc3Var.b(new wt3(zc3Var));
            zc3Var.b(new qe3(zc3Var));
            zc3Var.b(new re3(zc3Var));
            zc3Var.b(new rg3(zc3Var));
            zc3Var.b(new xt3(zc3Var));
            zc3Var.b(new uy1(zc3Var));
            zc3Var.b(new x96(zc3Var));
        }
    }

    @Override // com.baidu.tieba.ux3
    @Nullable
    public Map<String, Object> b(@NonNull d02 d02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d02Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(d02Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ux3
    @Nullable
    public Map<String, Object> c(@NonNull d02 d02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d02Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(d02Var);
        }
        return (Map) invokeL.objValue;
    }
}
