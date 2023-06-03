package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o24 implements r24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l24 a;

    public o24(l24 l24Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l24Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = l24Var;
    }

    @Override // com.baidu.tieba.r24
    public void a(s24 s24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s24Var) == null) {
            setResult(s24Var);
        }
    }

    private void setResult(s24 s24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, s24Var) == null) {
            this.a.d.clear();
            if (s24Var != null) {
                this.a.d.putString("functionType", s24Var.a());
                this.a.d.putString("resultData", s24Var.b());
                this.a.d.putInt("resultStatus", s24Var.c());
            }
            this.a.c();
        }
    }
}
