package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class j40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m40[] a;

    public j40() {
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
        this.a = new m40[]{new n40(8, 0), new o40(0, 1), new o40(1, 1), new n40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        l40 l40Var = new l40();
        byte[] b = k40.b(bArr, bArr.length + ((this.a.length + 1) * l40.b));
        k40.a(b, l40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            m40[] m40VarArr = this.a;
            if (i >= m40VarArr.length) {
                return Arrays.copyOf(l40Var.b(), l40.b);
            }
            m40 m40Var = m40VarArr[i];
            i++;
            int length = bArr.length + (l40.b * i);
            l40Var.a(m40Var.b(b, 0, length), m40Var.a(), m40Var.c(), m40Var.d());
            k40.a(b, l40Var.b(), length);
        }
    }
}
