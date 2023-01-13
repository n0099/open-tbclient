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
public class ye4 extends pd4<ef4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.pd4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ye4(String str, ec4 ec4Var, pf4 pf4Var) {
        super(ec4Var, pf4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ec4Var, pf4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ec4) objArr2[0], (pf4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pd4
    /* renamed from: y */
    public ef4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return qh4.g(this.d, jSONObject);
        }
        return (ef4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pd4
    /* renamed from: w */
    public boolean s(ef4 ef4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, ef4Var, i)) == null) {
            if (ef4Var != null) {
                r(ef4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pd4
    /* renamed from: v */
    public boolean f(ef4 ef4Var) {
        InterceptResult invokeL;
        List<jd4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ef4Var)) == null) {
            if (ef4Var == null) {
                return false;
            }
            if (ef4Var.a == null && (((list = ef4Var.b) == null || list.isEmpty()) && ef4Var.d == null && ef4Var.f == null && ef4Var.e == null)) {
                return false;
            }
            id4 id4Var = ef4Var.a;
            if (id4Var != null && !id4Var.a()) {
                return false;
            }
            List<jd4> list2 = ef4Var.b;
            if (list2 != null) {
                for (jd4 jd4Var : list2) {
                    if (!jd4Var.a()) {
                        return false;
                    }
                }
            }
            gd4 gd4Var = ef4Var.d;
            if (gd4Var != null && !gd4Var.a()) {
                return false;
            }
            ed4 ed4Var = ef4Var.f;
            if (ed4Var != null && !ed4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = ef4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pd4
    /* renamed from: x */
    public dd4 t(ef4 ef4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ef4Var)) == null) {
            this.a.E();
            rh4 rh4Var = new rh4();
            o(ef4Var.a, rh4Var);
            p(ef4Var.b, rh4Var);
            n(g(ef4Var.c), rh4Var);
            m(ef4Var.d, rh4Var);
            l(ef4Var.f, rh4Var);
            r(ef4Var.e);
            if (rh4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(rh4Var);
            ud4.b(ef4Var, this.a);
            return null;
        }
        return (dd4) invokeL.objValue;
    }
}
