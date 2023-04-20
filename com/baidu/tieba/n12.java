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
public class n12 extends b12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    public n12() {
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

    @Override // com.baidu.tieba.b12
    public void a(c12 c12Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, c12Var, canvas) == null) && this.a != null) {
            int alpha = c12Var.b.getAlpha();
            c12Var.c(c12Var.b);
            canvas.drawRect(this.a, c12Var.b);
            c12Var.b.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.b12
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = ml3.g((float) jSONArray.optDouble(0));
                    int g2 = ml3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, ml3.g((float) jSONArray.optDouble(2)) + g, ml3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (fo1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
