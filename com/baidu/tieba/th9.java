package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ye;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class th9 {
    public static /* synthetic */ Interceptable $ic;
    public static th9 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ye<byte[]> a;
    public ye<byte[]> b;

    public th9() {
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

    public static synchronized th9 b() {
        InterceptResult invokeV;
        th9 th9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (th9.class) {
                if (c == null) {
                    c = new th9();
                }
                th9Var = c;
            }
            return th9Var;
        }
        return (th9) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                o55.e();
                this.a = o55.c("tb.pb_mark");
            }
            if (this.b == null) {
                o55.e();
                this.b = o55.c("tb.pb_normal");
            }
        }
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        ye.b<byte[]> h;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                ye<byte[]> yeVar = this.a;
                if (yeVar != null && str != null) {
                    h = yeVar.h(str);
                }
                h = null;
            } else {
                ye<byte[]> yeVar2 = this.b;
                if (yeVar2 != null && str != null) {
                    h = yeVar2.h(str);
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
                ye<byte[]> yeVar = this.a;
                if (yeVar != null && str != null) {
                    yeVar.i(str, new byte[0], 0L);
                    return;
                }
                return;
            }
            ye<byte[]> yeVar2 = this.b;
            if (yeVar2 != null && str != null) {
                yeVar2.i(str, new byte[0], 0L);
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
