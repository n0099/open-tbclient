package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class jy3 implements my3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gy3 a;

    public jy3(gy3 gy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gy3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gy3Var;
    }

    @Override // com.baidu.tieba.my3
    public void a(ny3 ny3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ny3Var) == null) {
            setResult(ny3Var);
        }
    }

    private void setResult(ny3 ny3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, ny3Var) == null) {
            this.a.d.clear();
            if (ny3Var != null) {
                this.a.d.putString("functionType", ny3Var.a());
                this.a.d.putString("resultData", ny3Var.b());
                this.a.d.putInt("resultStatus", ny3Var.c());
            }
            this.a.c();
        }
    }
}
