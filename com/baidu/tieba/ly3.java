package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ly3 implements oy3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iy3 a;

    public ly3(iy3 iy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iy3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iy3Var;
    }

    @Override // com.baidu.tieba.oy3
    public void a(py3 py3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, py3Var) == null) {
            setResult(py3Var);
        }
    }

    private void setResult(py3 py3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, py3Var) == null) {
            this.a.d.clear();
            if (py3Var != null) {
                this.a.d.putString("functionType", py3Var.a());
                this.a.d.putString("resultData", py3Var.b());
                this.a.d.putInt("resultStatus", py3Var.c());
            }
            this.a.c();
        }
    }
}
