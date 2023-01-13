package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class pz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tz[] a;

    public pz() {
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
        this.a = new tz[]{new uz(8, 0), new vz(0, 1), new vz(1, 1), new uz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        sz szVar = new sz();
        byte[] b = qz.b(bArr, bArr.length + ((this.a.length + 1) * sz.b));
        qz.a(b, szVar.b(), bArr.length);
        int i = 0;
        while (true) {
            tz[] tzVarArr = this.a;
            if (i >= tzVarArr.length) {
                return Arrays.copyOf(szVar.b(), sz.b);
            }
            tz tzVar = tzVarArr[i];
            i++;
            int length = bArr.length + (sz.b * i);
            szVar.a(tzVar.b(b, 0, length), tzVar.d(), tzVar.a(), tzVar.c());
            qz.a(b, szVar.b(), length);
        }
    }
}
