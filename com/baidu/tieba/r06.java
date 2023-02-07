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
public class r06 implements mu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r06() {
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

    @Override // com.baidu.tieba.ou3
    public void a(t93 t93Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, t93Var) == null) && t93Var != null) {
            t93Var.b(new t06(t93Var));
            t93Var.b(new m06(t93Var));
            t93Var.b(new mq3(t93Var));
            t93Var.b(new oq3(t93Var));
            t93Var.b(new qq3(t93Var));
            t93Var.b(new kb3(t93Var));
            t93Var.b(new lb3(t93Var));
            t93Var.b(new ld3(t93Var));
            t93Var.b(new rq3(t93Var));
            t93Var.b(new ov1(t93Var));
            t93Var.b(new q06(t93Var));
        }
    }

    @Override // com.baidu.tieba.ou3
    @Nullable
    public Map<String, Object> b(@NonNull xw1 xw1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xw1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(xw1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ou3
    @Nullable
    public Map<String, Object> c(@NonNull xw1 xw1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xw1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(xw1Var);
        }
        return (Map) invokeL.objValue;
    }
}
