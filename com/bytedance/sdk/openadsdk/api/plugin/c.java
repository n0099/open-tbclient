package com.bytedance.sdk.openadsdk.api.plugin;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PublicKey a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.a = a(new String(Base64.decode("TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUF5ZXRudE1CRzJuU1JRb1lpT1NLegpCdkZ5cmdwQ1dlT1lnRVZxbG5rNWhLMGlydnNKdVhrZ2paVnFDc0VBRFVQQ0w5K2NlZng1NHoyRGw5dmpEemlwCjVYSGluRUdnZkR1ZzBkcmZyOHRKTElySHlnQlY5M2FTWFg5endBVGlnRnY0dzNrN1RuMStxS01CdUxhbkptSFMKQUttRGMrRCtZSmpYSGF0dWY3YlVhbXlEdDBOZ2pYM0F5d1JUSkErcldPR3RjMHRTWDdaNmlKd3o2bXdzTmZQYQpka3NwVEpmcjVja2dRdVlvWDQybGxteGhRTCtLK2F3NHE1SDgxZTFZUjN4TGhQaVdBTFNXVWlhYk5OQ3dyTGQvCk5uRVNaa0gzQVJqazVtYnhzU1lKcU8yUTRTL2lmNXl3WXYycG51ZW50d2ZQa3p3b0NkcFA3VVZ0MHhNNFgvZEcKYXdJREFRQUI=", 0)));
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public boolean a(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, file)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, empty sign: ");
                return false;
            } else if (file != null && file.exists()) {
                if (this.a == null) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, no key ");
                    return false;
                }
                try {
                    return a(str, new FileInputStream(file));
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, sign: " + str + ", error:" + e2);
                    return false;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginChecker", "Verify false, no file");
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean a(String str, InputStream inputStream) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, inputStream)) == null) ? a(str, a(inputStream)) : invokeLL.booleanValue;
    }

    private boolean a(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, bArr)) == null) {
            if (this.a == null) {
                return false;
            }
            byte[] decode = Base64.decode(str, 0);
            try {
                Signature signature = Signature.getInstance("MD5withRSA");
                signature.initVerify(this.a);
                signature.update(bArr);
                return signature.verify(decode);
            } catch (Throwable th) {
                throw new Exception("Verify sign failed", th);
            }
        }
        return invokeLL.booleanValue;
    }

    public static PublicKey a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (Exception e2) {
                throw new Exception("Init public key failed", e2);
            }
        }
        return (PublicKey) invokeL.objValue;
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Exception unused) {
                        inputStream.close();
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            inputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }
}
