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
/* loaded from: classes9.dex */
public class zg4 extends qf4<fh4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.qf4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zg4(String str, fe4 fe4Var, qh4 qh4Var) {
        super(fe4Var, qh4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, fe4Var, qh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((fe4) objArr2[0], (qh4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: x */
    public fh4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return rj4.g(this.d, jSONObject);
        }
        return (fh4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: v */
    public boolean r(fh4 fh4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, fh4Var, i)) == null) {
            if (fh4Var != null) {
                q(fh4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: u */
    public boolean e(fh4 fh4Var) {
        InterceptResult invokeL;
        List<kf4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fh4Var)) == null) {
            if (fh4Var == null) {
                return false;
            }
            if (fh4Var.a == null && (((list = fh4Var.b) == null || list.isEmpty()) && fh4Var.d == null && fh4Var.f == null && fh4Var.e == null)) {
                return false;
            }
            jf4 jf4Var = fh4Var.a;
            if (jf4Var != null && !jf4Var.a()) {
                return false;
            }
            List<kf4> list2 = fh4Var.b;
            if (list2 != null) {
                for (kf4 kf4Var : list2) {
                    if (!kf4Var.a()) {
                        return false;
                    }
                }
            }
            hf4 hf4Var = fh4Var.d;
            if (hf4Var != null && !hf4Var.a()) {
                return false;
            }
            ff4 ff4Var = fh4Var.f;
            if (ff4Var != null && !ff4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = fh4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: w */
    public ef4 s(fh4 fh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fh4Var)) == null) {
            this.a.E();
            sj4 sj4Var = new sj4();
            n(fh4Var.a, sj4Var);
            o(fh4Var.b, sj4Var);
            m(f(fh4Var.c), sj4Var);
            l(fh4Var.d, sj4Var);
            k(fh4Var.f, sj4Var);
            q(fh4Var.e);
            if (sj4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(sj4Var);
            vf4.b(fh4Var, this.a);
            return null;
        }
        return (ef4) invokeL.objValue;
    }
}
