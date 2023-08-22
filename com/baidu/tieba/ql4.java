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
/* loaded from: classes7.dex */
public class ql4 extends jk4<wl4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ql4(yi4 yi4Var, jm4 jm4Var) {
        super(yi4Var, jm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yi4Var, jm4Var};
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: u */
    public xj4 d(String str, wl4 wl4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, wl4Var)) == null) {
            if (wl4Var != null && (i = wl4Var.a) != 0) {
                return new xj4(i, wl4Var.b);
            }
            return super.d(str, wl4Var);
        }
        return (xj4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: x */
    public wl4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return ko4.e(jSONObject);
        }
        return (wl4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.jk4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(wl4 wl4Var) {
        InterceptResult invokeL;
        List<ek4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wl4Var)) == null) {
            if (wl4Var == null || (list = wl4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (ek4 ek4Var : wl4Var.c) {
                if (ek4Var == null || !ek4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            jm4 jm4Var = this.b;
            if ((jm4Var instanceof cm4) && ((cm4) jm4Var).f().size() != wl4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: w */
    public xj4 s(wl4 wl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, wl4Var)) == null) {
            this.a.E();
            lo4 lo4Var = new lo4();
            m(wl4Var.c, lo4Var);
            if (lo4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(lo4Var);
            ok4.f(wl4Var.c, this.a);
            return null;
        }
        return (xj4) invokeL.objValue;
    }
}
