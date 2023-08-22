package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t14 implements w14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q14 a;

    public t14(q14 q14Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q14Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q14Var;
    }

    @Override // com.baidu.tieba.w14
    public void a(x14 x14Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, x14Var) == null) {
            setResult(x14Var);
        }
    }

    private void setResult(x14 x14Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, x14Var) == null) {
            this.a.d.clear();
            if (x14Var != null) {
                this.a.d.putString("functionType", x14Var.a());
                this.a.d.putString("resultData", x14Var.b());
                this.a.d.putInt("resultStatus", x14Var.c());
            }
            this.a.c();
        }
    }
}
