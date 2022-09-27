package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class s07 implements f07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g07 a;
    public e07 b;

    public s07(g07 g07Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g07Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = g07Var;
        this.b = new r07(this);
    }

    @Override // com.baidu.tieba.f07
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            e07 e07Var = this.b;
            if (e07Var != null) {
                return e07Var.a(bdUniqueId, str, str2, str3);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.f07
    public boolean b(int i, q07 q07Var) {
        InterceptResult invokeIL;
        g07 g07Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, q07Var)) == null) {
            if (q07Var == null || (g07Var = this.a) == null) {
                return false;
            }
            g07Var.setData(q07Var.getDataList());
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tieba.f07
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            g07 g07Var = this.a;
            if (g07Var != null) {
                g07Var.b(i);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.f07
    public void setData(List<Cdo> list) {
        g07 g07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (g07Var = this.a) == null) {
            return;
        }
        g07Var.setData(list);
    }
}
