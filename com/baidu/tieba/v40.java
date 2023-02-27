package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class v40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y40[] a;

    public v40() {
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
        this.a = new y40[]{new z40(8, 0), new a50(0, 1), new a50(1, 1), new z40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        x40 x40Var = new x40();
        byte[] b = w40.b(bArr, bArr.length + ((this.a.length + 1) * x40.b));
        w40.a(b, x40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            y40[] y40VarArr = this.a;
            if (i >= y40VarArr.length) {
                return Arrays.copyOf(x40Var.b(), x40.b);
            }
            y40 y40Var = y40VarArr[i];
            i++;
            int length = bArr.length + (x40.b * i);
            x40Var.a(y40Var.b(b, 0, length), y40Var.a(), y40Var.c(), y40Var.d());
            w40.a(b, x40Var.b(), length);
        }
    }
}
