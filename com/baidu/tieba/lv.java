package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class lv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hv a;
    public final int b;
    public byte[] c;

    public lv(hv hvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hvVar;
        this.b = hvVar.a();
    }

    public abstract void a(boolean z, String str, byte[] bArr, byte[] bArr2);

    public abstract void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public abstract void c();

    public abstract void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public abstract void e();

    public void f(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            b(bArr, i, i2, bArr2, i3);
        }
    }

    public abstract void g();

    public void h(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            d(bArr, i, i2, bArr2, i3);
        }
    }
}
