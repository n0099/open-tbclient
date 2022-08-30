package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pr3 implements sr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mr3 a;

    public pr3(mr3 mr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mr3Var;
    }

    private void setResult(tr3 tr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, tr3Var) == null) {
            this.a.d.clear();
            if (tr3Var != null) {
                this.a.d.putString("functionType", tr3Var.a());
                this.a.d.putString("resultData", tr3Var.b());
                this.a.d.putInt("resultStatus", tr3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.baidu.tieba.sr3
    public void a(tr3 tr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tr3Var) == null) {
            setResult(tr3Var);
        }
    }
}
