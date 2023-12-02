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
/* loaded from: classes9.dex */
public class xg4 extends qf4<dh4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qf4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg4(fe4 fe4Var, qh4 qh4Var) {
        super(fe4Var, qh4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fe4Var, qh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((fe4) objArr2[0], (qh4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: u */
    public ef4 d(String str, dh4 dh4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, dh4Var)) == null) {
            if (dh4Var != null && (i = dh4Var.a) != 0) {
                return new ef4(i, dh4Var.b);
            }
            return super.d(str, dh4Var);
        }
        return (ef4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: x */
    public dh4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return rj4.e(jSONObject);
        }
        return (dh4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.qf4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(dh4 dh4Var) {
        InterceptResult invokeL;
        List<lf4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dh4Var)) == null) {
            if (dh4Var == null || (list = dh4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (lf4 lf4Var : dh4Var.c) {
                if (lf4Var == null || !lf4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            qh4 qh4Var = this.b;
            if ((qh4Var instanceof jh4) && ((jh4) qh4Var).f().size() != dh4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qf4
    /* renamed from: w */
    public ef4 s(dh4 dh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, dh4Var)) == null) {
            this.a.E();
            sj4 sj4Var = new sj4();
            m(dh4Var.c, sj4Var);
            if (sj4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(sj4Var);
            vf4.f(dh4Var.c, this.a);
            return null;
        }
        return (ef4) invokeL.objValue;
    }
}
