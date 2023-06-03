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
/* loaded from: classes7.dex */
public class nm4 extends el4<tm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.el4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm4(String str, tj4 tj4Var, en4 en4Var) {
        super(tj4Var, en4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, tj4Var, en4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((tj4) objArr2[0], (en4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.el4
    /* renamed from: x */
    public tm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return fp4.g(this.d, jSONObject);
        }
        return (tm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.el4
    /* renamed from: v */
    public boolean r(tm4 tm4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, tm4Var, i)) == null) {
            if (tm4Var != null) {
                q(tm4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.el4
    /* renamed from: u */
    public boolean e(tm4 tm4Var) {
        InterceptResult invokeL;
        List<yk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tm4Var)) == null) {
            if (tm4Var == null) {
                return false;
            }
            if (tm4Var.a == null && (((list = tm4Var.b) == null || list.isEmpty()) && tm4Var.d == null && tm4Var.f == null && tm4Var.e == null)) {
                return false;
            }
            xk4 xk4Var = tm4Var.a;
            if (xk4Var != null && !xk4Var.a()) {
                return false;
            }
            List<yk4> list2 = tm4Var.b;
            if (list2 != null) {
                for (yk4 yk4Var : list2) {
                    if (!yk4Var.a()) {
                        return false;
                    }
                }
            }
            vk4 vk4Var = tm4Var.d;
            if (vk4Var != null && !vk4Var.a()) {
                return false;
            }
            tk4 tk4Var = tm4Var.f;
            if (tk4Var != null && !tk4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = tm4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.el4
    /* renamed from: w */
    public sk4 s(tm4 tm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tm4Var)) == null) {
            this.a.E();
            gp4 gp4Var = new gp4();
            n(tm4Var.a, gp4Var);
            o(tm4Var.b, gp4Var);
            m(f(tm4Var.c), gp4Var);
            l(tm4Var.d, gp4Var);
            k(tm4Var.f, gp4Var);
            q(tm4Var.e);
            if (gp4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(gp4Var);
            jl4.b(tm4Var, this.a);
            return null;
        }
        return (sk4) invokeL.objValue;
    }
}
