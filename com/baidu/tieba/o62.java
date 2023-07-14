package com.baidu.tieba;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class o62 extends b52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j52 a;

    public o62() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.b52
    public void a(c52 c52Var, Canvas canvas) {
        j52 j52Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, c52Var, canvas) == null) && (j52Var = this.a) != null && j52Var.d()) {
            if (this.a.c()) {
                c52Var.c.setShader(this.a.b());
                return;
            }
            c52Var.m = this.a.a();
            c52Var.c.setColor(this.a.a());
            c52Var.b.setShader(null);
        }
    }

    @Override // com.baidu.tieba.b52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray.length() > 0) {
            this.a = new j52(jSONArray);
        }
    }
}
