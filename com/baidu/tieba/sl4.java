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
public class sl4 extends jk4<yl4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.jk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sl4(String str, yi4 yi4Var, jm4 jm4Var) {
        super(yi4Var, jm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, yi4Var, jm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((yi4) objArr2[0], (jm4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: x */
    public yl4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return ko4.g(this.d, jSONObject);
        }
        return (yl4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: v */
    public boolean r(yl4 yl4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, yl4Var, i)) == null) {
            if (yl4Var != null) {
                q(yl4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: u */
    public boolean e(yl4 yl4Var) {
        InterceptResult invokeL;
        List<dk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yl4Var)) == null) {
            if (yl4Var == null) {
                return false;
            }
            if (yl4Var.a == null && (((list = yl4Var.b) == null || list.isEmpty()) && yl4Var.d == null && yl4Var.f == null && yl4Var.e == null)) {
                return false;
            }
            ck4 ck4Var = yl4Var.a;
            if (ck4Var != null && !ck4Var.a()) {
                return false;
            }
            List<dk4> list2 = yl4Var.b;
            if (list2 != null) {
                for (dk4 dk4Var : list2) {
                    if (!dk4Var.a()) {
                        return false;
                    }
                }
            }
            ak4 ak4Var = yl4Var.d;
            if (ak4Var != null && !ak4Var.a()) {
                return false;
            }
            yj4 yj4Var = yl4Var.f;
            if (yj4Var != null && !yj4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = yl4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: w */
    public xj4 s(yl4 yl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, yl4Var)) == null) {
            this.a.E();
            lo4 lo4Var = new lo4();
            n(yl4Var.a, lo4Var);
            o(yl4Var.b, lo4Var);
            m(f(yl4Var.c), lo4Var);
            l(yl4Var.d, lo4Var);
            k(yl4Var.f, lo4Var);
            q(yl4Var.e);
            if (lo4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(lo4Var);
            ok4.b(yl4Var, this.a);
            return null;
        }
        return (xj4) invokeL.objValue;
    }
}
