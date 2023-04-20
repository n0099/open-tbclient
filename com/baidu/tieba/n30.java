package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class n30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q30[] a;

    public n30() {
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
        this.a = new q30[]{new r30(8, 0), new s30(0, 1), new s30(1, 1), new r30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        p30 p30Var = new p30();
        byte[] b = o30.b(bArr, bArr.length + ((this.a.length + 1) * p30.b));
        o30.a(b, p30Var.b(), bArr.length);
        int i = 0;
        while (true) {
            q30[] q30VarArr = this.a;
            if (i >= q30VarArr.length) {
                return Arrays.copyOf(p30Var.b(), p30.b);
            }
            q30 q30Var = q30VarArr[i];
            i++;
            int length = bArr.length + (p30.b * i);
            p30Var.a(q30Var.b(b, 0, length), q30Var.a(), q30Var.c(), q30Var.d());
            o30.a(b, p30Var.b(), length);
        }
    }
}
