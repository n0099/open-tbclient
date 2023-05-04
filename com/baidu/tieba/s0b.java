package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public final class s0b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
            } catch (Exception e) {
                b1b.c("CBC", "get encryptword exception : " + e.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
                } catch (Exception e) {
                    b1b.c("CBC", "mix exception: " + e.getMessage());
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] c(String str, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, bArr, bArr2)) == null) {
            if (TextUtils.isEmpty(str)) {
                b1b.c("CBC", "encrypt 5 content is null");
                return new byte[0];
            } else if (bArr == null) {
                b1b.c("CBC", "encrypt 5 key is null");
                return new byte[0];
            } else if (bArr.length < 16) {
                b1b.c("CBC", "encrypt 5 key lengh is not right");
                return new byte[0];
            } else if (bArr2 == null) {
                b1b.c("CBC", "encrypt 5 iv is null");
                return new byte[0];
            } else if (bArr2.length < 16) {
                b1b.c("CBC", "encrypt 5 iv lengh is not right");
                return new byte[0];
            } else {
                try {
                    return m(str.getBytes("UTF-8"), bArr, bArr2);
                } catch (UnsupportedEncodingException e) {
                    b1b.c("CBC", " cbc encrypt data error" + e.getMessage());
                    return new byte[0];
                }
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static String h(String str, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, bArr, bArr2)) == null) {
            if (TextUtils.isEmpty(str)) {
                b1b.c("CBC", "decrypt 4 content is null");
                return "";
            } else if (bArr == null) {
                b1b.c("CBC", "decrypt 4 key is null");
                return "";
            } else if (bArr.length < 16) {
                b1b.c("CBC", "decrypt 4 key lengh is not right");
                return "";
            } else if (bArr2 == null) {
                b1b.c("CBC", "decrypt 4 iv is null");
                return "";
            } else if (bArr2.length < 16) {
                b1b.c("CBC", "decrypt 4 iv lengh is not right");
                return "";
            } else {
                try {
                    return new String(i(y0b.b(str), bArr, bArr2), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    b1b.c("CBC", " cbc decrypt data error" + e.getMessage());
                    return "";
                }
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, bArr, bArr2)) == null) {
            byte[] c = x0b.c(16);
            return d(c, m(bArr, bArr2, c));
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
            } catch (Exception e) {
                b1b.c("CBC", "getIv exception : " + e.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                b1b.c("CBC", "decrypt 1 content is null");
                return "";
            } else if (TextUtils.isEmpty(str2)) {
                b1b.c("CBC", "decrypt 1 key is null");
                return "";
            } else {
                byte[] b = y0b.b(str2);
                if (b.length < 16) {
                    b1b.c("CBC", "decrypt 1 key length is not right");
                    return "";
                }
                return g(str, b);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                b1b.c("CBC", "encrypt 1 content is null");
                return "";
            } else if (TextUtils.isEmpty(str2)) {
                b1b.c("CBC", "encrypt 1 key is null");
                return "";
            } else {
                byte[] b = y0b.b(str2);
                if (b.length < 16) {
                    b1b.c("CBC", "encrypt 1 key length is not right");
                    return "";
                }
                return k(str, b);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String g(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, bArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                b1b.c("CBC", "decrypt 2 content is null");
                return "";
            } else if (bArr == null) {
                b1b.c("CBC", "decrypt 2 key is null");
                return "";
            } else if (bArr.length < 16) {
                b1b.c("CBC", "decrypt 2 key lengh is not right");
                return "";
            } else {
                String e = e(str);
                String a = a(str);
                if (TextUtils.isEmpty(e)) {
                    b1b.c("CBC", "decrypt 2 iv is null");
                    return "";
                } else if (TextUtils.isEmpty(a)) {
                    b1b.c("CBC", "decrypt 2 encrypt content is null");
                    return "";
                } else {
                    return h(a, bArr, y0b.b(e));
                }
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String k(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, bArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                b1b.c("CBC", "encrypt 2 content is null");
                return "";
            } else if (bArr == null) {
                b1b.c("CBC", "encrypt 2 key is null");
                return "";
            } else if (bArr.length < 16) {
                b1b.c("CBC", "encrypt 2 key lengh is not right");
                return "";
            } else {
                byte[] c = x0b.c(16);
                byte[] c2 = c(str, bArr, c);
                if (c2 == null || c2.length == 0) {
                    return "";
                }
                return b(y0b.a(c), y0b.a(c2));
            }
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, bArr, bArr2, bArr3)) == null) {
            if (bArr == null) {
                b1b.c("CBC", "decrypt 6 content is null");
                return new byte[0];
            } else if (bArr.length == 0) {
                b1b.c("CBC", "decrypt 6 content length is 0");
                return new byte[0];
            } else if (bArr2 == null) {
                b1b.c("CBC", "decrypt 6 key is null");
                return new byte[0];
            } else if (bArr2.length < 16) {
                b1b.c("CBC", "decrypt 6 key length is error");
                return new byte[0];
            } else if (bArr3 == null) {
                b1b.c("CBC", "decrypt 6 iv is null");
                return new byte[0];
            } else if (bArr3.length < 16) {
                b1b.c("CBC", "decrypt 6 iv length is error");
                return new byte[0];
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                    return cipher.doFinal(bArr);
                } catch (InvalidAlgorithmParameterException e) {
                    b1b.c("CBC", "InvalidAlgorithmParameterException: " + e.getMessage());
                    return new byte[0];
                } catch (InvalidKeyException e2) {
                    b1b.c("CBC", "InvalidKeyException: " + e2.getMessage());
                    return new byte[0];
                } catch (NoSuchAlgorithmException e3) {
                    b1b.c("CBC", "NoSuchAlgorithmException: " + e3.getMessage());
                    return new byte[0];
                } catch (BadPaddingException e4) {
                    b1b.c("CBC", "BadPaddingException: " + e4.getMessage());
                    b1b.c("CBC", "key is not right");
                    return new byte[0];
                } catch (IllegalBlockSizeException e5) {
                    b1b.c("CBC", "IllegalBlockSizeException: " + e5.getMessage());
                    return new byte[0];
                } catch (NoSuchPaddingException e6) {
                    b1b.c("CBC", "NoSuchPaddingException: " + e6.getMessage());
                    return new byte[0];
                }
            }
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, bArr, bArr2, bArr3)) == null) {
            if (bArr == null) {
                b1b.c("CBC", "encrypt 6 content is null");
                return new byte[0];
            } else if (bArr.length == 0) {
                b1b.c("CBC", "encrypt 6 content length is 0");
                return new byte[0];
            } else if (bArr2 == null) {
                b1b.c("CBC", "encrypt 6 key is null");
                return new byte[0];
            } else if (bArr2.length < 16) {
                b1b.c("CBC", "encrypt 6 key length is error");
                return new byte[0];
            } else if (bArr3 == null) {
                b1b.c("CBC", "encrypt 6 iv is null");
                return new byte[0];
            } else if (bArr3.length < 16) {
                b1b.c("CBC", "encrypt 6 iv length is error");
                return new byte[0];
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                    return cipher.doFinal(bArr);
                } catch (InvalidAlgorithmParameterException e) {
                    b1b.c("CBC", "InvalidAlgorithmParameterException: " + e.getMessage());
                    return new byte[0];
                } catch (InvalidKeyException e2) {
                    b1b.c("CBC", "InvalidKeyException: " + e2.getMessage());
                    return new byte[0];
                } catch (NoSuchAlgorithmException e3) {
                    b1b.c("CBC", "NoSuchAlgorithmException: " + e3.getMessage());
                    return new byte[0];
                } catch (BadPaddingException e4) {
                    b1b.c("CBC", "BadPaddingException: " + e4.getMessage());
                    return new byte[0];
                } catch (IllegalBlockSizeException e5) {
                    b1b.c("CBC", "IllegalBlockSizeException: " + e5.getMessage());
                    return new byte[0];
                } catch (NoSuchPaddingException e6) {
                    b1b.c("CBC", "NoSuchPaddingException: " + e6.getMessage());
                    return new byte[0];
                }
            }
        }
        return (byte[]) invokeLLL.objValue;
    }
}
