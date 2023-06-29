package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class v52 extends i52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;

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

    @Override // com.baidu.tieba.i52
    public void a(j52 j52Var, Canvas canvas) {
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, j52Var, canvas) == null) && !TextUtils.isEmpty(this.a)) {
            TextPaint textPaint = j52Var.e;
            int i = j52Var.k;
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f2 = fontMetrics.top;
            int i2 = this.c;
            float f3 = i2 + f2;
            float f4 = fontMetrics.ascent + i2;
            float f5 = fontMetrics.bottom;
            float f6 = i2 + f5;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        f = i2;
                    } else {
                        f = i2 - (f4 - f3);
                    }
                } else {
                    f = (i2 + ((f5 - f2) / 2.0f)) - f5;
                }
            } else {
                f = i2 + ((f6 - f3) / 2.0f) + (f4 - f3);
            }
            int alpha = textPaint.getAlpha();
            j52Var.c(textPaint);
            canvas.drawText(this.a, this.b, f, textPaint);
            textPaint.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.i52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.a = jSONArray.optString(0);
                    this.b = tp3.g((float) jSONArray.optDouble(1));
                    this.c = tp3.g((float) jSONArray.optDouble(2));
                }
            } catch (Exception e) {
                if (ms1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
