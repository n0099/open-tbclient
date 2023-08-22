package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class o42 extends j42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;
    public Paint b;
    public PorterDuffXfermode c;

    public o42() {
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
        this.b = new Paint();
        this.c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    @Override // com.baidu.tieba.j42
    public void a(k42 k42Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, k42Var, canvas) == null) && this.a != null) {
            this.b.setXfermode(this.c);
            canvas.drawRect(this.a, this.b);
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
                    this.a = new Rect(g, g2, uo3.g((float) jSONArray.optDouble(2)) + g, uo3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (nr1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
