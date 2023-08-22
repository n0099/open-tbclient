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
/* loaded from: classes6.dex */
public class l96 implements tw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l96() {
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

    @Override // com.baidu.tieba.vw3
    public void a(ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ac3Var) == null) && ac3Var != null) {
            ac3Var.b(new n96(ac3Var));
            ac3Var.b(new g96(ac3Var));
            ac3Var.b(new ts3(ac3Var));
            ac3Var.b(new vs3(ac3Var));
            ac3Var.b(new xs3(ac3Var));
            ac3Var.b(new rd3(ac3Var));
            ac3Var.b(new sd3(ac3Var));
            ac3Var.b(new sf3(ac3Var));
            ac3Var.b(new ys3(ac3Var));
            ac3Var.b(new vx1(ac3Var));
            ac3Var.b(new k96(ac3Var));
        }
    }

    @Override // com.baidu.tieba.vw3
    @Nullable
    public Map<String, Object> b(@NonNull ez1 ez1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ez1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(ez1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vw3
    @Nullable
    public Map<String, Object> c(@NonNull ez1 ez1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ez1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(ez1Var);
        }
        return (Map) invokeL.objValue;
    }
}
