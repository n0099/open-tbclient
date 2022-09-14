package com.baidu.tieba;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class iw1 extends ew1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public boolean g;

    public iw1() {
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
        this.g = false;
    }

    @Override // com.baidu.tieba.ew1
    public void a(fw1 fw1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, fw1Var, canvas) == null) && this.g) {
            fw1Var.f.cubicTo(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    @Override // com.baidu.tieba.ew1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 5) {
            return;
        }
        this.a = pg3.g((float) jSONArray.optDouble(0));
        this.b = pg3.g((float) jSONArray.optDouble(1));
        this.c = pg3.g((float) jSONArray.optDouble(2));
        this.d = pg3.g((float) jSONArray.optDouble(3));
        this.e = pg3.g((float) jSONArray.optDouble(4));
        this.f = pg3.g((float) jSONArray.optDouble(5));
        this.g = true;
    }
}
