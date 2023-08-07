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
public class nl4 extends ek4<tl4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.ek4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nl4(String str, ti4 ti4Var, em4 em4Var) {
        super(ti4Var, em4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ti4Var, em4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ti4) objArr2[0], (em4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ek4
    /* renamed from: x */
    public tl4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return fo4.g(this.d, jSONObject);
        }
        return (tl4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ek4
    /* renamed from: v */
    public boolean r(tl4 tl4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, tl4Var, i)) == null) {
            if (tl4Var != null) {
                q(tl4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ek4
    /* renamed from: u */
    public boolean e(tl4 tl4Var) {
        InterceptResult invokeL;
        List<yj4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tl4Var)) == null) {
            if (tl4Var == null) {
                return false;
            }
            if (tl4Var.a == null && (((list = tl4Var.b) == null || list.isEmpty()) && tl4Var.d == null && tl4Var.f == null && tl4Var.e == null)) {
                return false;
            }
            xj4 xj4Var = tl4Var.a;
            if (xj4Var != null && !xj4Var.a()) {
                return false;
            }
            List<yj4> list2 = tl4Var.b;
            if (list2 != null) {
                for (yj4 yj4Var : list2) {
                    if (!yj4Var.a()) {
                        return false;
                    }
                }
            }
            vj4 vj4Var = tl4Var.d;
            if (vj4Var != null && !vj4Var.a()) {
                return false;
            }
            tj4 tj4Var = tl4Var.f;
            if (tj4Var != null && !tj4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = tl4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ek4
    /* renamed from: w */
    public sj4 s(tl4 tl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tl4Var)) == null) {
            this.a.E();
            go4 go4Var = new go4();
            n(tl4Var.a, go4Var);
            o(tl4Var.b, go4Var);
            m(f(tl4Var.c), go4Var);
            l(tl4Var.d, go4Var);
            k(tl4Var.f, go4Var);
            q(tl4Var.e);
            if (go4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(go4Var);
            jk4.b(tl4Var, this.a);
            return null;
        }
        return (sj4) invokeL.objValue;
    }
}
