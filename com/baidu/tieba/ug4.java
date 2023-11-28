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
public class ug4 extends nf4<ah4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nf4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ug4(ce4 ce4Var, nh4 nh4Var) {
        super(ce4Var, nh4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ce4Var, nh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ce4) objArr2[0], (nh4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nf4
    /* renamed from: u */
    public bf4 d(String str, ah4 ah4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ah4Var)) == null) {
            if (ah4Var != null && (i = ah4Var.a) != 0) {
                return new bf4(i, ah4Var.b);
            }
            return super.d(str, ah4Var);
        }
        return (bf4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nf4
    /* renamed from: x */
    public ah4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return oj4.e(jSONObject);
        }
        return (ah4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.nf4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(ah4 ah4Var) {
        InterceptResult invokeL;
        List<if4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ah4Var)) == null) {
            if (ah4Var == null || (list = ah4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (if4 if4Var : ah4Var.c) {
                if (if4Var == null || !if4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            nh4 nh4Var = this.b;
            if ((nh4Var instanceof gh4) && ((gh4) nh4Var).f().size() != ah4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nf4
    /* renamed from: w */
    public bf4 s(ah4 ah4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ah4Var)) == null) {
            this.a.E();
            pj4 pj4Var = new pj4();
            m(ah4Var.c, pj4Var);
            if (pj4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(pj4Var);
            sf4.f(ah4Var.c, this.a);
            return null;
        }
        return (bf4) invokeL.objValue;
    }
}
