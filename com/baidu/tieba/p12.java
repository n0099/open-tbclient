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
public class p12 extends d12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    public p12() {
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

    @Override // com.baidu.tieba.d12
    public void a(e12 e12Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, e12Var, canvas) == null) && this.a != null) {
            int alpha = e12Var.b.getAlpha();
            e12Var.c(e12Var.b);
            canvas.drawRect(this.a, e12Var.b);
            e12Var.b.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.d12
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = ol3.g((float) jSONArray.optDouble(0));
                    int g2 = ol3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, ol3.g((float) jSONArray.optDouble(2)) + g, ol3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (ho1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
