package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class v52 extends j42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path a;

    public v52() {
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

    @Override // com.baidu.tieba.j42
    public void a(k42 k42Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, k42Var, canvas) == null) && this.a != null) {
            int alpha = k42Var.c.getAlpha();
            k42Var.c(k42Var.c);
            canvas.drawPath(this.a, k42Var.c);
            k42Var.c.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.j42
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = uo3.g((float) jSONArray.optDouble(0));
                    int g2 = uo3.g((float) jSONArray.optDouble(1));
                    int g3 = uo3.g((float) jSONArray.optDouble(2));
                    int g4 = uo3.g((float) jSONArray.optDouble(3));
                    Path path = new Path();
                    this.a = path;
                    path.addRect(new RectF(g, g2, g + g3, g2 + g4), Path.Direction.CW);
                }
            } catch (Exception e) {
                if (nr1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
