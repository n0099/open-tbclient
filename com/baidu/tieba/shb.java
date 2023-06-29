package com.baidu.tieba;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import org.chromium.net.AndroidKeyStore;
/* loaded from: classes7.dex */
public class shb {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, SecretKey> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948152828, "Lcom/baidu/tieba/shb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948152828, "Lcom/baidu/tieba/shb;");
                return;
            }
        }
        a = new HashMap();
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static SecretKey a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            yhb.d("GCMKS", "load key");
            SecretKey secretKey = null;
            try {
                KeyStore keyStore = KeyStore.getInstance(AndroidKeyStore.TAG);
                keyStore.load(null);
                Key key = keyStore.getKey(str, null);
                if (key instanceof SecretKey) {
                    secretKey = (SecretKey) key;
                } else {
                    yhb.d("GCMKS", "generate key");
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", AndroidKeyStore.TAG);
                    keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                    secretKey = keyGenerator.generateKey();
                }
            } catch (IOException e) {
                yhb.c("GCMKS", "IOException : " + e.getMessage());
            } catch (InvalidAlgorithmParameterException e2) {
                yhb.c("GCMKS", "InvalidAlgorithmParameterException : " + e2.getMessage());
            } catch (KeyStoreException e3) {
                yhb.c("GCMKS", "KeyStoreException : " + e3.getMessage());
            } catch (NoSuchAlgorithmException e4) {
                yhb.c("GCMKS", "NoSuchAlgorithmException : " + e4.getMessage());
            } catch (NoSuchProviderException e5) {
                yhb.c("GCMKS", "NoSuchProviderException : " + e5.getMessage());
            } catch (UnrecoverableKeyException e6) {
                yhb.c("GCMKS", "UnrecoverableKeyException : " + e6.getMessage());
            } catch (CertificateException e7) {
                yhb.c("GCMKS", "CertificateException : " + e7.getMessage());
            } catch (Exception e8) {
                yhb.c("GCMKS", "Exception: " + e8.getMessage());
            }
            a.put(str, secretKey);
            return secretKey;
        }
        return (SecretKey) invokeL.objValue;
    }

    public static SecretKey c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (a.get(str) == null) {
                a(str);
            }
            return a.get(str);
        }
        return (SecretKey) invokeL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    return new String(e(str, vhb.b(str2)), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    yhb.c("GCMKS", "decrypt: UnsupportedEncodingException : " + e.getMessage());
                    return "";
                }
            }
            yhb.c("GCMKS", "alias or encrypt content is null");
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] e(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, bArr)) == null) {
            byte[] bArr2 = new byte[0];
            if (!TextUtils.isEmpty(str) && bArr != null) {
                if (!b()) {
                    yhb.c("GCMKS", "sdk version is too low");
                    return bArr2;
                } else if (bArr.length <= 12) {
                    yhb.c("GCMKS", "Decrypt source data is invalid.");
                    return bArr2;
                } else {
                    return f(c(str), bArr);
                }
            }
            yhb.c("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    return vhb.a(h(str, str2.getBytes("UTF-8")));
                } catch (UnsupportedEncodingException e) {
                    yhb.c("GCMKS", "encrypt: UnsupportedEncodingException : " + e.getMessage());
                    return "";
                }
            }
            yhb.c("GCMKS", "alias or encrypt content is null");
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] f(SecretKey secretKey, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, secretKey, bArr)) == null) {
            byte[] bArr2 = new byte[0];
            if (secretKey == null) {
                yhb.c("GCMKS", "Decrypt secret key is null");
                return bArr2;
            } else if (bArr == null) {
                yhb.c("GCMKS", "content is null");
                return bArr2;
            } else if (!b()) {
                yhb.c("GCMKS", "sdk version is too low");
                return bArr2;
            } else if (bArr.length <= 12) {
                yhb.c("GCMKS", "Decrypt source data is invalid.");
                return bArr2;
            } else {
                byte[] copyOf = Arrays.copyOf(bArr, 12);
                try {
                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher.init(2, secretKey, new GCMParameterSpec(128, copyOf));
                    return cipher.doFinal(bArr, 12, bArr.length - 12);
                } catch (InvalidAlgorithmParameterException e) {
                    yhb.c("GCMKS", "InvalidAlgorithmParameterException : " + e.getMessage());
                    return bArr2;
                } catch (InvalidKeyException e2) {
                    yhb.c("GCMKS", "InvalidKeyException : " + e2.getMessage());
                    return bArr2;
                } catch (NoSuchAlgorithmException e3) {
                    yhb.c("GCMKS", "NoSuchAlgorithmException : " + e3.getMessage());
                    return bArr2;
                } catch (BadPaddingException e4) {
                    yhb.c("GCMKS", "BadPaddingException : " + e4.getMessage());
                    return bArr2;
                } catch (IllegalBlockSizeException e5) {
                    yhb.c("GCMKS", "IllegalBlockSizeException : " + e5.getMessage());
                    return bArr2;
                } catch (NoSuchPaddingException e6) {
                    yhb.c("GCMKS", "NoSuchPaddingException : " + e6.getMessage());
                    return bArr2;
                } catch (Exception e7) {
                    yhb.c("GCMKS", "Exception: " + e7.getMessage());
                    return bArr2;
                }
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] i(SecretKey secretKey, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, secretKey, bArr)) == null) {
            byte[] bArr2 = new byte[0];
            if (bArr == null) {
                yhb.c("GCMKS", "content is null");
                return bArr2;
            } else if (secretKey == null) {
                yhb.c("GCMKS", "secret key is null");
                return bArr2;
            } else if (!b()) {
                yhb.c("GCMKS", "sdk version is too low");
                return bArr2;
            } else {
                try {
                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher.init(1, secretKey);
                    byte[] doFinal = cipher.doFinal(bArr);
                    byte[] iv = cipher.getIV();
                    if (iv != null && iv.length == 12) {
                        byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                        System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                        return copyOf;
                    }
                    yhb.c("GCMKS", "IV is invalid.");
                    return bArr2;
                } catch (InvalidKeyException e) {
                    yhb.c("GCMKS", "InvalidKeyException : " + e.getMessage());
                    return bArr2;
                } catch (NoSuchAlgorithmException e2) {
                    yhb.c("GCMKS", "NoSuchAlgorithmException : " + e2.getMessage());
                    return bArr2;
                } catch (BadPaddingException e3) {
                    yhb.c("GCMKS", "BadPaddingException : " + e3.getMessage());
                    return bArr2;
                } catch (IllegalBlockSizeException e4) {
                    yhb.c("GCMKS", "IllegalBlockSizeException : " + e4.getMessage());
                    return bArr2;
                } catch (NoSuchPaddingException e5) {
                    yhb.c("GCMKS", "NoSuchPaddingException : " + e5.getMessage());
                    return bArr2;
                } catch (Exception e6) {
                    yhb.c("GCMKS", "Exception: " + e6.getMessage());
                    return bArr2;
                }
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] h(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, bArr)) == null) {
            byte[] bArr2 = new byte[0];
            if (!TextUtils.isEmpty(str) && bArr != null) {
                if (!b()) {
                    yhb.c("GCMKS", "sdk version is too low");
                    return bArr2;
                }
                return i(c(str), bArr);
            }
            yhb.c("GCMKS", "alias or encrypt content is null");
            return bArr2;
        }
        return (byte[]) invokeLL.objValue;
    }
}
