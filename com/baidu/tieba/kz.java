package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class kz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oz[] a;

    public kz() {
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
        this.a = new oz[]{new pz(8, 0), new qz(0, 1), new qz(1, 1), new pz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        nz nzVar = new nz();
        byte[] b = lz.b(bArr, bArr.length + ((this.a.length + 1) * nz.b));
        lz.a(b, nzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            oz[] ozVarArr = this.a;
            if (i >= ozVarArr.length) {
                return Arrays.copyOf(nzVar.b(), nz.b);
            }
            oz ozVar = ozVarArr[i];
            i++;
            int length = bArr.length + (nz.b * i);
            nzVar.a(ozVar.b(b, 0, length), ozVar.d(), ozVar.a(), ozVar.c());
            lz.a(b, nzVar.b(), length);
        }
    }
}
