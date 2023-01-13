package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes6.dex */
public class wr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (ps9.a(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap f(String str) {
        FileInputStream fileInputStream;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fileInputStream = null;
            }
            return BitmapFactory.decodeStream(fileInputStream);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static int b(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i, i2)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            int i5 = 1;
            if (i3 > i2 || i4 > i) {
                int i6 = i3 / 2;
                int i7 = i4 / 2;
                while (i6 / i5 > i2 && i7 / i5 > i) {
                    i5 *= 2;
                }
            }
            return i5;
        }
        return invokeLII.intValue;
    }

    public static Bitmap c(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bitmap, compressFormat, i)) == null) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(compressFormat, i, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap d(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i, i2, i3, i4);
            if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap e(String str, int i, int i2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)})) == null) {
            if (!FileUtils.isExists(str)) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = b(options, i, i2);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (f % 360.0f == 0.0f) {
                return decodeFile;
            }
            if (decodeFile == null) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
            decodeFile.recycle();
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap h(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i > 0 && i2 > 0 && bitmap != null && !bitmap.isRecycled()) {
                boolean z3 = true;
                if (bitmap.getWidth() > bitmap.getHeight()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (i <= i2) {
                    z3 = false;
                }
                if (z2 != z3) {
                    i2 = i;
                    i = i2;
                }
                if (i != bitmap.getWidth() || i2 != bitmap.getHeight()) {
                    return i(bitmap, i, i2, z);
                }
                return bitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap i(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(i / width, i2 / height);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                if (z && bitmap != null && !bitmap.equals(createBitmap)) {
                    bitmap.recycle();
                }
                return createBitmap;
            }
            return null;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap g(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width == 0 || height == 0 || i == 0 || i2 == 0) {
                    return bitmap;
                }
                float f = width;
                float f2 = height;
                float f3 = (f * 1.0f) / f2;
                float f4 = i * 1.0f;
                float f5 = i2;
                float f6 = f4 / f5;
                if (Math.abs(f3 - f6) < 0.01d) {
                    i4 = width;
                } else if (f3 > f6) {
                    i4 = (i * height) / i2;
                } else {
                    i3 = (i2 * width) / i;
                    i4 = width;
                    if (width <= i4) {
                        i5 = (width - i4) / 2;
                    } else {
                        i5 = 0;
                    }
                    if (height <= i3) {
                        i6 = (height - i3) / 2;
                    } else {
                        i6 = 0;
                    }
                    Matrix matrix = new Matrix();
                    matrix.postScale(f4 / f, (f5 * 1.0f) / f2);
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, i5, i6, i4, i3, matrix, true);
                    if (z && bitmap != null && !bitmap.equals(createBitmap)) {
                        bitmap.recycle();
                    }
                    return createBitmap;
                }
                i3 = height;
                if (width <= i4) {
                }
                if (height <= i3) {
                }
                Matrix matrix2 = new Matrix();
                matrix2.postScale(f4 / f, (f5 * 1.0f) / f2);
                Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, i5, i6, i4, i3, matrix2, true);
                if (z) {
                    bitmap.recycle();
                }
                return createBitmap2;
            }
            return null;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return yn9.c().getContext();
        }
        return (Context) invokeV.objValue;
    }
}
