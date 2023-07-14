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
/* loaded from: classes7.dex */
public class n62 extends b52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path a;

    public n62() {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, c52Var, canvas) == null) && this.a != null) {
            int alpha = c52Var.c.getAlpha();
            c52Var.c(c52Var.c);
            canvas.drawPath(this.a, c52Var.c);
            c52Var.c.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.b52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = mp3.g((float) jSONArray.optDouble(0));
                    int g2 = mp3.g((float) jSONArray.optDouble(1));
                    int g3 = mp3.g((float) jSONArray.optDouble(2));
                    int g4 = mp3.g((float) jSONArray.optDouble(3));
                    Path path = new Path();
                    this.a = path;
                    path.addRect(new RectF(g, g2, g + g3, g2 + g4), Path.Direction.CW);
                }
            } catch (Exception e) {
                if (fs1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
