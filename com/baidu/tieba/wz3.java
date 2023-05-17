package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wz3 implements zz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tz3 a;

    public wz3(tz3 tz3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tz3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tz3Var;
    }

    @Override // com.baidu.tieba.zz3
    public void a(a04 a04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a04Var) == null) {
            setResult(a04Var);
        }
    }

    private void setResult(a04 a04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, a04Var) == null) {
            this.a.d.clear();
            if (a04Var != null) {
                this.a.d.putString("functionType", a04Var.a());
                this.a.d.putString("resultData", a04Var.b());
                this.a.d.putInt("resultStatus", a04Var.c());
            }
            this.a.c();
        }
    }
}
