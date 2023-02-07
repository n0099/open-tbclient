package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jj4 extends ci4<pj4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ci4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jj4(rg4 rg4Var, ck4 ck4Var) {
        super(rg4Var, ck4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rg4Var, ck4Var};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci4
    /* renamed from: v */
    public qh4 e(String str, pj4 pj4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, pj4Var)) == null) {
            if (pj4Var != null && (i = pj4Var.a) != 0) {
                return new qh4(i, pj4Var.b);
            }
            return super.e(str, pj4Var);
        }
        return (qh4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci4
    /* renamed from: y */
    public pj4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return dm4.e(jSONObject);
        }
        return (pj4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.ci4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(pj4 pj4Var) {
        InterceptResult invokeL;
        List<xh4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pj4Var)) == null) {
            if (pj4Var == null || (list = pj4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (xh4 xh4Var : pj4Var.c) {
                if (xh4Var == null || !xh4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            ck4 ck4Var = this.b;
            if ((ck4Var instanceof vj4) && ((vj4) ck4Var).f().size() != pj4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci4
    /* renamed from: x */
    public qh4 t(pj4 pj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pj4Var)) == null) {
            this.a.E();
            em4 em4Var = new em4();
            n(pj4Var.c, em4Var);
            if (em4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(em4Var);
            hi4.f(pj4Var.c, this.a);
            return null;
        }
        return (qh4) invokeL.objValue;
    }
}
