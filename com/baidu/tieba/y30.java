package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class y30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b40[] a;

    public y30() {
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
        this.a = new b40[]{new c40(8, 0), new d40(0, 1), new d40(1, 1), new c40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        a40 a40Var = new a40();
        byte[] b = z30.b(bArr, bArr.length + ((this.a.length + 1) * a40.b));
        z30.a(b, a40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            b40[] b40VarArr = this.a;
            if (i >= b40VarArr.length) {
                return Arrays.copyOf(a40Var.b(), a40.b);
            }
            b40 b40Var = b40VarArr[i];
            i++;
            int length = bArr.length + (a40.b * i);
            a40Var.a(b40Var.b(b, 0, length), b40Var.a(), b40Var.c(), b40Var.d());
            z30.a(b, a40Var.b(), length);
        }
    }
}
