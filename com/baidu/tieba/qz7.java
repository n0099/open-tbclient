package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qz7 {
    public static /* synthetic */ Interceptable $ic;
    public static qz7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public cf<byte[]> a;
    public cf<byte[]> b;

    public qz7() {
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
        this.a = null;
        this.b = null;
        c();
    }

    public static synchronized qz7 b() {
        InterceptResult invokeV;
        qz7 qz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (qz7.class) {
                if (c == null) {
                    c = new qz7();
                }
                qz7Var = c;
            }
            return qz7Var;
        }
        return (qz7) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                hv4.f();
                this.a = hv4.d("tb.pb_mark");
            }
            if (this.b == null) {
                hv4.f();
                this.b = hv4.d("tb.pb_normal");
            }
        }
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        cf.b<byte[]> h;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                cf<byte[]> cfVar = this.a;
                if (cfVar != null && str != null) {
                    h = cfVar.h(str);
                }
                h = null;
            } else {
                cf<byte[]> cfVar2 = this.b;
                if (cfVar2 != null && str != null) {
                    h = cfVar2.h(str);
                }
                h = null;
            }
            if (h == null || (bArr = h.b) == null) {
                return null;
            }
            return bArr;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (z) {
                cf<byte[]> cfVar = this.a;
                if (cfVar != null && str != null) {
                    cfVar.i(str, new byte[0], 0L);
                    return;
                }
                return;
            }
            cf<byte[]> cfVar2 = this.b;
            if (cfVar2 != null && str != null) {
                cfVar2.i(str, new byte[0], 0L);
            }
        }
    }

    public void f(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) && bArr != null && str != null) {
            c();
            this.a.e(str, bArr, 86400000L);
        }
    }

    public void e(String str, boolean z, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bArr}) == null) && str != null) {
            c();
            if (z) {
                this.a.e(str, bArr, 86400000L);
            } else {
                this.b.e(str, bArr, 86400000L);
            }
        }
    }
}
