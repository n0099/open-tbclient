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
public class nd4 extends ec4<td4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nd4(String str, ta4 ta4Var, ee4 ee4Var) {
        super(ta4Var, ee4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ta4Var, ee4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ta4) objArr2[0], (ee4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    @Override // com.baidu.tieba.ec4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: v */
    public boolean f(td4 td4Var) {
        InterceptResult invokeL;
        List<yb4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, td4Var)) == null) {
            if (td4Var == null) {
                return false;
            }
            if (td4Var.a == null && (((list = td4Var.b) == null || list.isEmpty()) && td4Var.d == null && td4Var.f == null && td4Var.e == null)) {
                return false;
            }
            xb4 xb4Var = td4Var.a;
            if (xb4Var == null || xb4Var.a()) {
                List<yb4> list2 = td4Var.b;
                if (list2 != null) {
                    for (yb4 yb4Var : list2) {
                        if (!yb4Var.a()) {
                            return false;
                        }
                    }
                }
                vb4 vb4Var = td4Var.d;
                if (vb4Var == null || vb4Var.a()) {
                    tb4 tb4Var = td4Var.f;
                    if (tb4Var == null || tb4Var.a()) {
                        PMSAppInfo pMSAppInfo = td4Var.e;
                        return pMSAppInfo == null || pMSAppInfo.checkValid();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: w */
    public boolean s(td4 td4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, td4Var, i)) == null) {
            if (td4Var != null) {
                r(td4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: x */
    public sb4 t(td4 td4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, td4Var)) == null) {
            this.a.E();
            gg4 gg4Var = new gg4();
            o(td4Var.a, gg4Var);
            p(td4Var.b, gg4Var);
            n(g(td4Var.c), gg4Var);
            m(td4Var.d, gg4Var);
            l(td4Var.f, gg4Var);
            r(td4Var.e);
            if (gg4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(gg4Var);
            jc4.b(td4Var, this.a);
            return null;
        }
        return (sb4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: y */
    public td4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? fg4.g(this.d, jSONObject) : (td4) invokeL.objValue;
    }
}
