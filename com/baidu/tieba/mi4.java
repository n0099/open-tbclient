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
/* loaded from: classes5.dex */
public class mi4 extends dh4<si4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.dh4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi4(String str, sf4 sf4Var, dj4 dj4Var) {
        super(sf4Var, dj4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, sf4Var, dj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((sf4) objArr2[0], (dj4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh4
    /* renamed from: y */
    public si4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return el4.g(this.d, jSONObject);
        }
        return (si4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh4
    /* renamed from: w */
    public boolean s(si4 si4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, si4Var, i)) == null) {
            if (si4Var != null) {
                r(si4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh4
    /* renamed from: v */
    public boolean f(si4 si4Var) {
        InterceptResult invokeL;
        List<xg4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, si4Var)) == null) {
            if (si4Var == null) {
                return false;
            }
            if (si4Var.a == null && (((list = si4Var.b) == null || list.isEmpty()) && si4Var.d == null && si4Var.f == null && si4Var.e == null)) {
                return false;
            }
            wg4 wg4Var = si4Var.a;
            if (wg4Var != null && !wg4Var.a()) {
                return false;
            }
            List<xg4> list2 = si4Var.b;
            if (list2 != null) {
                for (xg4 xg4Var : list2) {
                    if (!xg4Var.a()) {
                        return false;
                    }
                }
            }
            ug4 ug4Var = si4Var.d;
            if (ug4Var != null && !ug4Var.a()) {
                return false;
            }
            sg4 sg4Var = si4Var.f;
            if (sg4Var != null && !sg4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = si4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh4
    /* renamed from: x */
    public rg4 t(si4 si4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, si4Var)) == null) {
            this.a.E();
            fl4 fl4Var = new fl4();
            o(si4Var.a, fl4Var);
            p(si4Var.b, fl4Var);
            n(g(si4Var.c), fl4Var);
            m(si4Var.d, fl4Var);
            l(si4Var.f, fl4Var);
            r(si4Var.e);
            if (fl4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(fl4Var);
            ih4.b(si4Var, this.a);
            return null;
        }
        return (rg4) invokeL.objValue;
    }
}
