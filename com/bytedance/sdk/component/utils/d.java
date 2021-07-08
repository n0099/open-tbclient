package com.bytedance.sdk.component.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r1 == null) goto L17;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Bitmap bitmap) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, bitmap)) != null) {
            return (String) invokeL.objValue;
        }
        String str = null;
        if (bitmap == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (Throwable unused3) {
            return str;
        }
    }

    public static byte[] b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitmap)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    @Nullable
    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] decode = Base64.decode(str, 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, bitmap, i2, i3)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (i2 <= 0 || i3 <= 0) {
                return bitmap;
            }
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (i2 < width && i3 < height) {
                    Matrix matrix = new Matrix();
                    matrix.postScale(i2 / width, i3 / height);
                    return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                }
                return bitmap;
            } catch (Throwable th) {
                j.a(th.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }
}
