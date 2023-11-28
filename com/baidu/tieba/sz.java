package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class sz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vz[] a;

    public sz() {
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
        this.a = new vz[]{new wz(8, 0), new xz(0, 1), new xz(1, 1), new wz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        uz uzVar = new uz();
        byte[] b = tz.b(bArr, bArr.length + ((this.a.length + 1) * uz.b));
        tz.a(b, uzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            vz[] vzVarArr = this.a;
            if (i >= vzVarArr.length) {
                return Arrays.copyOf(uzVar.b(), uz.b);
            }
            vz vzVar = vzVarArr[i];
            i++;
            int length = bArr.length + (uz.b * i);
            uzVar.a(vzVar.b(b, 0, length), vzVar.a(), vzVar.c(), vzVar.d());
            tz.a(b, uzVar.b(), length);
        }
    }
}
