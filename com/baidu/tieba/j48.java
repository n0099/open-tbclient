package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class j48 implements w38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x38 a;
    public v38 b;

    public j48(x38 x38Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x38Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = x38Var;
        this.b = new i48(this);
    }

    @Override // com.baidu.tieba.w38
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            v38 v38Var = this.b;
            if (v38Var != null) {
                return v38Var.a(bdUniqueId, str, str2, str3);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.w38
    public boolean b(int i, h48 h48Var) {
        InterceptResult invokeIL;
        x38 x38Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, h48Var)) == null) {
            if (h48Var != null && (x38Var = this.a) != null) {
                x38Var.setData(h48Var.getDataList());
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.w38
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            x38 x38Var = this.a;
            if (x38Var != null) {
                x38Var.b(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.w38
    public void setData(List<yn> list) {
        x38 x38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && (x38Var = this.a) != null) {
            x38Var.setData(list);
        }
    }
}
