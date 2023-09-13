package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s3(w3 w3Var, float[] fArr, short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w3Var, fArr, sArr};
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
        float f = w3Var.b;
        float f2 = w3Var.c;
        float f3 = w3Var.d - f;
        float f4 = w3Var.e - f2;
        int i3 = w3Var.f;
        int i4 = w3Var.g;
        int length = fArr.length;
        for (int i5 = 0; i5 < length; i5 += 2) {
            fArr2[i5] = ((fArr[i5] / i3) * f3) + f;
            int i6 = i5 + 1;
            fArr2[i6] = ((1.0f - (fArr[i6] / i4)) * f4) + f2;
        }
    }
}
