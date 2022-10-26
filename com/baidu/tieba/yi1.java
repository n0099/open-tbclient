package com.baidu.tieba;

import android.content.Context;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes6.dex */
public class yi1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context != null && str != null) {
                try {
                    return new String(ui1.b(wi1.h(context).getBytes(), Base64.decode(str, 0), true));
                } catch (Throwable th) {
                    wi1.d(th);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String b(Context context, byte[] bArr) {
        InterceptResult invokeLL;
        byte[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bArr)) == null) {
            if (bArr != null) {
                try {
                    if (bArr.length != 0 && (a = ui1.a(wi1.h(context).getBytes(), bArr)) != null && a.length > 0) {
                        return Base64.encodeToString(a, 0);
                    }
                    return null;
                } catch (Throwable th) {
                    wi1.d(th);
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String c(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            try {
                RSAPublicKey d = d(str);
                if (d == null) {
                    return "";
                }
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, d);
                return Base64.encodeToString(cipher.doFinal(bArr), 0);
            } catch (Throwable th) {
                wi1.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static RSAPublicKey d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (Throwable th) {
                wi1.d(th);
                return null;
            }
        }
        return (RSAPublicKey) invokeL.objValue;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = ui1.b(bArr2, bArr, true)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    wi1.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = ui1.a(bArr2, bArr)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    wi1.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = cj1.b(bArr, bArr2)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    wi1.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] h(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0 && bArr != null && bArr.length > 0 && (bArr3 = cj1.c(bArr, bArr2)) != null) {
                        if (bArr3.length > 0) {
                            return bArr3;
                        }
                    }
                } catch (Throwable th) {
                    wi1.d(th);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}
