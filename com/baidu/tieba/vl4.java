package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vl4 extends jk4<bm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public yi4 d;
    @Nullable
    public yi4 e;

    @Override // com.baidu.tieba.jk4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: u */
    public boolean e(bm4 bm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bm4Var)) == null) ? bm4Var != null : invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vl4(yi4 yi4Var, jm4 jm4Var, @Nullable yi4 yi4Var2, @Nullable yi4 yi4Var3) {
        super(yi4Var, jm4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yi4Var, jm4Var, yi4Var2, yi4Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((yi4) objArr2[0], (jm4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = yi4Var2;
        this.e = yi4Var3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: w */
    public bm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return ko4.q(jSONObject);
        }
        return (bm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk4
    /* renamed from: v */
    public xj4 s(bm4 bm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bm4Var)) == null) {
            this.a.E();
            eo4.e(this.b.a(), bm4Var.a);
            yi4 yi4Var = this.a;
            if (yi4Var == this.d || yi4Var == this.e) {
                yi4Var = null;
            }
            qm4.c(bm4Var.b, yi4Var, this.d, this.e);
            return null;
        }
        return (xj4) invokeL.objValue;
    }
}
