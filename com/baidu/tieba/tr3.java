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
/* loaded from: classes8.dex */
public class tr3 implements mx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tr3() {
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

    @Override // com.baidu.tieba.nx3
    public void a(sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sc3Var) == null) {
            sc3Var.b(new lt3(sc3Var));
            sc3Var.b(new pt3(sc3Var));
            sc3Var.b(new ju3(sc3Var));
            sc3Var.b(new iu3(sc3Var));
            sc3Var.b(new yt3(sc3Var));
            sc3Var.b(new qt3(sc3Var));
            sc3Var.b(new nt3(sc3Var));
            sc3Var.b(new wt3(sc3Var));
            sc3Var.b(new mt3(sc3Var));
            sc3Var.b(new kt3(sc3Var));
            sc3Var.b(new jt3(sc3Var));
            sc3Var.b(new ot3(sc3Var));
            sc3Var.b(new nu3(sc3Var));
        }
    }

    @Override // com.baidu.tieba.nx3
    @Nullable
    public Map<String, Object> b(@NonNull wz1 wz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(wz1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nx3
    @Nullable
    public Map<String, Object> c(@NonNull wz1 wz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wz1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(wz1Var);
        }
        return (Map) invokeL.objValue;
    }
}
