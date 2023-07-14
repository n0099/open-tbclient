package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nm4 extends bl4<tm4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public qj4 d;
    @Nullable
    public qj4 e;

    @Override // com.baidu.tieba.bl4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: u */
    public boolean e(tm4 tm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tm4Var)) == null) ? tm4Var != null : invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm4(qj4 qj4Var, bn4 bn4Var, @Nullable qj4 qj4Var2, @Nullable qj4 qj4Var3) {
        super(qj4Var, bn4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qj4Var, bn4Var, qj4Var2, qj4Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qj4) objArr2[0], (bn4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = qj4Var2;
        this.e = qj4Var3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: w */
    public tm4 t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            return cp4.q(jSONObject);
        }
        return (tm4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bl4
    /* renamed from: v */
    public pk4 s(tm4 tm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tm4Var)) == null) {
            this.a.E();
            wo4.e(this.b.a(), tm4Var.a);
            qj4 qj4Var = this.a;
            if (qj4Var == this.d || qj4Var == this.e) {
                qj4Var = null;
            }
            in4.c(tm4Var.b, qj4Var, this.d, this.e);
            return null;
        }
        return (pk4) invokeL.objValue;
    }
}
