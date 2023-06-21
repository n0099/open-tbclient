package com.baidu.tieba;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class j52 extends f52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public boolean g;

    public j52() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
    }

    @Override // com.baidu.tieba.f52
    public void a(g52 g52Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, g52Var, canvas) == null) && this.g) {
            g52Var.f.cubicTo(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    @Override // com.baidu.tieba.f52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray.length() > 5) {
            this.a = qp3.g((float) jSONArray.optDouble(0));
            this.b = qp3.g((float) jSONArray.optDouble(1));
            this.c = qp3.g((float) jSONArray.optDouble(2));
            this.d = qp3.g((float) jSONArray.optDouble(3));
            this.e = qp3.g((float) jSONArray.optDouble(4));
            this.f = qp3.g((float) jSONArray.optDouble(5));
            this.g = true;
        }
    }
}
