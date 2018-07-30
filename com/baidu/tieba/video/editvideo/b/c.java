package com.baidu.tieba.video.editvideo.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    public static byte[] a(int i, int i2, Bitmap bitmap) {
        try {
            int[] iArr = new int[i * i2];
            bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
            byte[] bArr = new byte[((i * i2) * 3) / 2];
            encodeYUV420SP(bArr, iArr, i, i2);
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void encodeYUV420SP(byte[] bArr, int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i * i2;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < i2) {
            int i10 = 0;
            int i11 = i8;
            int i12 = i7;
            while (i10 < i) {
                int i13 = (iArr[i11] & ViewCompat.MEASURED_STATE_MASK) >> 24;
                int i14 = (iArr[i11] & 16711680) >> 16;
                int i15 = (iArr[i11] & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                int i16 = (iArr[i11] & 255) >> 0;
                int i17 = (((((i14 * 66) + (i15 * 129)) + (i16 * 25)) + 128) >> 8) + 16;
                int i18 = (((((i14 * (-38)) - (i15 * 74)) + (i16 * 112)) + 128) >> 8) + 128;
                int i19 = (((((i14 * 112) - (i15 * 94)) - (i16 * 18)) + 128) >> 8) + 128;
                int i20 = i12 + 1;
                if (i17 < 0) {
                    i17 = 0;
                } else if (i17 > 255) {
                    i17 = 255;
                }
                bArr[i12] = (byte) i17;
                if (i9 % 2 == 0 && i11 % 2 == 0) {
                    int i21 = i6 + 1;
                    if (i19 < 0) {
                        i4 = 0;
                    } else {
                        i4 = i19 > 255 ? 255 : i19;
                    }
                    bArr[i6] = (byte) i4;
                    int i22 = i21 + 1;
                    if (i18 < 0) {
                        i5 = 0;
                    } else {
                        i5 = i18 > 255 ? 255 : i18;
                    }
                    bArr[i21] = (byte) i5;
                    i3 = i22;
                } else {
                    i3 = i6;
                }
                i10++;
                i11++;
                i6 = i3;
                i12 = i20;
            }
            i9++;
            i8 = i11;
            i7 = i12;
        }
    }

    public static byte[] z(Bitmap bitmap) {
        return a(bitmap.getWidth(), bitmap.getHeight(), bitmap);
    }

    public static Bitmap j(byte[] bArr, int i, int i2) {
        Throwable th;
        Bitmap bitmap;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            new YuvImage(bArr, 17, i, i2, null).compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
            bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        } catch (Throwable th2) {
            th = th2;
            bitmap = null;
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void as(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(UtilHelper.getUriFromFile(new File(str), intent, context));
            context.sendBroadcast(intent);
        } catch (Exception e) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.ArrayList<com.baidu.tieba.video.editvideo.b.c$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<a> A(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return new ArrayList<>();
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        loop0: for (int i2 = 0; i2 < width; i2++) {
            for (int i3 = 0; i3 < height; i3++) {
                int pixel = bitmap.getPixel(i2, i3);
                a aVar = new a(i2, i3);
                aVar.color = pixel;
                if (sparseArray.get(pixel) == null) {
                    sparseArray.put(pixel, aVar);
                    i++;
                }
                if (i == 3) {
                    break loop0;
                }
            }
        }
        ArrayList<a> arrayList = new ArrayList<>();
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            arrayList.add(sparseArray.valueAt(i4));
        }
        return arrayList;
    }

    public static boolean a(Bitmap bitmap, ArrayList<a> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            int i = next.x;
            int i2 = next.y;
            if (i >= bitmap.getWidth() || i2 >= bitmap.getHeight()) {
                return false;
            }
            int pixel = bitmap.getPixel(i, i2);
            if (sparseArray.get(pixel) != null) {
                return false;
            }
            next.color = pixel;
            sparseArray.put(pixel, next);
        }
        return true;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int color;
        public int x;
        public int y;

        public a(int i, int i2) {
            this.x = i;
            this.y = i2;
        }
    }
}
