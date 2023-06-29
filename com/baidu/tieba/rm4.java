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
public class rm4 extends il4<xm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.il4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm4(String str, xj4 xj4Var, in4 in4Var) {
        super(xj4Var, in4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, xj4Var, in4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((xj4) objArr2[0], (in4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.il4
    /* renamed from: x */
    public xm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return jp4.g(this.d, jSONObject);
        }
        return (xm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.il4
    /* renamed from: v */
    public boolean r(xm4 xm4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, xm4Var, i)) == null) {
            if (xm4Var != null) {
                q(xm4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.il4
    /* renamed from: u */
    public boolean e(xm4 xm4Var) {
        InterceptResult invokeL;
        List<cl4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xm4Var)) == null) {
            if (xm4Var == null) {
                return false;
            }
            if (xm4Var.a == null && (((list = xm4Var.b) == null || list.isEmpty()) && xm4Var.d == null && xm4Var.f == null && xm4Var.e == null)) {
                return false;
            }
            bl4 bl4Var = xm4Var.a;
            if (bl4Var != null && !bl4Var.a()) {
                return false;
            }
            List<cl4> list2 = xm4Var.b;
            if (list2 != null) {
                for (cl4 cl4Var : list2) {
                    if (!cl4Var.a()) {
                        return false;
                    }
                }
            }
            zk4 zk4Var = xm4Var.d;
            if (zk4Var != null && !zk4Var.a()) {
                return false;
            }
            xk4 xk4Var = xm4Var.f;
            if (xk4Var != null && !xk4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = xm4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.il4
    /* renamed from: w */
    public wk4 s(xm4 xm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, xm4Var)) == null) {
            this.a.E();
            kp4 kp4Var = new kp4();
            n(xm4Var.a, kp4Var);
            o(xm4Var.b, kp4Var);
            m(f(xm4Var.c), kp4Var);
            l(xm4Var.d, kp4Var);
            k(xm4Var.f, kp4Var);
            q(xm4Var.e);
            if (kp4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(kp4Var);
            nl4.b(xm4Var, this.a);
            return null;
        }
        return (wk4) invokeL.objValue;
    }
}
