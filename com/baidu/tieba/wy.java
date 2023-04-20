package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class wy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public az[] a;

    public wy() {
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
        this.a = new az[]{new bz(8, 0), new cz(0, 1), new cz(1, 1), new bz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        zy zyVar = new zy();
        byte[] b = xy.b(bArr, bArr.length + ((this.a.length + 1) * zy.b));
        xy.a(b, zyVar.b(), bArr.length);
        int i = 0;
        while (true) {
            az[] azVarArr = this.a;
            if (i >= azVarArr.length) {
                return Arrays.copyOf(zyVar.b(), zy.b);
            }
            az azVar = azVarArr[i];
            i++;
            int length = bArr.length + (zy.b * i);
            zyVar.a(azVar.b(b, 0, length), azVar.a(), azVar.c(), azVar.d());
            xy.a(b, zyVar.b(), length);
        }
    }
}
