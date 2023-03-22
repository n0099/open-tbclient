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
/* loaded from: classes6.dex */
public class r12 extends z02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF a;

    public r12() {
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

    @Override // com.baidu.tieba.z02
    public void a(a12 a12Var, Canvas canvas) {
        RectF rectF;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, a12Var, canvas) == null) && (rectF = this.a) != null) {
            a12Var.f.addRect(rectF, Path.Direction.CW);
        }
    }

    @Override // com.baidu.tieba.z02
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = kl3.g((float) jSONArray.optDouble(0));
                    int g2 = kl3.g((float) jSONArray.optDouble(1));
                    this.a = new RectF(g, g2, g + kl3.g((float) jSONArray.optDouble(2)), g2 + kl3.g((float) jSONArray.optDouble(3)));
                }
            } catch (Exception e) {
                if (do1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
