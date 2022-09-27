package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class rx1 extends rw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint.Cap a;

    public rx1() {
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
        Paint.Cap cap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, sw1Var, canvas) == null) || (cap = this.a) == null) {
            return;
        }
        sw1Var.c.setStrokeCap(cap);
    }

    @Override // com.baidu.tieba.rw1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 0) {
            return;
        }
        String optString = jSONArray.optString(0);
        if (TextUtils.equals(optString, "butt")) {
            this.a = Paint.Cap.BUTT;
        } else if (TextUtils.equals(optString, "round")) {
            this.a = Paint.Cap.ROUND;
        } else if (TextUtils.equals(optString, "square")) {
            this.a = Paint.Cap.SQUARE;
        }
    }
}
