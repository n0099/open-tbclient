package com.bytedance.sdk.component.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.UnsupportedEncodingException;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f64748a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f64749b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731338777, "Lcom/bytedance/sdk/component/b/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731338777, "Lcom/bytedance/sdk/component/b/a/b;");
                return;
            }
        }
        f64748a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f64749b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? a(bArr, f64748a) : (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
            int length = bArr.length - (bArr.length % 3);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3 += 3) {
                int i4 = i2 + 1;
                bArr3[i2] = bArr2[(bArr[i3] & 255) >> 2];
                int i5 = i4 + 1;
                int i6 = i3 + 1;
                bArr3[i4] = bArr2[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
                int i7 = i5 + 1;
                int i8 = i3 + 2;
                bArr3[i5] = bArr2[((bArr[i6] & 15) << 2) | ((bArr[i8] & 255) >> 6)];
                i2 = i7 + 1;
                bArr3[i7] = bArr2[bArr[i8] & 63];
            }
            int length2 = bArr.length % 3;
            if (length2 == 1) {
                int i9 = i2 + 1;
                bArr3[i2] = bArr2[(bArr[length] & 255) >> 2];
                int i10 = i9 + 1;
                bArr3[i9] = bArr2[(bArr[length] & 3) << 4];
                bArr3[i10] = 61;
                bArr3[i10 + 1] = 61;
            } else if (length2 == 2) {
                int i11 = i2 + 1;
                bArr3[i2] = bArr2[(bArr[length] & 255) >> 2];
                int i12 = i11 + 1;
                int i13 = length + 1;
                bArr3[i11] = bArr2[((bArr[i13] & 255) >> 4) | ((bArr[length] & 3) << 4)];
                bArr3[i12] = bArr2[(bArr[i13] & 15) << 2];
                bArr3[i12 + 1] = 61;
            }
            try {
                return new String(bArr3, "US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
        return (String) invokeLL.objValue;
    }
}
