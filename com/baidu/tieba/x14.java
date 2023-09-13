package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x14 implements a24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u14 a;

    public x14(u14 u14Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u14Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = u14Var;
    }

    @Override // com.baidu.tieba.a24
    public void a(b24 b24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b24Var) == null) {
            setResult(b24Var);
        }
    }

    private void setResult(b24 b24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, b24Var) == null) {
            this.a.d.clear();
            if (b24Var != null) {
                this.a.d.putString("functionType", b24Var.a());
                this.a.d.putString("resultData", b24Var.b());
                this.a.d.putInt("resultStatus", b24Var.c());
            }
            this.a.c();
        }
    }
}
