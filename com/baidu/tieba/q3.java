package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q3(u3 u3Var, float[] fArr, short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u3Var, fArr, sArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        float[] fArr2 = new float[fArr.length];
        float f = u3Var.b;
        float f2 = u3Var.c;
        float f3 = u3Var.d - f;
        float f4 = u3Var.e - f2;
        int i3 = u3Var.f;
        int i4 = u3Var.g;
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5 += 2) {
            fArr2[i5] = ((fArr[i5] / i3) * f3) + f;
            int i6 = i5 + 1;
            fArr2[i6] = ((1.0f - (fArr[i6] / i4)) * f4) + f2;
        }
    }
}
