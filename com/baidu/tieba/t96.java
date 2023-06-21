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
public class t96 implements px3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t96() {
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, wc3Var) == null) && wc3Var != null) {
            wc3Var.b(new v96(wc3Var));
            wc3Var.b(new o96(wc3Var));
            wc3Var.b(new pt3(wc3Var));
            wc3Var.b(new rt3(wc3Var));
            wc3Var.b(new tt3(wc3Var));
            wc3Var.b(new ne3(wc3Var));
            wc3Var.b(new oe3(wc3Var));
            wc3Var.b(new og3(wc3Var));
            wc3Var.b(new ut3(wc3Var));
            wc3Var.b(new ry1(wc3Var));
            wc3Var.b(new s96(wc3Var));
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
