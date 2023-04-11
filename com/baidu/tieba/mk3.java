package com.baidu.tieba;

import android.util.Base64;
import android.util.Log;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public class mk3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947975508, "Lcom/baidu/tieba/mk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947975508, "Lcom/baidu/tieba/mk3;");
                return;
            }
        }
        a = eo1.a;
    }

    @NonNull
    @CheckResult
    public static String a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, str2, str3, str4)) == null) {
            try {
                Cipher cipher = Cipher.getInstance(str3);
                cipher.init(1, new SecretKeySpec(str.getBytes(IMAudioTransRequest.CHARSET), "AES"), new IvParameterSpec(str4.getBytes(IMAudioTransRequest.CHARSET)));
                return Base64.encodeToString(cipher.doFinal(str2.getBytes(IMAudioTransRequest.CHARSET)), 2);
            } catch (Exception e) {
                if (a) {
                    Log.e("SwanAppEncryptUtils", "aesEncrypt", e);
                    return "";
                }
                return "";
            }
        }
        return (String) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public static String b(String str, File file, boolean z) {
        InterceptResult invokeLLZ;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, file, z)) == null) {
            ?? r0 = 0;
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(str);
                    messageDigest.reset();
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                messageDigest.update(bArr, 0, read);
                            } else {
                                String e = e(messageDigest.digest(), "", z);
                                yn4.d(fileInputStream);
                                return e;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        if (a) {
                            e.printStackTrace();
                        }
                        yn4.d(fileInputStream);
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        if (a) {
                            e.printStackTrace();
                        }
                        yn4.d(fileInputStream);
                        return null;
                    } catch (NoSuchAlgorithmException e4) {
                        e = e4;
                        if (a) {
                            e.printStackTrace();
                        }
                        yn4.d(fileInputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = interceptable;
                    yn4.d(r0);
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream = null;
            } catch (IOException e6) {
                e = e6;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                yn4.d(r0);
                throw th;
            }
        } else {
            return (String) invokeLLZ.objValue;
        }
    }

    public static String c(String str, byte[] bArr, boolean z) throws NoSuchAlgorithmException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, str, bArr, z)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            messageDigest.update(bArr);
            return e(messageDigest.digest(), "", z);
        }
        return (String) invokeLLZ.objValue;
    }

    @NonNull
    @CheckResult
    public static String d(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            try {
                PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(IMAudioTransRequest.CHARSET), 0)));
                Cipher cipher = Cipher.getInstance(str3);
                cipher.init(1, generatePublic);
                return Base64.encodeToString(cipher.doFinal(str2.getBytes(IMAudioTransRequest.CHARSET)), 2);
            } catch (Exception e) {
                if (a) {
                    Log.e("SwanAppEncryptUtils", "rsaEncrypt", e);
                    return "";
                }
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String e(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }
}
