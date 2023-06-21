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
public class xr3 implements qx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xr3() {
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

    @Override // com.baidu.tieba.rx3
    public void a(wc3 wc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wc3Var) == null) {
            wc3Var.b(new pt3(wc3Var));
            wc3Var.b(new tt3(wc3Var));
            wc3Var.b(new nu3(wc3Var));
            wc3Var.b(new mu3(wc3Var));
            wc3Var.b(new cu3(wc3Var));
            wc3Var.b(new ut3(wc3Var));
            wc3Var.b(new rt3(wc3Var));
            wc3Var.b(new au3(wc3Var));
            wc3Var.b(new qt3(wc3Var));
            wc3Var.b(new ot3(wc3Var));
            wc3Var.b(new nt3(wc3Var));
            wc3Var.b(new st3(wc3Var));
            wc3Var.b(new ru3(wc3Var));
        }
    }

    @Override // com.baidu.tieba.rx3
    @Nullable
    public Map<String, Object> b(@NonNull a02 a02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a02Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(a02Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rx3
    @Nullable
    public Map<String, Object> c(@NonNull a02 a02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a02Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(a02Var);
        }
        return (Map) invokeL.objValue;
    }
}
