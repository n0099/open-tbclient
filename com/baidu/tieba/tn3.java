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
public class tn3 implements mt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tn3() {
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

    @Override // com.baidu.tieba.nt3
    public void a(s83 s83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s83Var) == null) {
            s83Var.b(new lp3(s83Var));
            s83Var.b(new pp3(s83Var));
            s83Var.b(new jq3(s83Var));
            s83Var.b(new iq3(s83Var));
            s83Var.b(new yp3(s83Var));
            s83Var.b(new qp3(s83Var));
            s83Var.b(new np3(s83Var));
            s83Var.b(new wp3(s83Var));
            s83Var.b(new mp3(s83Var));
            s83Var.b(new kp3(s83Var));
            s83Var.b(new jp3(s83Var));
            s83Var.b(new op3(s83Var));
            s83Var.b(new nq3(s83Var));
        }
    }

    @Override // com.baidu.tieba.nt3
    @Nullable
    public Map<String, Object> b(@NonNull wv1 wv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wv1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(wv1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.nt3
    @Nullable
    public Map<String, Object> c(@NonNull wv1 wv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wv1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(wv1Var);
        }
        return (Map) invokeL.objValue;
    }
}
