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
/* loaded from: classes4.dex */
public class iu1 extends gu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF a;
    public float b;
    public float c;
    public boolean d;

    public iu1() {
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

    @Override // com.baidu.tieba.gu1
    public void a(hu1 hu1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, hu1Var, canvas) == null) || this.a == null) {
            return;
        }
        if (!this.d && Math.abs(this.c) >= 360.0f) {
            Path path = hu1Var.f;
            RectF rectF = this.a;
            float f = rectF.bottom;
            float f2 = rectF.top;
            path.addCircle((rectF.right + rectF.left) / 2.0f, (f + f2) / 2.0f, (f - f2) / 2.0f, Path.Direction.CW);
            hu1Var.f.arcTo(this.a, 0.0f, this.b);
            return;
        }
        float f3 = this.c % 360.0f;
        if (f3 < 0.0f && !this.d) {
            f3 += 360.0f;
        } else if (f3 > 0.0f && this.d) {
            f3 -= 360.0f;
        }
        hu1Var.f.arcTo(this.a, this.b, f3);
    }

    @Override // com.baidu.tieba.gu1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            if (jSONArray.length() > 4) {
                int g = re3.g((float) jSONArray.optDouble(0));
                int g2 = re3.g((float) jSONArray.optDouble(1));
                int g3 = re3.g((float) jSONArray.optDouble(2));
                float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
                float degrees2 = (float) Math.toDegrees((float) jSONArray.optDouble(4));
                this.a = new RectF(g - g3, g2 - g3, g + g3, g2 + g3);
                this.b = degrees;
                this.c = degrees2 - degrees;
            }
            if (jSONArray.length() > 5) {
                this.d = jSONArray.optBoolean(5);
            }
        }
    }
}
