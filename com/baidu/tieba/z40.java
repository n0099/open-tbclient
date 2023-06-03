package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class z40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c50[] a;

    public z40() {
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
        this.a = new c50[]{new d50(8, 0), new e50(0, 1), new e50(1, 1), new d50(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        b50 b50Var = new b50();
        byte[] b = a50.b(bArr, bArr.length + ((this.a.length + 1) * b50.b));
        a50.a(b, b50Var.b(), bArr.length);
        int i = 0;
        while (true) {
            c50[] c50VarArr = this.a;
            if (i >= c50VarArr.length) {
                return Arrays.copyOf(b50Var.b(), b50.b);
            }
            c50 c50Var = c50VarArr[i];
            i++;
            int length = bArr.length + (b50.b * i);
            b50Var.a(c50Var.b(b, 0, length), c50Var.a(), c50Var.c(), c50Var.d());
            a50.a(b, b50Var.b(), length);
        }
    }
}
