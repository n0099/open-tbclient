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
/* loaded from: classes6.dex */
public class te4 extends kd4<ze4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.kd4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public te4(String str, zb4 zb4Var, kf4 kf4Var) {
        super(zb4Var, kf4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, zb4Var, kf4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((zb4) objArr2[0], (kf4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kd4
    /* renamed from: y */
    public ze4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return lh4.g(this.d, jSONObject);
        }
        return (ze4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kd4
    /* renamed from: w */
    public boolean s(ze4 ze4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, ze4Var, i)) == null) {
            if (ze4Var != null) {
                r(ze4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kd4
    /* renamed from: v */
    public boolean f(ze4 ze4Var) {
        InterceptResult invokeL;
        List<ed4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ze4Var)) == null) {
            if (ze4Var == null) {
                return false;
            }
            if (ze4Var.a == null && (((list = ze4Var.b) == null || list.isEmpty()) && ze4Var.d == null && ze4Var.f == null && ze4Var.e == null)) {
                return false;
            }
            dd4 dd4Var = ze4Var.a;
            if (dd4Var != null && !dd4Var.a()) {
                return false;
            }
            List<ed4> list2 = ze4Var.b;
            if (list2 != null) {
                for (ed4 ed4Var : list2) {
                    if (!ed4Var.a()) {
                        return false;
                    }
                }
            }
            bd4 bd4Var = ze4Var.d;
            if (bd4Var != null && !bd4Var.a()) {
                return false;
            }
            zc4 zc4Var = ze4Var.f;
            if (zc4Var != null && !zc4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = ze4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kd4
    /* renamed from: x */
    public yc4 t(ze4 ze4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ze4Var)) == null) {
            this.a.E();
            mh4 mh4Var = new mh4();
            o(ze4Var.a, mh4Var);
            p(ze4Var.b, mh4Var);
            n(g(ze4Var.c), mh4Var);
            m(ze4Var.d, mh4Var);
            l(ze4Var.f, mh4Var);
            r(ze4Var.e);
            if (mh4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(mh4Var);
            pd4.b(ze4Var, this.a);
            return null;
        }
        return (yc4) invokeL.objValue;
    }
}
