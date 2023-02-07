package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class o22 extends c22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    public o22() {
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

    @Override // com.baidu.tieba.c22
    public void a(d22 d22Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, d22Var, canvas) == null) && this.a != null) {
            int alpha = d22Var.b.getAlpha();
            d22Var.c(d22Var.b);
            canvas.drawRect(this.a, d22Var.b);
            d22Var.b.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.c22
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = nm3.g((float) jSONArray.optDouble(0));
                    int g2 = nm3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, nm3.g((float) jSONArray.optDouble(2)) + g, nm3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (gp1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
