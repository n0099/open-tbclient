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
public class tg4 extends mf4<zg4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.mf4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tg4(be4 be4Var, mh4 mh4Var) {
        super(be4Var, mh4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {be4Var, mh4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((be4) objArr2[0], (mh4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf4
    /* renamed from: u */
    public af4 d(String str, zg4 zg4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, zg4Var)) == null) {
            if (zg4Var != null && (i = zg4Var.a) != 0) {
                return new af4(i, zg4Var.b);
            }
            return super.d(str, zg4Var);
        }
        return (af4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf4
    /* renamed from: x */
    public zg4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return nj4.e(jSONObject);
        }
        return (zg4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.mf4
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(zg4 zg4Var) {
        InterceptResult invokeL;
        List<hf4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zg4Var)) == null) {
            if (zg4Var == null || (list = zg4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (hf4 hf4Var : zg4Var.c) {
                if (hf4Var == null || !hf4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            mh4 mh4Var = this.b;
            if ((mh4Var instanceof fh4) && ((fh4) mh4Var).f().size() != zg4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf4
    /* renamed from: w */
    public af4 s(zg4 zg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zg4Var)) == null) {
            this.a.E();
            oj4 oj4Var = new oj4();
            m(zg4Var.c, oj4Var);
            if (oj4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(oj4Var);
            rf4.f(zg4Var.c, this.a);
            return null;
        }
        return (af4) invokeL.objValue;
    }
}
