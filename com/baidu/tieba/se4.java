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
/* loaded from: classes5.dex */
public class se4 extends ld4<ye4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ld4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se4(ac4 ac4Var, lf4 lf4Var) {
        super(ac4Var, lf4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac4Var, lf4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ac4) objArr2[0], (lf4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ld4
    /* renamed from: v */
    public zc4 e(String str, ye4 ye4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ye4Var)) == null) {
            if (ye4Var != null && (i = ye4Var.a) != 0) {
                return new zc4(i, ye4Var.b);
            }
            return super.e(str, ye4Var);
        }
        return (zc4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ld4
    /* renamed from: y */
    public ye4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return mh4.e(jSONObject);
        }
        return (ye4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.ld4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(ye4 ye4Var) {
        InterceptResult invokeL;
        List<gd4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ye4Var)) == null) {
            if (ye4Var == null || (list = ye4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (gd4 gd4Var : ye4Var.c) {
                if (gd4Var == null || !gd4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            lf4 lf4Var = this.b;
            if ((lf4Var instanceof ef4) && ((ef4) lf4Var).f().size() != ye4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ld4
    /* renamed from: x */
    public zc4 t(ye4 ye4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ye4Var)) == null) {
            this.a.E();
            nh4 nh4Var = new nh4();
            n(ye4Var.c, nh4Var);
            if (nh4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(nh4Var);
            qd4.f(ye4Var.c, this.a);
            return null;
        }
        return (zc4) invokeL.objValue;
    }
}
