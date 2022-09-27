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
/* loaded from: classes4.dex */
public class jj3 implements cp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jj3() {
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

    @Override // com.baidu.tieba.dp3
    public void a(i43 i43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i43Var) == null) {
            i43Var.b(new bl3(i43Var));
            i43Var.b(new fl3(i43Var));
            i43Var.b(new zl3(i43Var));
            i43Var.b(new yl3(i43Var));
            i43Var.b(new ol3(i43Var));
            i43Var.b(new gl3(i43Var));
            i43Var.b(new dl3(i43Var));
            i43Var.b(new ml3(i43Var));
            i43Var.b(new cl3(i43Var));
            i43Var.b(new al3(i43Var));
            i43Var.b(new zk3(i43Var));
            i43Var.b(new el3(i43Var));
            i43Var.b(new dm3(i43Var));
        }
    }

    @Override // com.baidu.tieba.dp3
    @Nullable
    public Map<String, Object> b(@NonNull mr1 mr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mr1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(mr1Var) : (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dp3
    @Nullable
    public Map<String, Object> c(@NonNull mr1 mr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mr1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(mr1Var) : (Map) invokeL.objValue;
    }
}
