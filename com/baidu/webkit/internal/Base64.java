package com.baidu.webkit.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes2.dex */
public class Base64 implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte INTERNAL_PADDING = 35;
    public static final byte[] base64DecMap;
    public static final byte[] base64EncMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-986854407, "Lcom/baidu/webkit/internal/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-986854407, "Lcom/baidu/webkit/internal/Base64;");
                return;
            }
        }
        base64EncMap = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        base64DecMap = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62, 0, 0, 0, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, 0, 0, 0, 0, 0};
    }

    public Base64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] decode(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            byte[] bArr2 = new byte[bArr.length];
            int i3 = 0;
            int i4 = 0;
            boolean z = false;
            for (byte b2 : bArr) {
                if (b2 == 35) {
                    z = true;
                } else if (((48 > b2 || b2 > 57) && ((65 > b2 || b2 > 90) && !((97 <= b2 && b2 <= 122) || b2 == 43 || b2 == 47))) || z) {
                    return null;
                } else {
                    bArr2[i4] = base64DecMap[b2];
                    i4++;
                }
            }
            if (i4 == 0 || i4 % 4 == 1 || (i2 = i4 - ((i4 + 3) / 4)) == 0) {
                return null;
            }
            int i5 = 0;
            if (i2 > 1) {
                while (i3 < i2 - 2) {
                    int i6 = i5 + 1;
                    bArr2[i3] = (byte) (((bArr2[i5] << 2) & 255) | ((bArr2[i6] >> 4) & 3));
                    int i7 = i5 + 2;
                    bArr2[i3 + 1] = (byte) (((bArr2[i6] << 4) & 255) | ((bArr2[i7] >> 2) & 15));
                    bArr2[i3 + 2] = (byte) (((bArr2[i7] << 6) & 255) | (bArr2[i5 + 3] & 63));
                    i5 += 4;
                    i3 += 3;
                }
            }
            if (i3 < i2) {
                bArr2[i3] = (byte) (((bArr2[i5] << 2) & 255) | ((bArr2[i5 + 1] >> 4) & 3));
            }
            int i8 = i3 + 1;
            if (i8 < i2) {
                bArr2[i8] = (byte) (((bArr2[i5 + 2] >> 2) & 15) | ((bArr2[i5 + 1] << 4) & 255));
            }
            return getSubData(bArr2, i2);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] encode(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, bArr, z)) == null) {
            if (bArr == null || bArr.length <= 0 || bArr.length > 1589695684) {
                return null;
            }
            int length = ((bArr.length + 2) / 3) * 4;
            int i4 = 0;
            boolean z2 = z && length > 76;
            if (z2) {
                length += (length - 1) / 76;
            }
            byte[] bArr2 = new byte[length];
            if (bArr.length > 1) {
                i2 = 0;
                i3 = 0;
                while (i4 < bArr.length - 2) {
                    if (z2) {
                        if (i2 != 0 && i2 % 76 != 0) {
                            bArr2[i3] = 10;
                            i3++;
                        }
                        i2 += 4;
                    }
                    int i5 = i3 + 1;
                    byte[] bArr3 = base64EncMap;
                    bArr2[i3] = bArr3[(bArr[i4] >> 2) & 63];
                    int i6 = i5 + 1;
                    int i7 = i4 + 1;
                    bArr2[i5] = bArr3[((bArr[i7] >> 4) & 15) | ((bArr[i4] << 4) & 63)];
                    int i8 = i6 + 1;
                    int i9 = i4 + 2;
                    bArr2[i6] = bArr3[((bArr[i7] << 2) & 63) | ((bArr[i9] >> 6) & 3)];
                    i3 = i8 + 1;
                    bArr2[i8] = bArr3[bArr[i9] & 63];
                    i4 += 3;
                }
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (i4 < bArr.length) {
                if (z2 && i2 > 0 && i2 % 76 != 0) {
                    bArr2[i3] = 10;
                    i3++;
                }
                int i10 = i3 + 1;
                byte[] bArr4 = base64EncMap;
                bArr2[i3] = bArr4[(bArr[i4] >> 2) & 63];
                if (i4 < bArr.length - 1) {
                    int i11 = i10 + 1;
                    int i12 = i4 + 1;
                    bArr2[i10] = bArr4[((bArr[i4] << 4) & 63) | ((bArr[i12] >> 4) & 15)];
                    i3 = i11 + 1;
                    bArr2[i11] = bArr4[(bArr[i12] << 2) & 63];
                } else {
                    i3 = i10 + 1;
                    bArr2[i10] = bArr4[(bArr[i4] << 4) & 63];
                }
            }
            while (i3 < length) {
                bArr2[i3] = INTERNAL_PADDING;
                i3++;
            }
            return bArr2;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public static byte[] getSubData(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2)) == null) {
            if (i2 <= 0) {
                return null;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }
        return (byte[]) invokeLI.objValue;
    }
}
