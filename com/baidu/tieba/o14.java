package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o14 implements r14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l14 a;

    public o14(l14 l14Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l14Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = l14Var;
    }

    @Override // com.baidu.tieba.r14
    public void a(s14 s14Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s14Var) == null) {
            setResult(s14Var);
        }
    }

    private void setResult(s14 s14Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, s14Var) == null) {
            this.a.d.clear();
            if (s14Var != null) {
                this.a.d.putString("functionType", s14Var.a());
                this.a.d.putString("resultData", s14Var.b());
                this.a.d.putInt("resultStatus", s14Var.c());
            }
            this.a.c();
        }
    }
}
