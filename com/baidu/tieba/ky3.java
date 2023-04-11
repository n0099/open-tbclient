package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ky3 implements ny3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hy3 a;

    public ky3(hy3 hy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hy3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hy3Var;
    }

    @Override // com.baidu.tieba.ny3
    public void a(oy3 oy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oy3Var) == null) {
            setResult(oy3Var);
        }
    }

    private void setResult(oy3 oy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, oy3Var) == null) {
            this.a.d.clear();
            if (oy3Var != null) {
                this.a.d.putString("functionType", oy3Var.a());
                this.a.d.putString("resultData", oy3Var.b());
                this.a.d.putInt("resultStatus", oy3Var.c());
            }
            this.a.c();
        }
    }
}
