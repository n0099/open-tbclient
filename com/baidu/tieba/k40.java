package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class k40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n40[] a;

    public k40() {
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
        this.a = new n40[]{new o40(8, 0), new p40(0, 1), new p40(1, 1), new o40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        m40 m40Var = new m40();
        byte[] b = l40.b(bArr, bArr.length + ((this.a.length + 1) * m40.b));
        l40.a(b, m40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            n40[] n40VarArr = this.a;
            if (i >= n40VarArr.length) {
                return Arrays.copyOf(m40Var.b(), m40.b);
            }
            n40 n40Var = n40VarArr[i];
            i++;
            int length = bArr.length + (m40.b * i);
            m40Var.a(n40Var.b(b, 0, length), n40Var.a(), n40Var.c(), n40Var.d());
            l40.a(b, m40Var.b(), length);
        }
    }
}
