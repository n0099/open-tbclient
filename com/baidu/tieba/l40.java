package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class l40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o40[] a;

    public l40() {
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
        this.a = new o40[]{new p40(8, 0), new q40(0, 1), new q40(1, 1), new p40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        n40 n40Var = new n40();
        byte[] b = m40.b(bArr, bArr.length + ((this.a.length + 1) * n40.b));
        m40.a(b, n40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            o40[] o40VarArr = this.a;
            if (i >= o40VarArr.length) {
                return Arrays.copyOf(n40Var.b(), n40.b);
            }
            o40 o40Var = o40VarArr[i];
            i++;
            int length = bArr.length + (n40.b * i);
            n40Var.a(o40Var.b(b, 0, length), o40Var.a(), o40Var.c(), o40Var.d());
            m40.a(b, n40Var.b(), length);
        }
    }
}
