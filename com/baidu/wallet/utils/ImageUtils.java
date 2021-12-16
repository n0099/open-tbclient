package com.baidu.wallet.utils;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ImageUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int[] decodeYUV420SP(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, bArr, i2, i3)) == null) {
            int i4 = i2 * i3;
            int[] iArr = new int[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = ((i6 >> 1) * i2) + i4;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (i8 < i2) {
                    int i11 = (bArr[i5] & 255) - 16;
                    if (i11 < 0) {
                        i11 = 0;
                    }
                    if ((i8 & 1) == 0) {
                        int i12 = i7 + 1;
                        i10 = (bArr[i7] & 255) + a.f31720g;
                        i7 = i12 + 1;
                        i9 = (bArr[i12] & 255) + a.f31720g;
                    }
                    int i13 = i11 * 1192;
                    int i14 = (i10 * 1634) + i13;
                    int i15 = (i13 - (i10 * 833)) - (i9 * 400);
                    int i16 = i13 + (i9 * 2066);
                    if (i14 < 0) {
                        i14 = 0;
                    } else if (i14 > 262143) {
                        i14 = 262143;
                    }
                    if (i15 < 0) {
                        i15 = 0;
                    } else if (i15 > 262143) {
                        i15 = 262143;
                    }
                    if (i16 < 0) {
                        i16 = 0;
                    } else if (i16 > 262143) {
                        i16 = 262143;
                    }
                    iArr[i5] = ((i16 >> 10) & 255) | ((i14 << 6) & 16711680) | (-16777216) | ((i15 >> 2) & 65280);
                    i8++;
                    i5++;
                }
            }
            return iArr;
        }
        return (int[]) invokeLII.objValue;
    }

    public static void rotateYUV240SP(byte[] bArr, byte[] bArr2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65538, null, bArr, bArr2, i2, i3) == null) {
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = 0;
                while (i6 < i3) {
                    bArr2[i4] = bArr[(i2 - i5) - 1];
                    i6++;
                    i4++;
                }
            }
            int i7 = i3 / 2;
            for (int i8 = 0; i8 < i2; i8 += 2) {
                int i9 = (i2 * i3) + i2;
                int i10 = 0;
                while (i10 < i7) {
                    int i11 = i9 - i8;
                    bArr2[i4] = bArr[i11 - 2];
                    bArr2[i4 + 1] = bArr[i11 - 1];
                    i9 += i2;
                    i10++;
                    i4 += 2;
                }
            }
        }
    }

    public static void rotateYUV240SP2(byte[] bArr, byte[] bArr2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, bArr, bArr2, i2, i3) == null) {
            int i4 = i2 * i3;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                for (int i7 = 0; i7 < i3; i7++) {
                    bArr2[i5] = bArr[(i2 * i7) + i6];
                    i5++;
                }
            }
            for (int i8 = 0; i8 < i2; i8 += 2) {
                for (int i9 = 0; i9 < i3 / 2; i9++) {
                    int i10 = (i2 * i9) + i4 + i8;
                    bArr2[i5] = bArr[i10];
                    bArr2[i5 + 1] = bArr[i10 + 1];
                    i5 += 2;
                }
            }
        }
    }

    public static byte[] rotateYUV420Degree180(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            int i4 = i2 * i3;
            int i5 = (i4 * 3) / 2;
            byte[] bArr2 = new byte[i5];
            int i6 = 0;
            for (int i7 = i4 - 1; i7 >= 0; i7--) {
                bArr2[i6] = bArr[i7];
                i6++;
            }
            for (int i8 = i5 - 1; i8 >= i4; i8 -= 2) {
                int i9 = i6 + 1;
                bArr2[i6] = bArr[i8 - 1];
                i6 = i9 + 1;
                bArr2[i9] = bArr[i8];
            }
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] rotateYUV420Degree270(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, bArr, i2, i3)) == null) {
            int i5 = i2 * i3;
            byte[] bArr2 = new byte[(i5 * 3) / 2];
            if (i2 == 0 && i3 == 0) {
                i5 = 0;
                i4 = 0;
            } else {
                i4 = i3 >> 1;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = 0;
                for (int i9 = 0; i9 < i3; i9++) {
                    bArr2[i6] = bArr[i8 + i7];
                    i6++;
                    i8 += i2;
                }
            }
            for (int i10 = 0; i10 < i2; i10 += 2) {
                int i11 = i5;
                for (int i12 = 0; i12 < i4; i12++) {
                    int i13 = i11 + i10;
                    bArr2[i6] = bArr[i13];
                    bArr2[i6 + 1] = bArr[i13 + 1];
                    i6 += 2;
                    i11 += i2;
                }
            }
            return rotateYUV420Degree180(bArr2, i2, i3);
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] rotateYUV420Degree90(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i2, i3)) == null) {
            int i4 = i2 * i3;
            int i5 = (i4 * 3) / 2;
            byte[] bArr2 = new byte[i5];
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                for (int i8 = i3 - 1; i8 >= 0; i8--) {
                    bArr2[i6] = bArr[(i8 * i2) + i7];
                    i6++;
                }
            }
            int i9 = i5 - 1;
            for (int i10 = i2 - 1; i10 > 0; i10 -= 2) {
                for (int i11 = 0; i11 < i3 / 2; i11++) {
                    int i12 = (i11 * i2) + i4;
                    bArr2[i9] = bArr[i12 + i10];
                    int i13 = i9 - 1;
                    bArr2[i13] = bArr[i12 + (i10 - 1)];
                    i9 = i13 - 1;
                }
            }
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }
}
