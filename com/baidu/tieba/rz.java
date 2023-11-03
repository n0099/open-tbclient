package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class rz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uz[] a;

    public rz() {
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
        this.a = new uz[]{new vz(8, 0), new wz(0, 1), new wz(1, 1), new vz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        tz tzVar = new tz();
        byte[] b = sz.b(bArr, bArr.length + ((this.a.length + 1) * tz.b));
        sz.a(b, tzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            uz[] uzVarArr = this.a;
            if (i >= uzVarArr.length) {
                return Arrays.copyOf(tzVar.b(), tz.b);
            }
            uz uzVar = uzVarArr[i];
            i++;
            int length = bArr.length + (tz.b * i);
            tzVar.a(uzVar.b(b, 0, length), uzVar.a(), uzVar.c(), uzVar.d());
            sz.a(b, tzVar.b(), length);
        }
    }
}
