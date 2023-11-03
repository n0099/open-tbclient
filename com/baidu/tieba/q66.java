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
public class q66 implements wr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q66() {
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

    @Override // com.baidu.tieba.yr3
    public void a(d73 d73Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, d73Var) == null) && d73Var != null) {
            d73Var.b(new s66(d73Var));
            d73Var.b(new l66(d73Var));
            d73Var.b(new wn3(d73Var));
            d73Var.b(new yn3(d73Var));
            d73Var.b(new ao3(d73Var));
            d73Var.b(new u83(d73Var));
            d73Var.b(new v83(d73Var));
            d73Var.b(new va3(d73Var));
            d73Var.b(new bo3(d73Var));
            d73Var.b(new zs1(d73Var));
            d73Var.b(new p66(d73Var));
        }
    }

    @Override // com.baidu.tieba.yr3
    @Nullable
    public Map<String, Object> b(@NonNull iu1 iu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iu1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(iu1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yr3
    @Nullable
    public Map<String, Object> c(@NonNull iu1 iu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iu1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(iu1Var);
        }
        return (Map) invokeL.objValue;
    }
}
