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
public class wl4 extends nk4<cm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.nk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl4(String str, cj4 cj4Var, nm4 nm4Var) {
        super(cj4Var, nm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cj4Var, nm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((cj4) objArr2[0], (nm4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: x */
    public cm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return oo4.g(this.d, jSONObject);
        }
        return (cm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: v */
    public boolean r(cm4 cm4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, cm4Var, i)) == null) {
            if (cm4Var != null) {
                q(cm4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: u */
    public boolean e(cm4 cm4Var) {
        InterceptResult invokeL;
        List<hk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cm4Var)) == null) {
            if (cm4Var == null) {
                return false;
            }
            if (cm4Var.a == null && (((list = cm4Var.b) == null || list.isEmpty()) && cm4Var.d == null && cm4Var.f == null && cm4Var.e == null)) {
                return false;
            }
            gk4 gk4Var = cm4Var.a;
            if (gk4Var != null && !gk4Var.a()) {
                return false;
            }
            List<hk4> list2 = cm4Var.b;
            if (list2 != null) {
                for (hk4 hk4Var : list2) {
                    if (!hk4Var.a()) {
                        return false;
                    }
                }
            }
            ek4 ek4Var = cm4Var.d;
            if (ek4Var != null && !ek4Var.a()) {
                return false;
            }
            ck4 ck4Var = cm4Var.f;
            if (ck4Var != null && !ck4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = cm4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: w */
    public bk4 s(cm4 cm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cm4Var)) == null) {
            this.a.E();
            po4 po4Var = new po4();
            n(cm4Var.a, po4Var);
            o(cm4Var.b, po4Var);
            m(f(cm4Var.c), po4Var);
            l(cm4Var.d, po4Var);
            k(cm4Var.f, po4Var);
            q(cm4Var.e);
            if (po4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(po4Var);
            sk4.b(cm4Var, this.a);
            return null;
        }
        return (bk4) invokeL.objValue;
    }
}
