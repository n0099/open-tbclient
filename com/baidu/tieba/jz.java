package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class jz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nz[] a;

    public jz() {
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
        this.a = new nz[]{new oz(8, 0), new pz(0, 1), new pz(1, 1), new oz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        mz mzVar = new mz();
        byte[] b = kz.b(bArr, bArr.length + ((this.a.length + 1) * mz.b));
        kz.a(b, mzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            nz[] nzVarArr = this.a;
            if (i >= nzVarArr.length) {
                return Arrays.copyOf(mzVar.b(), mz.b);
            }
            nz nzVar = nzVarArr[i];
            i++;
            int length = bArr.length + (mz.b * i);
            mzVar.a(nzVar.b(b, 0, length), nzVar.d(), nzVar.a(), nzVar.c());
            kz.a(b, mzVar.b(), length);
        }
    }
}
