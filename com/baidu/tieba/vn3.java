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
public class vn3 implements ot3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vn3() {
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

    @Override // com.baidu.tieba.pt3
    public void a(u83 u83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, u83Var) == null) {
            u83Var.b(new np3(u83Var));
            u83Var.b(new rp3(u83Var));
            u83Var.b(new lq3(u83Var));
            u83Var.b(new kq3(u83Var));
            u83Var.b(new aq3(u83Var));
            u83Var.b(new sp3(u83Var));
            u83Var.b(new pp3(u83Var));
            u83Var.b(new yp3(u83Var));
            u83Var.b(new op3(u83Var));
            u83Var.b(new mp3(u83Var));
            u83Var.b(new lp3(u83Var));
            u83Var.b(new qp3(u83Var));
            u83Var.b(new pq3(u83Var));
        }
    }

    @Override // com.baidu.tieba.pt3
    @Nullable
    public Map<String, Object> b(@NonNull yv1 yv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yv1Var)) == null) {
            return SwanApi$$ModulesProvider.getV8ApiModules(yv1Var);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pt3
    @Nullable
    public Map<String, Object> c(@NonNull yv1 yv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yv1Var)) == null) {
            return SwanApi$$ModulesProvider.getWebviewApiModules(yv1Var);
        }
        return (Map) invokeL.objValue;
    }
}
