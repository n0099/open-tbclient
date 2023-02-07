package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class r40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u40[] a;

    public r40() {
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
        this.a = new u40[]{new v40(8, 0), new w40(0, 1), new w40(1, 1), new v40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        t40 t40Var = new t40();
        byte[] b = s40.b(bArr, bArr.length + ((this.a.length + 1) * t40.b));
        s40.a(b, t40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            u40[] u40VarArr = this.a;
            if (i >= u40VarArr.length) {
                return Arrays.copyOf(t40Var.b(), t40.b);
            }
            u40 u40Var = u40VarArr[i];
            i++;
            int length = bArr.length + (t40.b * i);
            t40Var.a(u40Var.b(b, 0, length), u40Var.a(), u40Var.c(), u40Var.d());
            s40.a(b, t40Var.b(), length);
        }
    }
}
