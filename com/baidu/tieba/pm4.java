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
public class pm4 extends il4<vm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.il4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pm4(xj4 xj4Var, in4 in4Var) {
        super(xj4Var, in4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xj4Var, in4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((xj4) objArr2[0], (in4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.il4
    /* renamed from: u */
    public wk4 d(String str, vm4 vm4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, vm4Var)) == null) {
            if (vm4Var != null && (i = vm4Var.a) != 0) {
                return new wk4(i, vm4Var.b);
            }
            return super.d(str, vm4Var);
        }
        return (wk4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.il4
    /* renamed from: x */
    public vm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return jp4.e(jSONObject);
        }
        return (vm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.il4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(vm4 vm4Var) {
        InterceptResult invokeL;
        List<dl4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vm4Var)) == null) {
            if (vm4Var == null || (list = vm4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (dl4 dl4Var : vm4Var.c) {
                if (dl4Var == null || !dl4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            in4 in4Var = this.b;
            if ((in4Var instanceof bn4) && ((bn4) in4Var).f().size() != vm4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.il4
    /* renamed from: w */
    public wk4 s(vm4 vm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, vm4Var)) == null) {
            this.a.E();
            kp4 kp4Var = new kp4();
            m(vm4Var.c, kp4Var);
            if (kp4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(kp4Var);
            nl4.f(vm4Var.c, this.a);
            return null;
        }
        return (wk4) invokeL.objValue;
    }
}
