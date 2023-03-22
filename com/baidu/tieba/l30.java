package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class l30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o30[] a;

    public l30() {
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
        this.a = new o30[]{new p30(8, 0), new q30(0, 1), new q30(1, 1), new p30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        n30 n30Var = new n30();
        byte[] b = m30.b(bArr, bArr.length + ((this.a.length + 1) * n30.b));
        m30.a(b, n30Var.b(), bArr.length);
        int i = 0;
        while (true) {
            o30[] o30VarArr = this.a;
            if (i >= o30VarArr.length) {
                return Arrays.copyOf(n30Var.b(), n30.b);
            }
            o30 o30Var = o30VarArr[i];
            i++;
            int length = bArr.length + (n30.b * i);
            n30Var.a(o30Var.b(b, 0, length), o30Var.a(), o30Var.c(), o30Var.d());
            m30.a(b, n30Var.b(), length);
        }
    }
}
