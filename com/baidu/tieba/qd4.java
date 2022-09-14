package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qd4 extends ec4<wd4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ta4 d;
    @Nullable
    public ta4 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qd4(ta4 ta4Var, ee4 ee4Var, @Nullable ta4 ta4Var2, @Nullable ta4 ta4Var3) {
        super(ta4Var, ee4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ta4Var, ee4Var, ta4Var2, ta4Var3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ta4) objArr2[0], (ee4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = ta4Var2;
        this.e = ta4Var3;
    }

    @Override // com.baidu.tieba.ec4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: v */
    public boolean f(wd4 wd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wd4Var)) == null) ? wd4Var != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: w */
    public sb4 t(wd4 wd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wd4Var)) == null) {
            this.a.E();
            zf4.e(this.b.a(), wd4Var.a);
            ta4 ta4Var = this.a;
            if (ta4Var == this.d || ta4Var == this.e) {
                ta4Var = null;
            }
            le4.c(wd4Var.b, ta4Var, this.d, this.e);
            return null;
        }
        return (sb4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ec4
    /* renamed from: x */
    public wd4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? fg4.q(jSONObject) : (wd4) invokeL.objValue;
    }
}
