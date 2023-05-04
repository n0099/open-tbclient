package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class p30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s30[] a;

    public p30() {
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
        this.a = new s30[]{new t30(8, 0), new u30(0, 1), new u30(1, 1), new t30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        r30 r30Var = new r30();
        byte[] b = q30.b(bArr, bArr.length + ((this.a.length + 1) * r30.b));
        q30.a(b, r30Var.b(), bArr.length);
        int i = 0;
        while (true) {
            s30[] s30VarArr = this.a;
            if (i >= s30VarArr.length) {
                return Arrays.copyOf(r30Var.b(), r30.b);
            }
            s30 s30Var = s30VarArr[i];
            i++;
            int length = bArr.length + (r30.b * i);
            r30Var.a(s30Var.b(b, 0, length), s30Var.a(), s30Var.c(), s30Var.d());
            q30.a(b, r30Var.b(), length);
        }
    }
}
