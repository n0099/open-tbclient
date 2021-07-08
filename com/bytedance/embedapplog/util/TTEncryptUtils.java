package com.bytedance.embedapplog.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.b.a.h0;
/* loaded from: classes5.dex */
public class TTEncryptUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2072398125, "Lcom/bytedance/embedapplog/util/TTEncryptUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2072398125, "Lcom/bytedance/embedapplog/util/TTEncryptUtils;");
                return;
            }
        }
        try {
            System.loadLibrary("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e2) {
            h0.b(e2);
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bArr, i2)) == null) {
            try {
                return ttEncrypt(bArr, i2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static native byte[] ttEncrypt(byte[] bArr, int i2);
}
