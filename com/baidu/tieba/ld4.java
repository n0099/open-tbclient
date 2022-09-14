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
/* loaded from: classes4.dex */
public class ld4 extends ec4<rd4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ld4(ta4 ta4Var, ee4 ee4Var) {
        super(ta4Var, ee4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ta4Var, ee4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ta4) objArr2[0], (ee4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ec4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: v */
    public sb4 e(String str, rd4 rd4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, rd4Var)) == null) {
            if (rd4Var != null && (i = rd4Var.a) != 0) {
                return new sb4(i, rd4Var.b);
            }
            return super.e(str, rd4Var);
        }
        return (sb4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.ec4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(rd4 rd4Var) {
        InterceptResult invokeL;
        List<zb4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rd4Var)) == null) {
            if (rd4Var == null || (list = rd4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (zb4 zb4Var : rd4Var.c) {
                if (zb4Var == null || !zb4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            ee4 ee4Var = this.b;
            return !(ee4Var instanceof xd4) || ((xd4) ee4Var).f().size() == rd4Var.c.size();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: x */
    public sb4 t(rd4 rd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rd4Var)) == null) {
            this.a.E();
            gg4 gg4Var = new gg4();
            n(rd4Var.c, gg4Var);
            if (gg4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(gg4Var);
            jc4.f(rd4Var.c, this.a);
            return null;
        }
        return (sb4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: y */
    public rd4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? fg4.e(jSONObject) : (rd4) invokeL.objValue;
    }
}
