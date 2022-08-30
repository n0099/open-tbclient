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
public class nb4 extends ea4<tb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nb4(String str, t84 t84Var, ec4 ec4Var) {
        super(t84Var, ec4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, t84Var, ec4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((t84) objArr2[0], (ec4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    @Override // com.baidu.tieba.ea4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ea4
    /* renamed from: v */
    public boolean f(tb4 tb4Var) {
        InterceptResult invokeL;
        List<y94> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tb4Var)) == null) {
            if (tb4Var == null) {
                return false;
            }
            if (tb4Var.a == null && (((list = tb4Var.b) == null || list.isEmpty()) && tb4Var.d == null && tb4Var.f == null && tb4Var.e == null)) {
                return false;
            }
            x94 x94Var = tb4Var.a;
            if (x94Var == null || x94Var.a()) {
                List<y94> list2 = tb4Var.b;
                if (list2 != null) {
                    for (y94 y94Var : list2) {
                        if (!y94Var.a()) {
                            return false;
                        }
                    }
                }
                v94 v94Var = tb4Var.d;
                if (v94Var == null || v94Var.a()) {
                    t94 t94Var = tb4Var.f;
                    if (t94Var == null || t94Var.a()) {
                        PMSAppInfo pMSAppInfo = tb4Var.e;
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
    @Override // com.baidu.tieba.ea4
    /* renamed from: w */
    public boolean s(tb4 tb4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, tb4Var, i)) == null) {
            if (tb4Var != null) {
                r(tb4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ea4
    /* renamed from: x */
    public s94 t(tb4 tb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tb4Var)) == null) {
            this.a.E();
            ge4 ge4Var = new ge4();
            o(tb4Var.a, ge4Var);
            p(tb4Var.b, ge4Var);
            n(g(tb4Var.c), ge4Var);
            m(tb4Var.d, ge4Var);
            l(tb4Var.f, ge4Var);
            r(tb4Var.e);
            if (ge4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(ge4Var);
            ja4.b(tb4Var, this.a);
            return null;
        }
        return (s94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ea4
    /* renamed from: y */
    public tb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? fe4.g(this.d, jSONObject) : (tb4) invokeL.objValue;
    }
}
