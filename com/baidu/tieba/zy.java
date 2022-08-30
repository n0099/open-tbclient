package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class zy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dz[] a;

    public zy() {
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
        this.a = new dz[]{new ez(8, 0), new fz(0, 1), new fz(1, 1), new ez(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        cz czVar = new cz();
        byte[] b = az.b(bArr, bArr.length + ((this.a.length + 1) * cz.b));
        az.a(b, czVar.b(), bArr.length);
        int i = 0;
        while (true) {
            dz[] dzVarArr = this.a;
            if (i >= dzVarArr.length) {
                return Arrays.copyOf(czVar.b(), cz.b);
            }
            dz dzVar = dzVarArr[i];
            i++;
            int length = bArr.length + (cz.b * i);
            czVar.a(dzVar.b(b, 0, length), dzVar.d(), dzVar.a(), dzVar.c());
            az.a(b, czVar.b(), length);
        }
    }
}
