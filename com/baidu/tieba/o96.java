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
public class o96 implements ox3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o96() {
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

    @Override // com.baidu.tieba.qx3
    public void a(vc3 vc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, vc3Var) == null) && vc3Var != null) {
            vc3Var.b(new q96(vc3Var));
            vc3Var.b(new j96(vc3Var));
            vc3Var.b(new ot3(vc3Var));
            vc3Var.b(new qt3(vc3Var));
            vc3Var.b(new st3(vc3Var));
            vc3Var.b(new me3(vc3Var));
            vc3Var.b(new ne3(vc3Var));
            vc3Var.b(new ng3(vc3Var));
            vc3Var.b(new tt3(vc3Var));
            vc3Var.b(new qy1(vc3Var));
            vc3Var.b(new n96(vc3Var));
        }
    }

    @Override // com.baidu.tieba.qx3
    @Nullable
    public Map<String, Object> b(@NonNull zz1 zz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(zz1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qx3
    @Nullable
    public Map<String, Object> c(@NonNull zz1 zz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zz1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(zz1Var);
        }
        return (Map) invokeL.objValue;
    }
}
