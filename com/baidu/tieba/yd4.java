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
public class yd4 extends rc4<ee4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yd4(gb4 gb4Var, re4 re4Var) {
        super(gb4Var, re4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gb4Var, re4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((gb4) objArr2[0], (re4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.rc4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: v */
    public fc4 e(String str, ee4 ee4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ee4Var)) == null) {
            if (ee4Var != null && (i = ee4Var.a) != 0) {
                return new fc4(i, ee4Var.b);
            }
            return super.e(str, ee4Var);
        }
        return (fc4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.rc4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(ee4 ee4Var) {
        InterceptResult invokeL;
        List<mc4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ee4Var)) == null) {
            if (ee4Var == null || (list = ee4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (mc4 mc4Var : ee4Var.c) {
                if (mc4Var == null || !mc4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            re4 re4Var = this.b;
            return !(re4Var instanceof ke4) || ((ke4) re4Var).f().size() == ee4Var.c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: x */
    public fc4 t(ee4 ee4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ee4Var)) == null) {
            this.a.E();
            tg4 tg4Var = new tg4();
            n(ee4Var.c, tg4Var);
            if (tg4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(tg4Var);
            wc4.f(ee4Var.c, this.a);
            return null;
        }
        return (fc4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rc4
    /* renamed from: y */
    public ee4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? sg4.e(jSONObject) : (ee4) invokeL.objValue;
    }
}
