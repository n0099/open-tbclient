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
/* loaded from: classes8.dex */
public class tl4 extends mk4<zl4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.mk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tl4(bj4 bj4Var, mm4 mm4Var) {
        super(bj4Var, mm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bj4Var, mm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bj4) objArr2[0], (mm4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mk4
    /* renamed from: u */
    public ak4 d(String str, zl4 zl4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, zl4Var)) == null) {
            if (zl4Var != null && (i = zl4Var.a) != 0) {
                return new ak4(i, zl4Var.b);
            }
            return super.d(str, zl4Var);
        }
        return (ak4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mk4
    /* renamed from: x */
    public zl4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return no4.e(jSONObject);
        }
        return (zl4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.mk4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(zl4 zl4Var) {
        InterceptResult invokeL;
        List<hk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zl4Var)) == null) {
            if (zl4Var == null || (list = zl4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (hk4 hk4Var : zl4Var.c) {
                if (hk4Var == null || !hk4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            mm4 mm4Var = this.b;
            if ((mm4Var instanceof fm4) && ((fm4) mm4Var).f().size() != zl4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mk4
    /* renamed from: w */
    public ak4 s(zl4 zl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zl4Var)) == null) {
            this.a.E();
            oo4 oo4Var = new oo4();
            m(zl4Var.c, oo4Var);
            if (oo4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(oo4Var);
            rk4.f(zl4Var.c, this.a);
            return null;
        }
        return (ak4) invokeL.objValue;
    }
}
