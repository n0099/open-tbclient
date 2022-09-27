package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class sx1 extends rw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DashPathEffect a;

    public sx1() {
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

    @Override // com.baidu.tieba.rw1
    public void a(sw1 sw1Var, Canvas canvas) {
        DashPathEffect dashPathEffect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, sw1Var, canvas) == null) || (dashPathEffect = this.a) == null) {
            return;
        }
        sw1Var.c.setPathEffect(dashPathEffect);
    }

    @Override // com.baidu.tieba.rw1
    public void b(JSONArray jSONArray) {
        float[] fArr;
        JSONArray optJSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            if (jSONArray.length() <= 0 || (optJSONArray = jSONArray.optJSONArray(0)) == null || (length = optJSONArray.length()) <= 0) {
                fArr = null;
            } else {
                fArr = new float[length];
                for (int i = 0; i < length; i++) {
                    fArr[i] = ch3.g((float) optJSONArray.optDouble(i));
                }
            }
            int g = jSONArray.length() > 1 ? ch3.g((float) jSONArray.optDouble(1)) : 0;
            if (fArr == null || g < 0) {
                return;
            }
            this.a = new DashPathEffect(fArr, g);
        }
    }
}
