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
/* loaded from: classes8.dex */
public class wg4 extends nf4<ch4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.nf4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wg4(String str, ce4 ce4Var, nh4 nh4Var) {
        super(ce4Var, nh4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ce4Var, nh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ce4) objArr2[0], (nh4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nf4
    /* renamed from: x */
    public ch4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return oj4.g(this.d, jSONObject);
        }
        return (ch4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nf4
    /* renamed from: v */
    public boolean r(ch4 ch4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, ch4Var, i)) == null) {
            if (ch4Var != null) {
                q(ch4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nf4
    /* renamed from: u */
    public boolean e(ch4 ch4Var) {
        InterceptResult invokeL;
        List<hf4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ch4Var)) == null) {
            if (ch4Var == null) {
                return false;
            }
            if (ch4Var.a == null && (((list = ch4Var.b) == null || list.isEmpty()) && ch4Var.d == null && ch4Var.f == null && ch4Var.e == null)) {
                return false;
            }
            gf4 gf4Var = ch4Var.a;
            if (gf4Var != null && !gf4Var.a()) {
                return false;
            }
            List<hf4> list2 = ch4Var.b;
            if (list2 != null) {
                for (hf4 hf4Var : list2) {
                    if (!hf4Var.a()) {
                        return false;
                    }
                }
            }
            ef4 ef4Var = ch4Var.d;
            if (ef4Var != null && !ef4Var.a()) {
                return false;
            }
            cf4 cf4Var = ch4Var.f;
            if (cf4Var != null && !cf4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = ch4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nf4
    /* renamed from: w */
    public bf4 s(ch4 ch4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ch4Var)) == null) {
            this.a.E();
            pj4 pj4Var = new pj4();
            n(ch4Var.a, pj4Var);
            o(ch4Var.b, pj4Var);
            m(f(ch4Var.c), pj4Var);
            l(ch4Var.d, pj4Var);
            k(ch4Var.f, pj4Var);
            q(ch4Var.e);
            if (pj4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(pj4Var);
            sf4.b(ch4Var, this.a);
            return null;
        }
        return (bf4) invokeL.objValue;
    }
}
