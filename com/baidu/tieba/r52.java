package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class r52 extends f52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    public r52() {
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

    @Override // com.baidu.tieba.f52
    public void a(g52 g52Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, g52Var, canvas) == null) && this.a != null) {
            int alpha = g52Var.b.getAlpha();
            g52Var.c(g52Var.b);
            canvas.drawRect(this.a, g52Var.b);
            g52Var.b.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.f52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = qp3.g((float) jSONArray.optDouble(0));
                    int g2 = qp3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, qp3.g((float) jSONArray.optDouble(2)) + g, qp3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (js1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
