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
public class im4 extends bl4<om4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bl4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public im4(qj4 qj4Var, bn4 bn4Var) {
        super(qj4Var, bn4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qj4Var, bn4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qj4) objArr2[0], (bn4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: u */
    public pk4 d(String str, om4 om4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, om4Var)) == null) {
            if (om4Var != null && (i = om4Var.a) != 0) {
                return new pk4(i, om4Var.b);
            }
            return super.d(str, om4Var);
        }
        return (pk4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: x */
    public om4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return cp4.e(jSONObject);
        }
        return (om4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.bl4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(om4 om4Var) {
        InterceptResult invokeL;
        List<wk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, om4Var)) == null) {
            if (om4Var == null || (list = om4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (wk4 wk4Var : om4Var.c) {
                if (wk4Var == null || !wk4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            bn4 bn4Var = this.b;
            if ((bn4Var instanceof um4) && ((um4) bn4Var).f().size() != om4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: w */
    public pk4 s(om4 om4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, om4Var)) == null) {
            this.a.E();
            dp4 dp4Var = new dp4();
            m(om4Var.c, dp4Var);
            if (dp4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(dp4Var);
            gl4.f(om4Var.c, this.a);
            return null;
        }
        return (pk4) invokeL.objValue;
    }
}
