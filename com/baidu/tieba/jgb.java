package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public final class jgb {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947883748, "Lcom/baidu/tieba/jgb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947883748, "Lcom/baidu/tieba/jgb;");
                return;
            }
        }
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            return b(bArr, bArr.length);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr, int i) {
        InterceptResult invokeLI;
        byte b;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i)) == null) {
            int i3 = (i / 4) * 3;
            if (i3 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i3];
            int i4 = i;
            int i5 = 0;
            while (true) {
                byte b2 = bArr[i4 - 1];
                b = 10;
                if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                    if (b2 != 61) {
                        break;
                    }
                    i5++;
                }
                i4--;
            }
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i6 < i4) {
                byte b3 = bArr[i6];
                if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                    if (b3 >= 65 && b3 <= 90) {
                        i2 = b3 - 65;
                    } else if (b3 >= 97 && b3 <= 122) {
                        i2 = b3 - 71;
                    } else if (b3 >= 48 && b3 <= 57) {
                        i2 = b3 + 4;
                    } else if (b3 == 43) {
                        i2 = 62;
                    } else if (b3 == 47) {
                        i2 = 63;
                    } else {
                        return null;
                    }
                    i7 = ((byte) i2) | (i7 << 6);
                    if (i9 % 4 == 3) {
                        int i10 = i8 + 1;
                        bArr2[i8] = (byte) ((16711680 & i7) >> 16);
                        int i11 = i10 + 1;
                        bArr2[i10] = (byte) ((65280 & i7) >> 8);
                        bArr2[i11] = (byte) (i7 & 255);
                        i8 = i11 + 1;
                    }
                    i9++;
                }
                i6++;
                b = 10;
            }
            if (i5 > 0) {
                int i12 = i7 << (i5 * 6);
                int i13 = i8 + 1;
                bArr2[i8] = (byte) ((i12 & 16711680) >> 16);
                if (i5 == 1) {
                    i8 = i13 + 1;
                    bArr2[i13] = (byte) ((i12 & 65280) >> 8);
                } else {
                    i8 = i13;
                }
            }
            byte[] bArr3 = new byte[i8];
            System.arraycopy(bArr2, 0, bArr3, 0, i8);
            return bArr3;
        }
        return (byte[]) invokeLI.objValue;
    }

    public static String c(byte[] bArr, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, str)) == null) {
            int length = (bArr.length * 4) / 3;
            byte[] bArr2 = new byte[length + (length / 76) + 3];
            int length2 = bArr.length - (bArr.length % 3);
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length2; i3 += 3) {
                int i4 = i + 1;
                byte[] bArr3 = a;
                bArr2[i] = bArr3[(bArr[i3] & 255) >> 2];
                int i5 = i4 + 1;
                int i6 = i3 + 1;
                bArr2[i4] = bArr3[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
                int i7 = i5 + 1;
                int i8 = i3 + 2;
                bArr2[i5] = bArr3[((bArr[i6] & 15) << 2) | ((bArr[i8] & 255) >> 6)];
                i = i7 + 1;
                bArr2[i7] = bArr3[bArr[i8] & 63];
                if ((i - i2) % 76 == 0 && i != 0) {
                    bArr2[i] = 10;
                    i2++;
                    i++;
                }
            }
            int length3 = bArr.length % 3;
            if (length3 != 1) {
                if (length3 == 2) {
                    int i9 = i + 1;
                    byte[] bArr4 = a;
                    bArr2[i] = bArr4[(bArr[length2] & 255) >> 2];
                    int i10 = i9 + 1;
                    int i11 = length2 + 1;
                    bArr2[i9] = bArr4[((bArr[i11] & 255) >> 4) | ((bArr[length2] & 3) << 4)];
                    int i12 = i10 + 1;
                    bArr2[i10] = bArr4[(bArr[i11] & 15) << 2];
                    i = i12 + 1;
                    bArr2[i12] = 61;
                }
            } else {
                int i13 = i + 1;
                byte[] bArr5 = a;
                bArr2[i] = bArr5[(bArr[length2] & 255) >> 2];
                int i14 = i13 + 1;
                bArr2[i13] = bArr5[(bArr[length2] & 3) << 4];
                int i15 = i14 + 1;
                bArr2[i14] = 61;
                i = i15 + 1;
                bArr2[i15] = 61;
            }
            return new String(bArr2, 0, i, str);
        }
        return (String) invokeLL.objValue;
    }
}
