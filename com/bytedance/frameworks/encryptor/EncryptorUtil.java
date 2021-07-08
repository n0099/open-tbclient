package com.bytedance.frameworks.encryptor;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class EncryptorUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1515101260, "Lcom/bytedance/frameworks/encryptor/EncryptorUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1515101260, "Lcom/bytedance/frameworks/encryptor/EncryptorUtil;");
                return;
            }
        }
        try {
            System.loadLibrary("Encryptor");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bArr, i2)) == null) {
            if (bArr != null && i2 > 0) {
                try {
                    if (bArr.length == i2) {
                        return ttEncrypt(bArr, i2);
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (byte[]) invokeLI.objValue;
    }

    public static native byte[] ttEncrypt(byte[] bArr, int i2);
}
