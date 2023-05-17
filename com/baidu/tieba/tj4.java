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
public class tj4 extends mi4<zj4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.mi4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tj4(bh4 bh4Var, mk4 mk4Var) {
        super(bh4Var, mk4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bh4Var, mk4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bh4) objArr2[0], (mk4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4
    /* renamed from: u */
    public ai4 d(String str, zj4 zj4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, zj4Var)) == null) {
            if (zj4Var != null && (i = zj4Var.a) != 0) {
                return new ai4(i, zj4Var.b);
            }
            return super.d(str, zj4Var);
        }
        return (ai4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4
    /* renamed from: x */
    public zj4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return nm4.e(jSONObject);
        }
        return (zj4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.mi4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(zj4 zj4Var) {
        InterceptResult invokeL;
        List<hi4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zj4Var)) == null) {
            if (zj4Var == null || (list = zj4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (hi4 hi4Var : zj4Var.c) {
                if (hi4Var == null || !hi4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            mk4 mk4Var = this.b;
            if ((mk4Var instanceof fk4) && ((fk4) mk4Var).f().size() != zj4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4
    /* renamed from: w */
    public ai4 s(zj4 zj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zj4Var)) == null) {
            this.a.E();
            om4 om4Var = new om4();
            m(zj4Var.c, om4Var);
            if (om4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(om4Var);
            ri4.f(zj4Var.c, this.a);
            return null;
        }
        return (ai4) invokeL.objValue;
    }
}
