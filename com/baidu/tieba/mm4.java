package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class mm4 extends bl4<sm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.bl4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mm4(String str, qj4 qj4Var, bn4 bn4Var) {
        super(qj4Var, bn4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, qj4Var, bn4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qj4) objArr2[0], (bn4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: w */
    public sm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return cp4.i(this.d, jSONObject);
        }
        return (sm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: u */
    public boolean e(sm4 sm4Var) {
        InterceptResult invokeL;
        List<vk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sm4Var)) == null) {
            if (sm4Var == null || (list = sm4Var.a) == null) {
                return false;
            }
            for (vk4 vk4Var : list) {
                if (!vk4Var.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: v */
    public pk4 s(sm4 sm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sm4Var)) == null) {
            this.a.E();
            dp4 dp4Var = new dp4();
            o(sm4Var.a, dp4Var);
            if (dp4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(dp4Var);
            gl4.d(sm4Var, this.a);
            return null;
        }
        return (pk4) invokeL.objValue;
    }
}
