package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ny3 implements qy3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ky3 a;

    public ny3(ky3 ky3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ky3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ky3Var;
    }

    @Override // com.baidu.tieba.qy3
    public void a(ry3 ry3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ry3Var) == null) {
            setResult(ry3Var);
        }
    }

    private void setResult(ry3 ry3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, ry3Var) == null) {
            this.a.d.clear();
            if (ry3Var != null) {
                this.a.d.putString("functionType", ry3Var.a());
                this.a.d.putString("resultData", ry3Var.b());
                this.a.d.putInt("resultStatus", ry3Var.c());
            }
            this.a.c();
        }
    }
}
