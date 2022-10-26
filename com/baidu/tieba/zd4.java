package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zd4 extends sc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sc4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zd4(hb4 hb4Var, se4 se4Var) {
        super(hb4Var, se4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hb4Var, se4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((hb4) objArr2[0], (se4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: v */
    public gc4 e(String str, fe4 fe4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, fe4Var)) == null) {
            if (fe4Var != null && (i = fe4Var.a) != 0) {
                return new gc4(i, fe4Var.b);
            }
            return super.e(str, fe4Var);
        }
        return (gc4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: y */
    public fe4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return tg4.e(jSONObject);
        }
        return (fe4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.sc4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(fe4 fe4Var) {
        InterceptResult invokeL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fe4Var)) == null) {
            if (fe4Var == null || (list = fe4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (nc4 nc4Var : fe4Var.c) {
                if (nc4Var == null || !nc4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            se4 se4Var = this.b;
            if ((se4Var instanceof le4) && ((le4) se4Var).f().size() != fe4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sc4
    /* renamed from: x */
    public gc4 t(fe4 fe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fe4Var)) == null) {
            this.a.E();
            ug4 ug4Var = new ug4();
            n(fe4Var.c, ug4Var);
            if (ug4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(ug4Var);
            xc4.f(fe4Var.c, this.a);
            return null;
        }
        return (gc4) invokeL.objValue;
    }
}
