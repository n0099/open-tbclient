package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.da;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class xz9 {
    public static /* synthetic */ Interceptable $ic;
    public static xz9 c;
    public transient /* synthetic */ FieldHolder $fh;
    public da<byte[]> a;
    public da<byte[]> b;

    public xz9() {
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

    public static synchronized xz9 b() {
        InterceptResult invokeV;
        xz9 xz9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (xz9.class) {
                if (c == null) {
                    c = new xz9();
                }
                xz9Var = c;
            }
            return xz9Var;
        }
        return (xz9) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                e05.k();
                this.a = e05.i("tb.pb_mark");
            }
            if (this.b == null) {
                e05.k();
                this.b = e05.i("tb.pb_normal");
            }
        }
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        da.b<byte[]> h;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (UbsABTestHelper.isNoCachePb()) {
                return null;
            }
            if (z) {
                da<byte[]> daVar = this.a;
                if (daVar != null && str != null) {
                    h = daVar.h(str);
                }
                h = null;
            } else {
                da<byte[]> daVar2 = this.b;
                if (daVar2 != null && str != null) {
                    h = daVar2.h(str);
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
                da<byte[]> daVar = this.a;
                if (daVar != null && str != null) {
                    daVar.i(str, new byte[0], 0L);
                    return;
                }
                return;
            }
            da<byte[]> daVar2 = this.b;
            if (daVar2 != null && str != null) {
                daVar2.i(str, new byte[0], 0L);
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
