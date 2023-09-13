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
public class ul4 extends nk4<am4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ul4(cj4 cj4Var, nm4 nm4Var) {
        super(cj4Var, nm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cj4Var, nm4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((cj4) objArr2[0], (nm4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: u */
    public bk4 d(String str, am4 am4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, am4Var)) == null) {
            if (am4Var != null && (i = am4Var.a) != 0) {
                return new bk4(i, am4Var.b);
            }
            return super.d(str, am4Var);
        }
        return (bk4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: x */
    public am4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return oo4.e(jSONObject);
        }
        return (am4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.nk4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(am4 am4Var) {
        InterceptResult invokeL;
        List<ik4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, am4Var)) == null) {
            if (am4Var == null || (list = am4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (ik4 ik4Var : am4Var.c) {
                if (ik4Var == null || !ik4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            nm4 nm4Var = this.b;
            if ((nm4Var instanceof gm4) && ((gm4) nm4Var).f().size() != am4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: w */
    public bk4 s(am4 am4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, am4Var)) == null) {
            this.a.E();
            po4 po4Var = new po4();
            m(am4Var.c, po4Var);
            if (po4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(po4Var);
            sk4.f(am4Var.c, this.a);
            return null;
        }
        return (bk4) invokeL.objValue;
    }
}
