package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yl4 extends nk4<em4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;

    @Override // com.baidu.tieba.nk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yl4(String str, cj4 cj4Var, nm4 nm4Var) {
        super(cj4Var, nm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cj4Var, nm4Var};
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
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: w */
    public em4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return oo4.i(this.d, jSONObject);
        }
        return (em4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: u */
    public boolean e(em4 em4Var) {
        InterceptResult invokeL;
        List<hk4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, em4Var)) == null) {
            if (em4Var == null || (list = em4Var.a) == null) {
                return false;
            }
            for (hk4 hk4Var : list) {
                if (!hk4Var.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: v */
    public bk4 s(em4 em4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, em4Var)) == null) {
            this.a.E();
            po4 po4Var = new po4();
            o(em4Var.a, po4Var);
            if (po4Var.n() == 0) {
                this.a.F();
                return null;
            }
            this.a.G(po4Var);
            sk4.d(em4Var, this.a);
            return null;
        }
        return (bk4) invokeL.objValue;
    }
}
