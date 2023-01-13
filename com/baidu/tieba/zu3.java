package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zu3 implements cv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wu3 a;

    public zu3(wu3 wu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wu3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wu3Var;
    }

    @Override // com.baidu.tieba.cv3
    public void a(dv3 dv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dv3Var) == null) {
            setResult(dv3Var);
        }
    }

    private void setResult(dv3 dv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, dv3Var) == null) {
            this.a.d.clear();
            if (dv3Var != null) {
                this.a.d.putString("functionType", dv3Var.a());
                this.a.d.putString("resultData", dv3Var.b());
                this.a.d.putInt(com.alipay.sdk.util.j.a, dv3Var.c());
            }
            this.a.c();
        }
    }
}
