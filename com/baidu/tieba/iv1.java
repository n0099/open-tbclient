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
/* loaded from: classes4.dex */
public class iv1 extends gu1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint.Join a;

    public iv1() {
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
        Paint.Join join;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, hu1Var, canvas) == null) || (join = this.a) == null) {
            return;
        }
        hu1Var.c.setStrokeJoin(join);
    }

    @Override // com.baidu.tieba.gu1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 0) {
            return;
        }
        String optString = jSONArray.optString(0);
        if (TextUtils.equals(optString, "bevel")) {
            this.a = Paint.Join.BEVEL;
        } else if (TextUtils.equals(optString, "round")) {
            this.a = Paint.Join.ROUND;
        } else if (TextUtils.equals(optString, "miter")) {
            this.a = Paint.Join.MITER;
        }
    }
}
