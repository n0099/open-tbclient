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
public class vj4 extends mi4<bk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.mi4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vj4(String str, bh4 bh4Var, mk4 mk4Var) {
        super(bh4Var, mk4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bh4Var, mk4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bh4) objArr2[0], (mk4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4
    /* renamed from: x */
    public bk4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return nm4.g(this.d, jSONObject);
        }
        return (bk4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4
    /* renamed from: v */
    public boolean r(bk4 bk4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bk4Var, i)) == null) {
            if (bk4Var != null) {
                q(bk4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4
    /* renamed from: u */
    public boolean e(bk4 bk4Var) {
        InterceptResult invokeL;
        List<gi4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bk4Var)) == null) {
            if (bk4Var == null) {
                return false;
            }
            if (bk4Var.a == null && (((list = bk4Var.b) == null || list.isEmpty()) && bk4Var.d == null && bk4Var.f == null && bk4Var.e == null)) {
                return false;
            }
            fi4 fi4Var = bk4Var.a;
            if (fi4Var != null && !fi4Var.a()) {
                return false;
            }
            List<gi4> list2 = bk4Var.b;
            if (list2 != null) {
                for (gi4 gi4Var : list2) {
                    if (!gi4Var.a()) {
                        return false;
                    }
                }
            }
            di4 di4Var = bk4Var.d;
            if (di4Var != null && !di4Var.a()) {
                return false;
            }
            bi4 bi4Var = bk4Var.f;
            if (bi4Var != null && !bi4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = bk4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4
    /* renamed from: w */
    public ai4 s(bk4 bk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bk4Var)) == null) {
            this.a.E();
            om4 om4Var = new om4();
            n(bk4Var.a, om4Var);
            o(bk4Var.b, om4Var);
            m(f(bk4Var.c), om4Var);
            l(bk4Var.d, om4Var);
            k(bk4Var.f, om4Var);
            q(bk4Var.e);
            if (om4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(om4Var);
            ri4.b(bk4Var, this.a);
            return null;
        }
        return (ai4) invokeL.objValue;
    }
}
