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
/* loaded from: classes4.dex */
public class lu1 extends gu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;
    public Paint b;
    public PorterDuffXfermode c;

    public lu1() {
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

    @Override // com.baidu.tieba.gu1
    public void a(hu1 hu1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, hu1Var, canvas) == null) || this.a == null) {
            return;
        }
        this.b.setXfermode(this.c);
        canvas.drawRect(this.a, this.b);
    }

    @Override // com.baidu.tieba.gu1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = re3.g((float) jSONArray.optDouble(0));
                    int g2 = re3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, re3.g((float) jSONArray.optDouble(2)) + g, re3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (kh1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
