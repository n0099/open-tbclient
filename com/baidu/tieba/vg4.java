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
public class vg4 extends mf4<bh4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.mf4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vg4(String str, be4 be4Var, mh4 mh4Var) {
        super(be4Var, mh4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, be4Var, mh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((be4) objArr2[0], (mh4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf4
    /* renamed from: x */
    public bh4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return nj4.g(this.d, jSONObject);
        }
        return (bh4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf4
    /* renamed from: v */
    public boolean r(bh4 bh4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bh4Var, i)) == null) {
            if (bh4Var != null) {
                q(bh4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf4
    /* renamed from: u */
    public boolean e(bh4 bh4Var) {
        InterceptResult invokeL;
        List<gf4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bh4Var)) == null) {
            if (bh4Var == null) {
                return false;
            }
            if (bh4Var.a == null && (((list = bh4Var.b) == null || list.isEmpty()) && bh4Var.d == null && bh4Var.f == null && bh4Var.e == null)) {
                return false;
            }
            ff4 ff4Var = bh4Var.a;
            if (ff4Var != null && !ff4Var.a()) {
                return false;
            }
            List<gf4> list2 = bh4Var.b;
            if (list2 != null) {
                for (gf4 gf4Var : list2) {
                    if (!gf4Var.a()) {
                        return false;
                    }
                }
            }
            df4 df4Var = bh4Var.d;
            if (df4Var != null && !df4Var.a()) {
                return false;
            }
            bf4 bf4Var = bh4Var.f;
            if (bf4Var != null && !bf4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = bh4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf4
    /* renamed from: w */
    public af4 s(bh4 bh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bh4Var)) == null) {
            this.a.E();
            oj4 oj4Var = new oj4();
            n(bh4Var.a, oj4Var);
            o(bh4Var.b, oj4Var);
            m(f(bh4Var.c), oj4Var);
            l(bh4Var.d, oj4Var);
            k(bh4Var.f, oj4Var);
            q(bh4Var.e);
            if (oj4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(oj4Var);
            rf4.b(bh4Var, this.a);
            return null;
        }
        return (af4) invokeL.objValue;
    }
}
