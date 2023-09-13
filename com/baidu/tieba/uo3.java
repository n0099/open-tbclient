package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes8.dex */
public class uo3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948217680, "Lcom/baidu/tieba/uo3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948217680, "Lcom/baidu/tieba/uo3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static boolean a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, str)) == null) {
            return b(file, str, null);
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(ReadableByteChannel readableByteChannel, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, readableByteChannel, str)) == null) {
            return d(readableByteChannel, str, null);
        }
        return invokeLL.booleanValue;
    }

    public static byte[] e(byte[] bArr, PublicKey publicKey) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, publicKey)) == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, publicKey);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static boolean b(File file, String str, op3 op3Var) {
        InterceptResult invokeLLL;
        boolean z;
        Object valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, file, str, op3Var)) == null) {
            if (file == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z && file.exists() && !TextUtils.isEmpty(str)) {
                ReadableByteChannel readableByteChannel = null;
                try {
                    readableByteChannel = Channels.newChannel(new FileInputStream(file));
                    return d(readableByteChannel, str, op3Var);
                } catch (IOException e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    lr4.d(readableByteChannel);
                }
            }
            if (op3Var != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("zipfile: isEmpty=");
                sb.append(z);
                sb.append("; exists=");
                if (z) {
                    valueOf = "";
                } else {
                    valueOf = Boolean.valueOf(file.exists());
                }
                sb.append(valueOf);
                op3Var.a = sb.toString();
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean d(ReadableByteChannel readableByteChannel, String str, op3 op3Var) throws IOException {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, readableByteChannel, str, op3Var)) == null) {
            if (readableByteChannel == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !TextUtils.isEmpty(str)) {
                String c = nr4.c(false, readableByteChannel);
                if (op3Var != null) {
                    op3Var.a = c;
                }
                try {
                    String str2 = new String(e(Base64.decode(str.getBytes("utf-8"), 8), f("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZuy3GEbahJc292fsyvrGneTJKQnzpdhNsJfDS5csb0MtmW+4JEvBH5wCZK5j4+nrRfKBF7JuTHe0nSWOZWNxgLU87pwCxozXSNrsiiOjsV+3KwYfdz5QlvvyCfvmllGObPqL7dWR92V2UYEWMSneBHtwDhCBCzmhAoOxZVsAq2wIDAQAB")), "utf-8");
                    if (op3Var != null) {
                        op3Var.b = str2;
                    }
                    return TextUtils.equals(str2, c);
                } catch (Exception e) {
                    if (a) {
                        Log.i("SwanAppSignChecker", e.toString());
                        e.printStackTrace();
                    }
                    if (op3Var != null) {
                        op3Var.b = e.getLocalizedMessage();
                    }
                    return false;
                }
            }
            if (op3Var != null) {
                op3Var.a = "zipSource isNullIs=" + z;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static PublicKey f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
            } catch (UnsupportedEncodingException | NullPointerException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
                return null;
            }
        }
        return (PublicKey) invokeL.objValue;
    }
}
