package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class oz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sz[] a;

    public oz() {
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
        this.a = new sz[]{new tz(8, 0), new uz(0, 1), new uz(1, 1), new tz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        rz rzVar = new rz();
        byte[] b = pz.b(bArr, bArr.length + ((this.a.length + 1) * rz.b));
        pz.a(b, rzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            sz[] szVarArr = this.a;
            if (i >= szVarArr.length) {
                return Arrays.copyOf(rzVar.b(), rz.b);
            }
            sz szVar = szVarArr[i];
            i++;
            int length = bArr.length + (rz.b * i);
            rzVar.a(szVar.b(b, 0, length), szVar.d(), szVar.a(), szVar.c());
            pz.a(b, rzVar.b(), length);
        }
    }
}
