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
/* loaded from: classes6.dex */
public class im3 implements bs3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public im3() {
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

    @Override // com.baidu.tieba.cs3
    public void a(h73 h73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h73Var) == null) {
            h73Var.b(new ao3(h73Var));
            h73Var.b(new eo3(h73Var));
            h73Var.b(new yo3(h73Var));
            h73Var.b(new xo3(h73Var));
            h73Var.b(new no3(h73Var));
            h73Var.b(new fo3(h73Var));
            h73Var.b(new co3(h73Var));
            h73Var.b(new lo3(h73Var));
            h73Var.b(new bo3(h73Var));
            h73Var.b(new zn3(h73Var));
            h73Var.b(new yn3(h73Var));
            h73Var.b(new do3(h73Var));
            h73Var.b(new cp3(h73Var));
        }
    }

    @Override // com.baidu.tieba.cs3
    @Nullable
    public Map<String, Object> b(@NonNull mu1 mu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mu1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(mu1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.cs3
    @Nullable
    public Map<String, Object> c(@NonNull mu1 mu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mu1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(mu1Var);
        }
        return (Map) invokeL.objValue;
    }
}
