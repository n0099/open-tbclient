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
public class vl4 extends mk4<bm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.mk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl4(String str, bj4 bj4Var, mm4 mm4Var) {
        super(bj4Var, mm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bj4Var, mm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bj4) objArr2[0], (mm4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mk4
    /* renamed from: x */
    public bm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return no4.g(this.d, jSONObject);
        }
        return (bm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mk4
    /* renamed from: v */
    public boolean r(bm4 bm4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bm4Var, i)) == null) {
            if (bm4Var != null) {
                q(bm4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mk4
    /* renamed from: u */
    public boolean e(bm4 bm4Var) {
        InterceptResult invokeL;
        List<gk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bm4Var)) == null) {
            if (bm4Var == null) {
                return false;
            }
            if (bm4Var.a == null && (((list = bm4Var.b) == null || list.isEmpty()) && bm4Var.d == null && bm4Var.f == null && bm4Var.e == null)) {
                return false;
            }
            fk4 fk4Var = bm4Var.a;
            if (fk4Var != null && !fk4Var.a()) {
                return false;
            }
            List<gk4> list2 = bm4Var.b;
            if (list2 != null) {
                for (gk4 gk4Var : list2) {
                    if (!gk4Var.a()) {
                        return false;
                    }
                }
            }
            dk4 dk4Var = bm4Var.d;
            if (dk4Var != null && !dk4Var.a()) {
                return false;
            }
            bk4 bk4Var = bm4Var.f;
            if (bk4Var != null && !bk4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = bm4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mk4
    /* renamed from: w */
    public ak4 s(bm4 bm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bm4Var)) == null) {
            this.a.E();
            oo4 oo4Var = new oo4();
            n(bm4Var.a, oo4Var);
            o(bm4Var.b, oo4Var);
            m(f(bm4Var.c), oo4Var);
            l(bm4Var.d, oo4Var);
            k(bm4Var.f, oo4Var);
            q(bm4Var.e);
            if (oo4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(oo4Var);
            rk4.b(bm4Var, this.a);
            return null;
        }
        return (ak4) invokeL.objValue;
    }
}
