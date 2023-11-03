package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class tu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xu[] a;

    public tu() {
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
        this.a = new xu[]{new yu(8, 0), new zu(0, 1), new zu(1, 1), new yu(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        wu wuVar = new wu();
        byte[] b = uu.b(bArr, bArr.length + ((this.a.length + 1) * wu.b));
        uu.a(b, wuVar.b(), bArr.length);
        int i = 0;
        while (true) {
            xu[] xuVarArr = this.a;
            if (i >= xuVarArr.length) {
                return Arrays.copyOf(wuVar.b(), wu.b);
            }
            xu xuVar = xuVarArr[i];
            i++;
            int length = bArr.length + (wu.b * i);
            wuVar.a(xuVar.b(b, 0, length), xuVar.a(), xuVar.c(), xuVar.d());
            uu.a(b, wuVar.b(), length);
        }
    }
}
