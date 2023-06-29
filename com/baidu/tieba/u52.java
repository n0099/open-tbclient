package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class u52 extends i52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    public u52() {
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

    @Override // com.baidu.tieba.i52
    public void a(j52 j52Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, j52Var, canvas) == null) && this.a != null) {
            int alpha = j52Var.b.getAlpha();
            j52Var.c(j52Var.b);
            canvas.drawRect(this.a, j52Var.b);
            j52Var.b.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.i52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = tp3.g((float) jSONArray.optDouble(0));
                    int g2 = tp3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, tp3.g((float) jSONArray.optDouble(2)) + g, tp3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (ms1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
