package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class km4 extends bl4<qm4> {
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
    public km4(String str, qj4 qj4Var, bn4 bn4Var) {
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
    /* renamed from: x */
    public qm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return cp4.g(this.d, jSONObject);
        }
        return (qm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: v */
    public boolean r(qm4 qm4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, qm4Var, i)) == null) {
            if (qm4Var != null) {
                q(qm4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: u */
    public boolean e(qm4 qm4Var) {
        InterceptResult invokeL;
        List<vk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qm4Var)) == null) {
            if (qm4Var == null) {
                return false;
            }
            if (qm4Var.a == null && (((list = qm4Var.b) == null || list.isEmpty()) && qm4Var.d == null && qm4Var.f == null && qm4Var.e == null)) {
                return false;
            }
            uk4 uk4Var = qm4Var.a;
            if (uk4Var != null && !uk4Var.a()) {
                return false;
            }
            List<vk4> list2 = qm4Var.b;
            if (list2 != null) {
                for (vk4 vk4Var : list2) {
                    if (!vk4Var.a()) {
                        return false;
                    }
                }
            }
            sk4 sk4Var = qm4Var.d;
            if (sk4Var != null && !sk4Var.a()) {
                return false;
            }
            qk4 qk4Var = qm4Var.f;
            if (qk4Var != null && !qk4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = qm4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: w */
    public pk4 s(qm4 qm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qm4Var)) == null) {
            this.a.E();
            dp4 dp4Var = new dp4();
            n(qm4Var.a, dp4Var);
            o(qm4Var.b, dp4Var);
            m(f(qm4Var.c), dp4Var);
            l(qm4Var.d, dp4Var);
            k(qm4Var.f, dp4Var);
            q(qm4Var.e);
            if (dp4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(dp4Var);
            gl4.b(qm4Var, this.a);
            return null;
        }
        return (pk4) invokeL.objValue;
    }
}
