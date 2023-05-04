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
/* loaded from: classes5.dex */
public class ki4 extends dh4<qi4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.dh4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "getdeplist" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ki4(sf4 sf4Var, dj4 dj4Var) {
        super(sf4Var, dj4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sf4Var, dj4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((sf4) objArr2[0], (dj4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh4
    /* renamed from: v */
    public rg4 e(String str, qi4 qi4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, qi4Var)) == null) {
            if (qi4Var != null && (i = qi4Var.a) != 0) {
                return new rg4(i, qi4Var.b);
            }
            return super.e(str, qi4Var);
        }
        return (rg4) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh4
    /* renamed from: y */
    public qi4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) {
            return el4.e(jSONObject);
        }
        return (qi4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    @Override // com.baidu.tieba.dh4
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(qi4 qi4Var) {
        InterceptResult invokeL;
        List<yg4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qi4Var)) == null) {
            if (qi4Var == null || (list = qi4Var.c) == null || list.isEmpty()) {
                return false;
            }
            for (yg4 yg4Var : qi4Var.c) {
                if (yg4Var == null || !yg4Var.a()) {
                    return false;
                }
                while (r1.hasNext()) {
                }
            }
            dj4 dj4Var = this.b;
            if ((dj4Var instanceof wi4) && ((wi4) dj4Var).f().size() != qi4Var.c.size()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh4
    /* renamed from: x */
    public rg4 t(qi4 qi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, qi4Var)) == null) {
            this.a.E();
            fl4 fl4Var = new fl4();
            n(qi4Var.c, fl4Var);
            if (fl4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(fl4Var);
            ih4.f(qi4Var.c, this.a);
            return null;
        }
        return (rg4) invokeL.objValue;
    }
}
