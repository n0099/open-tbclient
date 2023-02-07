package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mz3 implements pz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jz3 a;

    public mz3(jz3 jz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jz3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jz3Var;
    }

    @Override // com.baidu.tieba.pz3
    public void a(qz3 qz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qz3Var) == null) {
            setResult(qz3Var);
        }
    }

    private void setResult(qz3 qz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, qz3Var) == null) {
            this.a.d.clear();
            if (qz3Var != null) {
                this.a.d.putString("functionType", qz3Var.a());
                this.a.d.putString("resultData", qz3Var.b());
                this.a.d.putInt(com.alipay.sdk.util.j.a, qz3Var.c());
            }
            this.a.c();
        }
    }
}
