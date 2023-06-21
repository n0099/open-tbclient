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
public class om4 extends fl4<um4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.fl4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public om4(String str, uj4 uj4Var, fn4 fn4Var) {
        super(uj4Var, fn4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, uj4Var, fn4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((uj4) objArr2[0], (fn4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fl4
    /* renamed from: x */
    public um4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return gp4.g(this.d, jSONObject);
        }
        return (um4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fl4
    /* renamed from: v */
    public boolean r(um4 um4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, um4Var, i)) == null) {
            if (um4Var != null) {
                q(um4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fl4
    /* renamed from: u */
    public boolean e(um4 um4Var) {
        InterceptResult invokeL;
        List<zk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, um4Var)) == null) {
            if (um4Var == null) {
                return false;
            }
            if (um4Var.a == null && (((list = um4Var.b) == null || list.isEmpty()) && um4Var.d == null && um4Var.f == null && um4Var.e == null)) {
                return false;
            }
            yk4 yk4Var = um4Var.a;
            if (yk4Var != null && !yk4Var.a()) {
                return false;
            }
            List<zk4> list2 = um4Var.b;
            if (list2 != null) {
                for (zk4 zk4Var : list2) {
                    if (!zk4Var.a()) {
                        return false;
                    }
                }
            }
            wk4 wk4Var = um4Var.d;
            if (wk4Var != null && !wk4Var.a()) {
                return false;
            }
            uk4 uk4Var = um4Var.f;
            if (uk4Var != null && !uk4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = um4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fl4
    /* renamed from: w */
    public tk4 s(um4 um4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, um4Var)) == null) {
            this.a.E();
            hp4 hp4Var = new hp4();
            n(um4Var.a, hp4Var);
            o(um4Var.b, hp4Var);
            m(f(um4Var.c), hp4Var);
            l(um4Var.d, hp4Var);
            k(um4Var.f, hp4Var);
            q(um4Var.e);
            if (hp4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(hp4Var);
            kl4.b(um4Var, this.a);
            return null;
        }
        return (tk4) invokeL.objValue;
    }
}
