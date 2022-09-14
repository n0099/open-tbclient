package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ix7 {
    public static /* synthetic */ Interceptable $ic;
    public static ix7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public jf<byte[]> a;
    public jf<byte[]> b;

    public ix7() {
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

    public static synchronized ix7 b() {
        InterceptResult invokeV;
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ix7.class) {
                if (c == null) {
                    c = new ix7();
                }
                ix7Var = c;
            }
            return ix7Var;
        }
        return (ix7) invokeV.objValue;
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        jf.b<byte[]> h;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                jf<byte[]> jfVar = this.a;
                if (jfVar != null && str != null) {
                    h = jfVar.h(str);
                }
                h = null;
            } else {
                jf<byte[]> jfVar2 = this.b;
                if (jfVar2 != null && str != null) {
                    h = jfVar2.h(str);
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                zt4.f();
                this.a = zt4.d("tb.pb_mark");
            }
            if (this.b == null) {
                zt4.f();
                this.b = zt4.d("tb.pb_normal");
            }
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (z) {
                jf<byte[]> jfVar = this.a;
                if (jfVar == null || str == null) {
                    return;
                }
                jfVar.i(str, new byte[0], 0L);
                return;
            }
            jf<byte[]> jfVar2 = this.b;
            if (jfVar2 == null || str == null) {
                return;
            }
            jfVar2.i(str, new byte[0], 0L);
        }
    }

    public void e(String str, boolean z, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bArr}) == null) || str == null) {
            return;
        }
        c();
        if (z) {
            this.a.e(str, bArr, 86400000L);
        } else {
            this.b.e(str, bArr, 86400000L);
        }
    }

    public void f(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) || bArr == null || str == null) {
            return;
        }
        c();
        this.a.e(str, bArr, 86400000L);
    }
}
