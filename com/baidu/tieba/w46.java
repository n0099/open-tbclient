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
/* loaded from: classes8.dex */
public class w46 implements fr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w46() {
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
        if ((interceptable == null || interceptable.invokeL(1048576, this, m63Var) == null) && m63Var != null) {
            m63Var.b(new y46(m63Var));
            m63Var.b(new r46(m63Var));
            m63Var.b(new fn3(m63Var));
            m63Var.b(new hn3(m63Var));
            m63Var.b(new jn3(m63Var));
            m63Var.b(new d83(m63Var));
            m63Var.b(new e83(m63Var));
            m63Var.b(new ea3(m63Var));
            m63Var.b(new kn3(m63Var));
            m63Var.b(new is1(m63Var));
            m63Var.b(new v46(m63Var));
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
