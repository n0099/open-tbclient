package com.baidu.tieba;

import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/* loaded from: classes9.dex */
public abstract class y7c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "PBKDF2";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948284516, "Lcom/baidu/tieba/y7c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948284516, "Lcom/baidu/tieba/y7c;");
        }
    }

    public static byte[] a(char[] cArr, byte[] bArr, int i, int i2, boolean z) {
        SecretKeyFactory secretKeyFactory;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{cArr, bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            try {
                PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i, i2);
                if (z) {
                    secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
                } else {
                    secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                }
                return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String str = a;
                g8c.c(str, "pbkdf exception : " + e.getMessage());
                return new byte[0];
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] b(char[] cArr, byte[] bArr, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, cArr, bArr, i, i2)) == null) {
            return a(cArr, bArr, i, i2, false);
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static byte[] c(char[] cArr, byte[] bArr, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, cArr, bArr, i, i2)) == null) {
            byte[] bArr2 = new byte[0];
            if (Build.VERSION.SDK_INT < 26) {
                g8c.c(a, "system version not high than 26");
                return bArr2;
            }
            return a(cArr, bArr, i, i2, true);
        }
        return (byte[]) invokeLLII.objValue;
    }
}
