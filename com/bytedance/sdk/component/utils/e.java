package com.bytedance.sdk.component.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f65236a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1410335911, "Lcom/bytedance/sdk/component/utils/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1410335911, "Lcom/bytedance/sdk/component/utils/e;");
                return;
            }
        }
        f65236a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr != null) {
                return a(bArr, 0, bArr.length);
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            if (bArr != null) {
                if (i2 >= 0 && i2 + i3 <= bArr.length) {
                    int i4 = i3 * 2;
                    char[] cArr = new char[i4];
                    int i5 = 0;
                    for (int i6 = 0; i6 < i3; i6++) {
                        int i7 = bArr[i6 + i2] & 255;
                        int i8 = i5 + 1;
                        char[] cArr2 = f65236a;
                        cArr[i5] = cArr2[i7 >> 4];
                        i5 = i8 + 1;
                        cArr[i8] = cArr2[i7 & 15];
                    }
                    return new String(cArr, 0, i4);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException("bytes is null");
        }
        return (String) invokeLII.objValue;
    }

    public static String a(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 8192);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String a2 = a(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return a2;
            } catch (Throwable unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
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
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
