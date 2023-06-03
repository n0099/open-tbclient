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
public class lm4 extends el4<rm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.el4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lm4(tj4 tj4Var, en4 en4Var) {
        super(tj4Var, en4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tj4Var, en4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((tj4) objArr2[0], (en4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.el4
    /* renamed from: u */
    public sk4 d(String str, rm4 rm4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, rm4Var)) == null) {
            if (rm4Var != null && (i = rm4Var.a) != 0) {
                return new sk4(i, rm4Var.b);
            }
            return super.d(str, rm4Var);
        }
        return (sk4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.el4
    /* renamed from: x */
    public rm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return fp4.e(jSONObject);
        }
        return (rm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.el4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(rm4 rm4Var) {
        InterceptResult invokeL;
        List<zk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rm4Var)) == null) {
            if (rm4Var == null || (list = rm4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (zk4 zk4Var : rm4Var.c) {
                if (zk4Var == null || !zk4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            en4 en4Var = this.b;
            if ((en4Var instanceof xm4) && ((xm4) en4Var).f().size() != rm4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.el4
    /* renamed from: w */
    public sk4 s(rm4 rm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rm4Var)) == null) {
            this.a.E();
            gp4 gp4Var = new gp4();
            m(rm4Var.c, gp4Var);
            if (gp4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(gp4Var);
            jl4.f(rm4Var.c, this.a);
            return null;
        }
        return (sk4) invokeL.objValue;
    }
}
