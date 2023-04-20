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
public class ki4 extends bh4<qi4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.bh4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ki4(String str, qf4 qf4Var, bj4 bj4Var) {
        super(qf4Var, bj4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, qf4Var, bj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qf4) objArr2[0], (bj4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh4
    /* renamed from: y */
    public qi4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return cl4.g(this.d, jSONObject);
        }
        return (qi4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh4
    /* renamed from: w */
    public boolean s(qi4 qi4Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, qi4Var, i)) == null) {
            if (qi4Var != null) {
                r(qi4Var.e);
                return false;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh4
    /* renamed from: v */
    public boolean f(qi4 qi4Var) {
        InterceptResult invokeL;
        List<vg4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qi4Var)) == null) {
            if (qi4Var == null) {
                return false;
            }
            if (qi4Var.a == null && (((list = qi4Var.b) == null || list.isEmpty()) && qi4Var.d == null && qi4Var.f == null && qi4Var.e == null)) {
                return false;
            }
            ug4 ug4Var = qi4Var.a;
            if (ug4Var != null && !ug4Var.a()) {
                return false;
            }
            List<vg4> list2 = qi4Var.b;
            if (list2 != null) {
                for (vg4 vg4Var : list2) {
                    if (!vg4Var.a()) {
                        return false;
                    }
                }
            }
            sg4 sg4Var = qi4Var.d;
            if (sg4Var != null && !sg4Var.a()) {
                return false;
            }
            qg4 qg4Var = qi4Var.f;
            if (qg4Var != null && !qg4Var.a()) {
                return false;
            }
            PMSAppInfo pMSAppInfo = qi4Var.e;
            if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh4
    /* renamed from: x */
    public pg4 t(qi4 qi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qi4Var)) == null) {
            this.a.E();
            dl4 dl4Var = new dl4();
            o(qi4Var.a, dl4Var);
            p(qi4Var.b, dl4Var);
            n(g(qi4Var.c), dl4Var);
            m(qi4Var.d, dl4Var);
            l(qi4Var.f, dl4Var);
            r(qi4Var.e);
            if (dl4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(dl4Var);
            gh4.b(qi4Var, this.a);
            return null;
        }
        return (pg4) invokeL.objValue;
    }
}
