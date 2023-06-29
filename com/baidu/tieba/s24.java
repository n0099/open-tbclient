package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s24 implements v24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p24 a;

    public s24(p24 p24Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p24Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = p24Var;
    }

    @Override // com.baidu.tieba.v24
    public void a(w24 w24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w24Var) == null) {
            setResult(w24Var);
        }
    }

    private void setResult(w24 w24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, w24Var) == null) {
            this.a.d.clear();
            if (w24Var != null) {
                this.a.d.putString("functionType", w24Var.a());
                this.a.d.putString("resultData", w24Var.b());
                this.a.d.putInt("resultStatus", w24Var.c());
            }
            this.a.c();
        }
    }
}
