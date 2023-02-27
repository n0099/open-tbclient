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
public class zj4 extends si4<fk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.si4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zj4(hh4 hh4Var, sk4 sk4Var) {
        super(hh4Var, sk4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hh4Var, sk4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((hh4) objArr2[0], (sk4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.si4
    /* renamed from: v */
    public gi4 e(String str, fk4 fk4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, fk4Var)) == null) {
            if (fk4Var != null && (i = fk4Var.a) != 0) {
                return new gi4(i, fk4Var.b);
            }
            return super.e(str, fk4Var);
        }
        return (gi4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.si4
    /* renamed from: y */
    public fk4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return tm4.e(jSONObject);
        }
        return (fk4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.si4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(fk4 fk4Var) {
        InterceptResult invokeL;
        List<ni4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fk4Var)) == null) {
            if (fk4Var == null || (list = fk4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (ni4 ni4Var : fk4Var.c) {
                if (ni4Var == null || !ni4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            sk4 sk4Var = this.b;
            if ((sk4Var instanceof lk4) && ((lk4) sk4Var).f().size() != fk4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.si4
    /* renamed from: x */
    public gi4 t(fk4 fk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fk4Var)) == null) {
            this.a.E();
            um4 um4Var = new um4();
            n(fk4Var.c, um4Var);
            if (um4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(um4Var);
            xi4.f(fk4Var.c, this.a);
            return null;
        }
        return (gi4) invokeL.objValue;
    }
}
