package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class uu3 implements xu3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ru3 a;

    public uu3(ru3 ru3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ru3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ru3Var;
    }

    @Override // com.baidu.tieba.xu3
    public void a(yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yu3Var) == null) {
            setResult(yu3Var);
        }
    }

    private void setResult(yu3 yu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, yu3Var) == null) {
            this.a.d.clear();
            if (yu3Var != null) {
                this.a.d.putString("functionType", yu3Var.a());
                this.a.d.putString("resultData", yu3Var.b());
                this.a.d.putInt("resultStatus", yu3Var.c());
            }
            this.a.c();
        }
    }
}
