package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = bm1.b(bArr, bArr2)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    ul1.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = bm1.c(bArr, bArr2)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    ul1.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}
