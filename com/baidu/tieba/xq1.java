package com.baidu.tieba;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            byte[] bArr2 = new byte[256];
            for (int i = 0; i < 256; i++) {
                bArr2[i] = (byte) i;
            }
            if (bArr != null && bArr.length != 0) {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < 256; i4++) {
                    i3 = ((bArr[i2] & 255) + (bArr2[i4] & 255) + i3) & 255;
                    byte b = bArr2[i4];
                    bArr2[i4] = bArr2[i3];
                    bArr2[i3] = b;
                    i2 = (i2 + 1) % bArr.length;
                }
                return bArr2;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, bArr2)) == null) {
            if (bArr != null && bArr2 != null) {
                return d(bArr, bArr2);
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bArr2)) == null) {
            if (bArr != null && bArr2 != null) {
                return d(bArr, bArr2);
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
            byte[] a = a(bArr2);
            byte[] bArr3 = new byte[bArr.length];
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                i = (i + 1) & 255;
                i2 = ((a[i] & 255) + i2) & 255;
                byte b = a[i];
                a[i] = a[i2];
                a[i2] = b;
                bArr3[i3] = (byte) (a[((a[i] & 255) + (a[i2] & 255)) & 255] ^ bArr[i3]);
                bArr3[i3] = (byte) (bArr3[i3] ^ ExifInterface.START_CODE);
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }
}
