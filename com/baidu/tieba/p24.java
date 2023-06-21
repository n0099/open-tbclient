package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p24 implements s24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m24 a;

    public p24(m24 m24Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m24Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m24Var;
    }

    @Override // com.baidu.tieba.s24
    public void a(t24 t24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t24Var) == null) {
            setResult(t24Var);
        }
    }

    private void setResult(t24 t24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, t24Var) == null) {
            this.a.d.clear();
            if (t24Var != null) {
                this.a.d.putString("functionType", t24Var.a());
                this.a.d.putString("resultData", t24Var.b());
                this.a.d.putInt("resultStatus", t24Var.c());
            }
            this.a.c();
        }
    }
}
