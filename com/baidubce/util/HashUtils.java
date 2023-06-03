package com.baidubce.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceClientException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes9.dex */
public class HashUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Charset UTF8;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1222054393, "Lcom/baidubce/util/HashUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1222054393, "Lcom/baidubce/util/HashUtils;");
                return;
            }
        }
        UTF8 = Charset.forName("UTF-8");
    }

    public HashUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static byte[] computeHash(InputStream inputStream, MessageDigest messageDigest) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, messageDigest)) == null) {
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        byte[] digest = messageDigest.digest();
                        try {
                            inputStream.close();
                            return digest;
                        } catch (Exception e) {
                            throw new BceClientException("Fail to close InputStream.", e);
                        }
                    }
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    throw th;
                } catch (Exception e2) {
                    throw new BceClientException("Fail to close InputStream.", e2);
                }
            }
        } else {
            return (byte[]) invokeLL.objValue;
        }
    }

    public static String sha256Hex(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(str.getBytes(UTF8), "HmacSHA256"));
                return new String(ConvertUtils.encodeHex(mac.doFinal(str2.getBytes(UTF8))));
            } catch (Exception e) {
                throw new BceClientException("Fail to generate the signature", e);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] computeMd5Hash(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            return computeHash(inputStream, MessageDigest.getInstance("MD5"));
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] computeSha256Hash(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) {
            return computeHash(inputStream, MessageDigest.getInstance("SHA-256"));
        }
        return (byte[]) invokeL.objValue;
    }
}
