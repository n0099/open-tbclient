package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ot3 implements rt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lt3 a;

    public ot3(lt3 lt3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lt3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lt3Var;
    }

    private void setResult(st3 st3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, st3Var) == null) {
            this.a.d.clear();
            if (st3Var != null) {
                this.a.d.putString("functionType", st3Var.a());
                this.a.d.putString("resultData", st3Var.b());
                this.a.d.putInt("resultStatus", st3Var.c());
            }
            this.a.c();
        }
    }

    @Override // com.baidu.tieba.rt3
    public void a(st3 st3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, st3Var) == null) {
            setResult(st3Var);
        }
    }
}
