package com.baidu.tieba;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class z42 extends j42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    public z42() {
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
        this.a = Integer.MAX_VALUE;
        this.b = Integer.MAX_VALUE;
    }

    @Override // com.baidu.tieba.j42
    public void a(k42 k42Var, Canvas canvas) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, k42Var, canvas) == null) && (i = this.a) != Integer.MAX_VALUE && (i2 = this.b) != Integer.MAX_VALUE) {
            k42Var.f.moveTo(i, i2);
        }
    }

    @Override // com.baidu.tieba.j42
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray.length() > 1) {
            this.a = uo3.g((float) jSONArray.optDouble(0));
            this.b = uo3.g((float) jSONArray.optDouble(1));
        }
    }
}
