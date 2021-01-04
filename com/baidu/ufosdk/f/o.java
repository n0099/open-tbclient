package com.baidu.ufosdk.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public final class o {
    private static int a(byte[] bArr, int i) {
        return bArr[i + 0] | (bArr[i + 1] << 8) | (bArr[i + 2] << 16) | (bArr[i + 3] << 24);
    }

    public static Drawable a(Context context, String str) {
        Bitmap bitmap;
        InputStream open = context.getAssets().open("ufo_res/" + str);
        Bitmap decodeStream = BitmapFactory.decodeStream(open);
        byte[] a2 = a(decodeStream);
        if (NinePatch.isNinePatchChunk(a2)) {
            bitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            decodeStream.recycle();
            Field declaredField = bitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(bitmap, a2);
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

    private static void a(Bitmap bitmap, byte[] bArr) {
        int i = 0;
        int[] iArr = new int[bitmap.getWidth() - 2];
        bitmap.getPixels(iArr, 0, iArr.length, 1, bitmap.getHeight() - 1, iArr.length, 1);
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                break;
            } else if (-16777216 == iArr[i2]) {
                a(bArr, 12, i2);
                break;
            } else {
                i2++;
            }
        }
        int length = iArr.length - 1;
        while (true) {
            if (length < 0) {
                break;
            } else if (-16777216 == iArr[length]) {
                a(bArr, 16, (iArr.length - length) - 2);
                break;
            } else {
                length--;
            }
        }
        int[] iArr2 = new int[bitmap.getHeight() - 2];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, iArr2.length);
        while (true) {
            if (i >= iArr2.length) {
                break;
            } else if (-16777216 == iArr2[i]) {
                a(bArr, 20, i);
                break;
            } else {
                i++;
            }
        }
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            if (-16777216 == iArr2[length2]) {
                a(bArr, 24, (iArr2.length - length2) - 2);
                return;
            }
        }
    }

    private static void a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private static byte[] a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int[] iArr = new int[width - 2];
        bitmap.getPixels(iArr, 0, width, 1, 0, width - 2, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[iArr.length + (-1)] == -16777216;
        int i2 = 0;
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (i2 != iArr[i4]) {
                i3++;
                a(byteArrayOutputStream, i4);
                i2 = iArr[i4];
            }
        }
        if (z2) {
            i3++;
            a(byteArrayOutputStream, length);
        }
        int i5 = i3;
        int i6 = i5 + 1;
        int i7 = z ? i6 - 1 : i6;
        int i8 = z2 ? i7 - 1 : i7;
        int[] iArr2 = new int[height - 2];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, height - 2);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[iArr2.length + (-1)] == -16777216;
        int i9 = 0;
        int length2 = iArr2.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length2; i11++) {
            if (i9 != iArr2[i11]) {
                i10++;
                a(byteArrayOutputStream, i11);
                i9 = iArr2[i11];
            }
        }
        if (z4) {
            i10++;
            a(byteArrayOutputStream, length2);
        }
        int i12 = i10 + 1;
        int i13 = z3 ? i12 - 1 : i12;
        if (z4) {
            i13--;
        }
        for (int i14 = 0; i14 < i8 * i13; i14++) {
            a(byteArrayOutputStream, 1);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray[0] = 1;
        byteArray[1] = (byte) i5;
        byteArray[2] = (byte) i10;
        byteArray[3] = (byte) (i13 * i8);
        a(bitmap, byteArray);
        return byteArray;
    }
}
