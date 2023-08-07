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
public class ll4 extends ek4<rl4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ek4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ll4(ti4 ti4Var, em4 em4Var) {
        super(ti4Var, em4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ti4Var, em4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ti4) objArr2[0], (em4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ek4
    /* renamed from: u */
    public sj4 d(String str, rl4 rl4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, rl4Var)) == null) {
            if (rl4Var != null && (i = rl4Var.a) != 0) {
                return new sj4(i, rl4Var.b);
            }
            return super.d(str, rl4Var);
        }
        return (sj4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ek4
    /* renamed from: x */
    public rl4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return fo4.e(jSONObject);
        }
        return (rl4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.ek4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(rl4 rl4Var) {
        InterceptResult invokeL;
        List<zj4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rl4Var)) == null) {
            if (rl4Var == null || (list = rl4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (zj4 zj4Var : rl4Var.c) {
                if (zj4Var == null || !zj4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            em4 em4Var = this.b;
            if ((em4Var instanceof xl4) && ((xl4) em4Var).f().size() != rl4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ek4
    /* renamed from: w */
    public sj4 s(rl4 rl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rl4Var)) == null) {
            this.a.E();
            go4 go4Var = new go4();
            m(rl4Var.c, go4Var);
            if (go4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(go4Var);
            jk4.f(rl4Var.c, this.a);
            return null;
        }
        return (sj4) invokeL.objValue;
    }
}
