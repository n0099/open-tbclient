package com.baidu.tieba;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;
/* loaded from: classes6.dex */
public class lbb {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static boolean b = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947938525, "Lcom/baidu/tieba/lbb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947938525, "Lcom/baidu/tieba/lbb;");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SecureRandom a() {
        InterceptResult invokeV;
        SecureRandom secureRandom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            pbb.b("EncryptUtil", "generateSecureRandomNew ");
            try {
            } catch (NoSuchAlgorithmException unused) {
                pbb.c("EncryptUtil", "getSecureRandomBytes: NoSuchAlgorithmException");
            }
            if (Build.VERSION.SDK_INT >= 26) {
                secureRandom = SecureRandom.getInstanceStrong();
                if (secureRandom == null) {
                    try {
                        secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    } catch (NoSuchAlgorithmException unused2) {
                        pbb.c("EncryptUtil", "NoSuchAlgorithmException");
                        return secureRandom;
                    } catch (Throwable th) {
                        if (b) {
                            pbb.c("EncryptUtil", "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
                            b = false;
                        }
                        return secureRandom;
                    }
                }
                AESEngine aESEngine = new AESEngine();
                byte[] bArr = new byte[32];
                secureRandom.nextBytes(bArr);
                return new SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(384).buildCTR(aESEngine, 256, bArr, false);
            }
            secureRandom = null;
            if (secureRandom == null) {
            }
            AESEngine aESEngine2 = new AESEngine();
            byte[] bArr2 = new byte[32];
            secureRandom.nextBytes(bArr2);
            return new SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(384).buildCTR(aESEngine2, 256, bArr2, false);
        }
        return (SecureRandom) invokeV.objValue;
    }

    public static byte[] b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            SecureRandom a2 = a();
            if (a2 == null) {
                return new byte[0];
            }
            byte[] bArr = new byte[i];
            a2.nextBytes(bArr);
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public static String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return mbb.a(c(i));
        }
        return (String) invokeI.objValue;
    }

    public static byte[] c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (!a) {
                byte[] bArr = new byte[i];
                SecureRandom secureRandom = null;
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        secureRandom = SecureRandom.getInstanceStrong();
                    }
                } catch (NoSuchAlgorithmException unused) {
                    pbb.c("EncryptUtil", "getSecureRandomBytes: NoSuchAlgorithmException");
                }
                if (secureRandom == null) {
                    try {
                        secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    } catch (NoSuchAlgorithmException unused2) {
                        pbb.c("EncryptUtil", "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                        return new byte[0];
                    } catch (Exception e) {
                        pbb.c("EncryptUtil", "getSecureRandomBytes getInstance: exception : " + e.getMessage());
                        return new byte[0];
                    }
                }
                secureRandom.nextBytes(bArr);
                return bArr;
            }
            return b(i);
        }
        return (byte[]) invokeI.objValue;
    }
}
