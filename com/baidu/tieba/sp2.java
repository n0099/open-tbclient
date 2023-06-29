package com.baidu.tieba;

import android.util.Base64;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sp2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159028, "Lcom/baidu/tieba/sp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159028, "Lcom/baidu/tieba/sp2;");
                return;
            }
        }
        a = ms1.a;
        b = new byte[]{31, -117};
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static File a(byte[] bArr, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, file)) == null) {
            if (bArr != null && bArr.length >= 2 && file != null && file.exists()) {
                byte[] bArr2 = b;
                bArr[0] = bArr2[0];
                bArr[1] = bArr2[1];
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    InputStreamReader inputStreamReader = new InputStreamReader(gZIPInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        if (a) {
                            Log.d("SwanAppCloneModule", "first char:" + sb.charAt(0));
                        }
                        String string = new JSONObject(sb.toString()).getString(up2.l);
                        if (a) {
                            Log.d("SwanAppCloneModule", string);
                        }
                        byte[] doFinal = b(2).doFinal(Base64.decode(string, 0));
                        File file2 = new File(file, up2.l);
                        new FileOutputStream(file2).write(doFinal);
                        if (a) {
                            Log.d("SwanAppCloneModule", file2.getAbsolutePath());
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return file2;
                    } finally {
                    }
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static Cipher b(int i) throws Exception {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(i, new SecretKeySpec(c("la32118_p9d8#*!6)".getBytes()).substring(16).getBytes(), "AES"), new IvParameterSpec("2081147213143090".getBytes()));
            return cipher;
        }
        return (Cipher) invokeI.objValue;
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return gs4.T(messageDigest.digest(), "", false);
            } catch (NoSuchAlgorithmException e) {
                if (a) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
