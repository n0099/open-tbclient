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
/* loaded from: classes7.dex */
public class nl3 implements gr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nl3() {
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

    @Override // com.baidu.tieba.hr3
    public void a(m63 m63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m63Var) == null) {
            m63Var.b(new fn3(m63Var));
            m63Var.b(new jn3(m63Var));
            m63Var.b(new do3(m63Var));
            m63Var.b(new co3(m63Var));
            m63Var.b(new sn3(m63Var));
            m63Var.b(new kn3(m63Var));
            m63Var.b(new hn3(m63Var));
            m63Var.b(new qn3(m63Var));
            m63Var.b(new gn3(m63Var));
            m63Var.b(new en3(m63Var));
            m63Var.b(new dn3(m63Var));
            m63Var.b(new in3(m63Var));
            m63Var.b(new ho3(m63Var));
        }
    }

    @Override // com.baidu.tieba.hr3
    @Nullable
    public Map<String, Object> b(@NonNull rt1 rt1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rt1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(rt1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hr3
    @Nullable
    public Map<String, Object> c(@NonNull rt1 rt1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rt1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(rt1Var);
        }
        return (Map) invokeL.objValue;
    }
}
