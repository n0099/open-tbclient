package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class nz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rz[] a;

    public nz() {
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
        this.a = new rz[]{new sz(8, 0), new tz(0, 1), new tz(1, 1), new sz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        qz qzVar = new qz();
        byte[] b = oz.b(bArr, bArr.length + ((this.a.length + 1) * qz.b));
        oz.a(b, qzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            rz[] rzVarArr = this.a;
            if (i >= rzVarArr.length) {
                return Arrays.copyOf(qzVar.b(), qz.b);
            }
            rz rzVar = rzVarArr[i];
            i++;
            int length = bArr.length + (qz.b * i);
            qzVar.a(rzVar.b(b, 0, length), rzVar.d(), rzVar.a(), rzVar.c());
            oz.a(b, qzVar.b(), length);
        }
    }
}
