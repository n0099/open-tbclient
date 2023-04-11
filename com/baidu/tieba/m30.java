package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class m30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p30[] a;

    public m30() {
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
        this.a = new p30[]{new q30(8, 0), new r30(0, 1), new r30(1, 1), new q30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        o30 o30Var = new o30();
        byte[] b = n30.b(bArr, bArr.length + ((this.a.length + 1) * o30.b));
        n30.a(b, o30Var.b(), bArr.length);
        int i = 0;
        while (true) {
            p30[] p30VarArr = this.a;
            if (i >= p30VarArr.length) {
                return Arrays.copyOf(o30Var.b(), o30.b);
            }
            p30 p30Var = p30VarArr[i];
            i++;
            int length = bArr.length + (o30.b * i);
            o30Var.a(p30Var.b(b, 0, length), p30Var.a(), p30Var.c(), p30Var.d());
            n30.a(b, o30Var.b(), length);
        }
    }
}
