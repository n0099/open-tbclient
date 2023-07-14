package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l24 implements o24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i24 a;

    public l24(i24 i24Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i24Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i24Var;
    }

    @Override // com.baidu.tieba.o24
    public void a(p24 p24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p24Var) == null) {
            setResult(p24Var);
        }
    }

    private void setResult(p24 p24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, p24Var) == null) {
            this.a.d.clear();
            if (p24Var != null) {
                this.a.d.putString("functionType", p24Var.a());
                this.a.d.putString("resultData", p24Var.b());
                this.a.d.putInt("resultStatus", p24Var.c());
            }
            this.a.c();
        }
    }
}
