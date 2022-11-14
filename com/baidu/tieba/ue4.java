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
public class ue4 extends ld4<af4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.ld4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ue4(String str, ac4 ac4Var, lf4 lf4Var) {
        super(ac4Var, lf4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ac4Var, lf4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ac4) objArr2[0], (lf4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ld4
    /* renamed from: y */
    public af4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return mh4.g(this.d, jSONObject);
        }
        return (af4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ld4
    /* renamed from: w */
    public boolean s(af4 af4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, af4Var, i)) == null) {
            if (af4Var != null) {
                r(af4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ld4
    /* renamed from: v */
    public boolean f(af4 af4Var) {
        InterceptResult invokeL;
        List<fd4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, af4Var)) == null) {
            if (af4Var == null) {
                return false;
            }
            if (af4Var.a == null && (((list = af4Var.b) == null || list.isEmpty()) && af4Var.d == null && af4Var.f == null && af4Var.e == null)) {
                return false;
            }
            ed4 ed4Var = af4Var.a;
            if (ed4Var != null && !ed4Var.a()) {
                return false;
            }
            List<fd4> list2 = af4Var.b;
            if (list2 != null) {
                for (fd4 fd4Var : list2) {
                    if (!fd4Var.a()) {
                        return false;
                    }
                }
            }
            cd4 cd4Var = af4Var.d;
            if (cd4Var != null && !cd4Var.a()) {
                return false;
            }
            ad4 ad4Var = af4Var.f;
            if (ad4Var != null && !ad4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = af4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ld4
    /* renamed from: x */
    public zc4 t(af4 af4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, af4Var)) == null) {
            this.a.E();
            nh4 nh4Var = new nh4();
            o(af4Var.a, nh4Var);
            p(af4Var.b, nh4Var);
            n(g(af4Var.c), nh4Var);
            m(af4Var.d, nh4Var);
            l(af4Var.f, nh4Var);
            r(af4Var.e);
            if (nh4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(nh4Var);
            qd4.b(af4Var, this.a);
            return null;
        }
        return (zc4) invokeL.objValue;
    }
}
