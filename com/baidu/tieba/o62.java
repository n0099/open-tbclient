package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class o62 extends f52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;

    public o62() {
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

    @Override // com.baidu.tieba.f52
    public void a(g52 g52Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, g52Var, canvas) == null) {
            if (g52Var.a() == 0) {
                g52Var.b(canvas.save());
            } else {
                canvas.restoreToCount(g52Var.a());
                g52Var.b(canvas.save());
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{this.a, this.c, this.e, this.b, this.d, this.f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // com.baidu.tieba.f52
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.a = (float) jSONArray.optDouble(0);
                    this.b = (float) jSONArray.optDouble(1);
                    this.c = (float) jSONArray.optDouble(2);
                    this.d = (float) jSONArray.optDouble(3);
                    this.e = qp3.g((float) jSONArray.optDouble(4));
                    this.f = qp3.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e) {
                if (js1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
