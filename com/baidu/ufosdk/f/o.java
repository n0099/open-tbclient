package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, bArr, i2)) == null) {
            return (bArr[i2 + 3] << 24) | (bArr[i2 + 1] << 8) | bArr[i2 + 0] | (bArr[i2 + 2] << 16);
        }
        return invokeLI.intValue;
    }

    public static Drawable a(Context context, String str) {
        InterceptResult invokeLL;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            AssetManager assets = context.getAssets();
            InputStream open = assets.open("ufo_res/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            byte[] a2 = a(decodeStream);
            if (NinePatch.isNinePatchChunk(a2)) {
                Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
                decodeStream.recycle();
                Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
                declaredField.setAccessible(true);
                declaredField.set(createBitmap, a2);
                bitmap = createBitmap;
            } else {
                bitmap = decodeStream;
            }
            open.close();
            if (bitmap.getNinePatchChunk() == null) {
                return new BitmapDrawable(bitmap);
            }
            Rect rect = new Rect();
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            rect.left = a(ninePatchChunk, 12);
            rect.right = a(ninePatchChunk, 16);
            rect.top = a(ninePatchChunk, 20);
            rect.bottom = a(ninePatchChunk, 24);
            return new NinePatchDrawable(context.getResources(), bitmap, bitmap.getNinePatchChunk(), rect, null);
        }
        return (Drawable) invokeLL.objValue;
    }

    public static void a(Bitmap bitmap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bitmap, bArr) == null) {
            int width = bitmap.getWidth() - 2;
            int[] iArr = new int[width];
            bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= width) {
                    break;
                } else if (-16777216 == iArr[i3]) {
                    a(bArr, 12, i3);
                    break;
                } else {
                    i3++;
                }
            }
            int i4 = width - 1;
            while (true) {
                if (i4 < 0) {
                    break;
                } else if (-16777216 == iArr[i4]) {
                    a(bArr, 16, (width - i4) - 2);
                    break;
                } else {
                    i4--;
                }
            }
            int height = bitmap.getHeight() - 2;
            int[] iArr2 = new int[height];
            bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
            while (true) {
                if (i2 >= height) {
                    break;
                } else if (-16777216 == iArr2[i2]) {
                    a(bArr, 20, i2);
                    break;
                } else {
                    i2++;
                }
            }
            for (int i5 = height - 1; i5 >= 0; i5--) {
                if (-16777216 == iArr2[i5]) {
                    a(bArr, 24, (height - i5) - 2);
                    return;
                }
            }
        }
    }

    public static void a(OutputStream outputStream, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, outputStream, i2) == null) {
            outputStream.write((i2 >> 0) & 255);
            outputStream.write((i2 >> 8) & 255);
            outputStream.write((i2 >> 16) & 255);
            outputStream.write((i2 >> 24) & 255);
        }
    }

    public static void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3) == null) {
            bArr[i2 + 0] = (byte) (i3 >> 0);
            bArr[i2 + 1] = (byte) (i3 >> 8);
            bArr[i2 + 2] = (byte) (i3 >> 16);
            bArr[i2 + 3] = (byte) (i3 >> 24);
        }
    }

    public static byte[] a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bitmap)) != null) {
            return (byte[]) invokeL.objValue;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < 32; i2++) {
            byteArrayOutputStream.write(0);
        }
        int i3 = width - 2;
        int[] iArr = new int[i3];
        bitmap.getPixels(iArr, 0, width, 1, 0, i3, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[i3 + (-1)] == -16777216;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            if (i4 != iArr[i6]) {
                i5++;
                a(byteArrayOutputStream, i6);
                i4 = iArr[i6];
            }
        }
        if (z2) {
            i5++;
            a(byteArrayOutputStream, i3);
        }
        int i7 = i5 + 1;
        if (z) {
            i7--;
        }
        if (z2) {
            i7--;
        }
        int i8 = height - 2;
        int[] iArr2 = new int[i8];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i8);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[i8 + (-1)] == -16777216;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i8; i11++) {
            if (i9 != iArr2[i11]) {
                i10++;
                a(byteArrayOutputStream, i11);
                i9 = iArr2[i11];
            }
        }
        if (z4) {
            i10++;
            a(byteArrayOutputStream, i8);
        }
        int i12 = i10 + 1;
        if (z3) {
            i12--;
        }
        if (z4) {
            i12--;
        }
        int i13 = 0;
        while (true) {
            int i14 = i7 * i12;
            if (i13 >= i14) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i5;
                byteArray[2] = (byte) i10;
                byteArray[3] = (byte) i14;
                a(bitmap, byteArray);
                return byteArray;
            }
            a(byteArrayOutputStream, 1);
            i13++;
        }
    }
}
