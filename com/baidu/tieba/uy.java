package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class uy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yy[] a;

    public uy() {
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
        this.a = new yy[]{new zy(8, 0), new az(0, 1), new az(1, 1), new zy(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        xy xyVar = new xy();
        byte[] b = vy.b(bArr, bArr.length + ((this.a.length + 1) * xy.b));
        vy.a(b, xyVar.b(), bArr.length);
        int i = 0;
        while (true) {
            yy[] yyVarArr = this.a;
            if (i >= yyVarArr.length) {
                return Arrays.copyOf(xyVar.b(), xy.b);
            }
            yy yyVar = yyVarArr[i];
            i++;
            int length = bArr.length + (xy.b * i);
            xyVar.a(yyVar.b(b, 0, length), yyVar.a(), yyVar.c(), yyVar.d());
            vy.a(b, xyVar.b(), length);
        }
    }
}
