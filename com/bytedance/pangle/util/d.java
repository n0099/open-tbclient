package com.bytedance.pangle.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes11.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f61518a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1401945046, "Lcom/bytedance/pangle/util/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1401945046, "Lcom/bytedance/pangle/util/d;");
                return;
            }
        }
        f61518a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr != null) {
                return a(bArr, bArr.length);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2)) == null) {
            if (bArr != null) {
                if (i2 + 0 <= bArr.length) {
                    int i3 = i2 * 2;
                    char[] cArr = new char[i3];
                    int i4 = 0;
                    for (int i5 = 0; i5 < i2; i5++) {
                        int i6 = bArr[i5 + 0] & 255;
                        int i7 = i4 + 1;
                        char[] cArr2 = f61518a;
                        cArr[i4] = cArr2[i6 >> 4];
                        i4 = i7 + 1;
                        cArr[i7] = cArr2[i6 & 15];
                    }
                    return new String(cArr, 0, i3);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLI.objValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 8192);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null) {
                try {
                    if (str.length() != 0) {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(str.getBytes("UTF-8"));
                        return a(messageDigest.digest());
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
