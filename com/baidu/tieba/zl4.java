package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zl4 extends nk4<fm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public cj4 d;
    @Nullable
    public cj4 e;

    @Override // com.baidu.tieba.nk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: u */
    public boolean e(fm4 fm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fm4Var)) == null) ? fm4Var != null : invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zl4(cj4 cj4Var, nm4 nm4Var, @Nullable cj4 cj4Var2, @Nullable cj4 cj4Var3) {
        super(cj4Var, nm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cj4Var, nm4Var, cj4Var2, cj4Var3};
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
        this.d = cj4Var2;
        this.e = cj4Var3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: w */
    public fm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return oo4.q(jSONObject);
        }
        return (fm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nk4
    /* renamed from: v */
    public bk4 s(fm4 fm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fm4Var)) == null) {
            this.a.E();
            io4.e(this.b.a(), fm4Var.a);
            cj4 cj4Var = this.a;
            if (cj4Var == this.d || cj4Var == this.e) {
                cj4Var = null;
            }
            um4.c(fm4Var.b, cj4Var, this.d, this.e);
            return null;
        }
        return (bk4) invokeL.objValue;
    }
}
