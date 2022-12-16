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
public class re4 extends kd4<xe4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kd4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public re4(zb4 zb4Var, kf4 kf4Var) {
        super(zb4Var, kf4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zb4Var, kf4Var};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kd4
    /* renamed from: v */
    public yc4 e(String str, xe4 xe4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, xe4Var)) == null) {
            if (xe4Var != null && (i = xe4Var.a) != 0) {
                return new yc4(i, xe4Var.b);
            }
            return super.e(str, xe4Var);
        }
        return (yc4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kd4
    /* renamed from: y */
    public xe4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return lh4.e(jSONObject);
        }
        return (xe4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.kd4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(xe4 xe4Var) {
        InterceptResult invokeL;
        List<fd4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xe4Var)) == null) {
            if (xe4Var == null || (list = xe4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (fd4 fd4Var : xe4Var.c) {
                if (fd4Var == null || !fd4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            kf4 kf4Var = this.b;
            if ((kf4Var instanceof df4) && ((df4) kf4Var).f().size() != xe4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kd4
    /* renamed from: x */
    public yc4 t(xe4 xe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, xe4Var)) == null) {
            this.a.E();
            mh4 mh4Var = new mh4();
            n(xe4Var.c, mh4Var);
            if (mh4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(mh4Var);
            pd4.f(xe4Var.c, this.a);
            return null;
        }
        return (yc4) invokeL.objValue;
    }
}
