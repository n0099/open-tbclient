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
public class op5 implements pm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public op5() {
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

    @Override // com.baidu.tieba.rm3
    public void a(x13 x13Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, x13Var) == null) || x13Var == null) {
            return;
        }
        x13Var.b(new qp5(x13Var));
        x13Var.b(new jp5(x13Var));
        x13Var.b(new pi3(x13Var));
        x13Var.b(new ri3(x13Var));
        x13Var.b(new ti3(x13Var));
        x13Var.b(new o33(x13Var));
        x13Var.b(new p33(x13Var));
        x13Var.b(new p53(x13Var));
        x13Var.b(new ui3(x13Var));
        x13Var.b(new sn1(x13Var));
        x13Var.b(new np5(x13Var));
    }

    @Override // com.baidu.tieba.rm3
    @Nullable
    public Map<String, Object> b(@NonNull bp1 bp1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bp1Var)) == null) ? SwanApi$$ModulesProvider.getV8ApiModules(bp1Var) : (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rm3
    @Nullable
    public Map<String, Object> c(@NonNull bp1 bp1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bp1Var)) == null) ? SwanApi$$ModulesProvider.getWebviewApiModules(bp1Var) : (Map) invokeL.objValue;
    }
}
