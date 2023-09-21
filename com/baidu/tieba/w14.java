package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w14 implements z14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t14 a;

    public w14(t14 t14Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t14Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t14Var;
    }

    @Override // com.baidu.tieba.z14
    public void a(a24 a24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a24Var) == null) {
            setResult(a24Var);
        }
    }

    private void setResult(a24 a24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, a24Var) == null) {
            this.a.d.clear();
            if (a24Var != null) {
                this.a.d.putString("functionType", a24Var.a());
                this.a.d.putString("resultData", a24Var.b());
                this.a.d.putInt("resultStatus", a24Var.c());
            }
            this.a.c();
        }
    }
}
