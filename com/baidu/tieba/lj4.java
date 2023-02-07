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
public class lj4 extends ci4<rj4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.ci4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lj4(String str, rg4 rg4Var, ck4 ck4Var) {
        super(rg4Var, ck4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, rg4Var, ck4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((rg4) objArr2[0], (ck4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci4
    /* renamed from: y */
    public rj4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return dm4.g(this.d, jSONObject);
        }
        return (rj4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci4
    /* renamed from: w */
    public boolean s(rj4 rj4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, rj4Var, i)) == null) {
            if (rj4Var != null) {
                r(rj4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci4
    /* renamed from: v */
    public boolean f(rj4 rj4Var) {
        InterceptResult invokeL;
        List<wh4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rj4Var)) == null) {
            if (rj4Var == null) {
                return false;
            }
            if (rj4Var.a == null && (((list = rj4Var.b) == null || list.isEmpty()) && rj4Var.d == null && rj4Var.f == null && rj4Var.e == null)) {
                return false;
            }
            vh4 vh4Var = rj4Var.a;
            if (vh4Var != null && !vh4Var.a()) {
                return false;
            }
            List<wh4> list2 = rj4Var.b;
            if (list2 != null) {
                for (wh4 wh4Var : list2) {
                    if (!wh4Var.a()) {
                        return false;
                    }
                }
            }
            th4 th4Var = rj4Var.d;
            if (th4Var != null && !th4Var.a()) {
                return false;
            }
            rh4 rh4Var = rj4Var.f;
            if (rh4Var != null && !rh4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = rj4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci4
    /* renamed from: x */
    public qh4 t(rj4 rj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rj4Var)) == null) {
            this.a.E();
            em4 em4Var = new em4();
            o(rj4Var.a, em4Var);
            p(rj4Var.b, em4Var);
            n(g(rj4Var.c), em4Var);
            m(rj4Var.d, em4Var);
            l(rj4Var.f, em4Var);
            r(rj4Var.e);
            if (em4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(em4Var);
            hi4.b(rj4Var, this.a);
            return null;
        }
        return (qh4) invokeL.objValue;
    }
}
