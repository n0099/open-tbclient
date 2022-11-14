package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vu3 implements yu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public su3 a;

    public vu3(su3 su3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {su3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = su3Var;
    }

    @Override // com.baidu.tieba.yu3
    public void a(zu3 zu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zu3Var) == null) {
            setResult(zu3Var);
        }
    }

    private void setResult(zu3 zu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, zu3Var) == null) {
            this.a.d.clear();
            if (zu3Var != null) {
                this.a.d.putString("functionType", zu3Var.a());
                this.a.d.putString("resultData", zu3Var.b());
                this.a.d.putInt("resultStatus", zu3Var.c());
            }
            this.a.c();
        }
    }
}
