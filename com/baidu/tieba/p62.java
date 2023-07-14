package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class p62 extends b52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;

    public p62() {
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
        this.d = -1.0f;
        this.e = 0.0f;
        this.f = 1.0f;
    }

    @Override // com.baidu.tieba.b52
    public void a(c52 c52Var, Canvas canvas) {
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, c52Var, canvas) == null) && !TextUtils.isEmpty(this.a)) {
            TextPaint textPaint = c52Var.e;
            int i = c52Var.k;
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
            if (this.e == 0.0d) {
                Rect rect = new Rect();
                String str = this.a;
                textPaint.getTextBounds(str, 0, str.length(), rect);
                if (this.d != -1.0f) {
                    float f7 = this.d;
                    if (rect.width() > f7) {
                        this.e = f7 / rect.width();
                    }
                }
                this.e = 1.0f;
            }
            canvas.save();
            int alpha = textPaint.getAlpha();
            int color = textPaint.getColor();
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(this.f);
            textPaint.setColor(c52Var.m);
            c52Var.c(textPaint);
            canvas.scale(this.e, 1.0f);
            canvas.drawText(this.a, this.b, f, textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setAlpha(alpha);
            textPaint.setColor(color);
            canvas.restore();
        }
    }

    @Override // com.baidu.tieba.b52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 2) {
                    this.a = jSONArray.optString(0);
                    this.b = mp3.g((float) jSONArray.optDouble(1));
                    this.c = mp3.g((float) jSONArray.optDouble(2));
                    if (jSONArray.length() > 3) {
                        this.d = mp3.g((float) jSONArray.optDouble(3));
                    }
                    this.f = mp3.g(1.0f);
                }
            } catch (Exception e) {
                if (fs1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
