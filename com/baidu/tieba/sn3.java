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
public class sn3 implements lt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sn3() {
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

    @Override // com.baidu.tieba.mt3
    public void a(r83 r83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r83Var) == null) {
            r83Var.b(new kp3(r83Var));
            r83Var.b(new op3(r83Var));
            r83Var.b(new iq3(r83Var));
            r83Var.b(new hq3(r83Var));
            r83Var.b(new xp3(r83Var));
            r83Var.b(new pp3(r83Var));
            r83Var.b(new mp3(r83Var));
            r83Var.b(new vp3(r83Var));
            r83Var.b(new lp3(r83Var));
            r83Var.b(new jp3(r83Var));
            r83Var.b(new ip3(r83Var));
            r83Var.b(new np3(r83Var));
            r83Var.b(new mq3(r83Var));
        }
    }

    @Override // com.baidu.tieba.mt3
    @Nullable
    public Map<String, Object> b(@NonNull vv1 vv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vv1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(vv1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mt3
    @Nullable
    public Map<String, Object> c(@NonNull vv1 vv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vv1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(vv1Var);
        }
        return (Map) invokeL.objValue;
    }
}
