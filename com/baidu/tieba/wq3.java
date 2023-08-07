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
/* loaded from: classes8.dex */
public class wq3 implements pw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wq3() {
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

    @Override // com.baidu.tieba.qw3
    public void a(vb3 vb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vb3Var) == null) {
            vb3Var.b(new os3(vb3Var));
            vb3Var.b(new ss3(vb3Var));
            vb3Var.b(new mt3(vb3Var));
            vb3Var.b(new lt3(vb3Var));
            vb3Var.b(new bt3(vb3Var));
            vb3Var.b(new ts3(vb3Var));
            vb3Var.b(new qs3(vb3Var));
            vb3Var.b(new zs3(vb3Var));
            vb3Var.b(new ps3(vb3Var));
            vb3Var.b(new ns3(vb3Var));
            vb3Var.b(new ms3(vb3Var));
            vb3Var.b(new rs3(vb3Var));
            vb3Var.b(new qt3(vb3Var));
        }
    }

    @Override // com.baidu.tieba.qw3
    @Nullable
    public Map<String, Object> b(@NonNull zy1 zy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zy1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(zy1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qw3
    @Nullable
    public Map<String, Object> c(@NonNull zy1 zy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zy1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(zy1Var);
        }
        return (Map) invokeL.objValue;
    }
}
