package com.bun.miitmdid.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f27826a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-511688931, "Lcom/bun/miitmdid/utils/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-511688931, "Lcom/bun/miitmdid/utils/d;");
                return;
            }
        }
        f27826a = "#PART#".getBytes();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new String(Base64.encode(a(str.getBytes(), Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6ZetPcgLCvLsvDWzA3TYpRhEO\nfncquhfl9utVX+VApfrknKvYInYzmxjhdAEay+Nn6NPJKGPkCt1D7VWbf0YPiLmo\noCTIsuc7czZOu9pBJYjOrqCZhhJsJucc3+T/un8KioD2CjkXy0EhNMJSuvo+tHJg\nTbiR4QuPcIU1YBLX4wIDAQAB".getBytes(), 0)), 2));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bArr2)) == null) {
            int length = bArr.length;
            if (length <= 117) {
                return b(bArr, bArr2);
            }
            ArrayList<Byte> arrayList = new ArrayList(2048);
            byte[] bArr3 = new byte[117];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < length) {
                bArr3[i4] = bArr[i3];
                i4++;
                if (i4 == 117 || i3 == length - 1) {
                    i5++;
                    if (i5 != 1) {
                        for (byte b2 : f27826a) {
                            arrayList.add(Byte.valueOf(b2));
                        }
                    }
                    for (byte b3 : b(bArr3, bArr2)) {
                        arrayList.add(Byte.valueOf(b3));
                    }
                    bArr3 = i3 == length + (-1) ? null : new byte[Math.min(117, (length - i3) - 1)];
                    i4 = 0;
                }
                i3++;
            }
            byte[] bArr4 = new byte[arrayList.size()];
            for (Byte b4 : arrayList) {
                bArr4[i2] = b4.byteValue();
                i2++;
            }
            return bArr4;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(1, generatePublic);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }
}
