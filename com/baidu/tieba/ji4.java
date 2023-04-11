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
/* loaded from: classes5.dex */
public class ji4 extends ah4<pi4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.ah4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ji4(String str, pf4 pf4Var, aj4 aj4Var) {
        super(pf4Var, aj4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, pf4Var, aj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((pf4) objArr2[0], (aj4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4
    /* renamed from: y */
    public pi4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return bl4.g(this.d, jSONObject);
        }
        return (pi4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4
    /* renamed from: w */
    public boolean s(pi4 pi4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, pi4Var, i)) == null) {
            if (pi4Var != null) {
                r(pi4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4
    /* renamed from: v */
    public boolean f(pi4 pi4Var) {
        InterceptResult invokeL;
        List<ug4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pi4Var)) == null) {
            if (pi4Var == null) {
                return false;
            }
            if (pi4Var.a == null && (((list = pi4Var.b) == null || list.isEmpty()) && pi4Var.d == null && pi4Var.f == null && pi4Var.e == null)) {
                return false;
            }
            tg4 tg4Var = pi4Var.a;
            if (tg4Var != null && !tg4Var.a()) {
                return false;
            }
            List<ug4> list2 = pi4Var.b;
            if (list2 != null) {
                for (ug4 ug4Var : list2) {
                    if (!ug4Var.a()) {
                        return false;
                    }
                }
            }
            rg4 rg4Var = pi4Var.d;
            if (rg4Var != null && !rg4Var.a()) {
                return false;
            }
            pg4 pg4Var = pi4Var.f;
            if (pg4Var != null && !pg4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = pi4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4
    /* renamed from: x */
    public og4 t(pi4 pi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pi4Var)) == null) {
            this.a.E();
            cl4 cl4Var = new cl4();
            o(pi4Var.a, cl4Var);
            p(pi4Var.b, cl4Var);
            n(g(pi4Var.c), cl4Var);
            m(pi4Var.d, cl4Var);
            l(pi4Var.f, cl4Var);
            r(pi4Var.e);
            if (cl4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(cl4Var);
            fh4.b(pi4Var, this.a);
            return null;
        }
        return (og4) invokeL.objValue;
    }
}
