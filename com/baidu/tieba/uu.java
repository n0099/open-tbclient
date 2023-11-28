package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class uu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yu[] a;

    public uu() {
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
        this.a = new yu[]{new zu(8, 0), new av(0, 1), new av(1, 1), new zu(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        xu xuVar = new xu();
        byte[] b = vu.b(bArr, bArr.length + ((this.a.length + 1) * xu.b));
        vu.a(b, xuVar.b(), bArr.length);
        int i = 0;
        while (true) {
            yu[] yuVarArr = this.a;
            if (i >= yuVarArr.length) {
                return Arrays.copyOf(xuVar.b(), xu.b);
            }
            yu yuVar = yuVarArr[i];
            i++;
            int length = bArr.length + (xu.b * i);
            xuVar.a(yuVar.b(b, 0, length), yuVar.a(), yuVar.c(), yuVar.d());
            vu.a(b, xuVar.b(), length);
        }
    }
}
