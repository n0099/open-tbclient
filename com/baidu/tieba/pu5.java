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
public class pu5 implements vp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pu5() {
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

    @Override // com.baidu.tieba.xp3
    public void a(c53 c53Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, c53Var) == null) && c53Var != null) {
            c53Var.b(new ru5(c53Var));
            c53Var.b(new ku5(c53Var));
            c53Var.b(new vl3(c53Var));
            c53Var.b(new xl3(c53Var));
            c53Var.b(new zl3(c53Var));
            c53Var.b(new t63(c53Var));
            c53Var.b(new u63(c53Var));
            c53Var.b(new u83(c53Var));
            c53Var.b(new am3(c53Var));
            c53Var.b(new xq1(c53Var));
            c53Var.b(new ou5(c53Var));
        }
    }

    @Override // com.baidu.tieba.xp3
    @Nullable
    public Map<String, Object> b(@NonNull gs1 gs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gs1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(gs1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xp3
    @Nullable
    public Map<String, Object> c(@NonNull gs1 gs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gs1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(gs1Var);
        }
        return (Map) invokeL.objValue;
    }
}
