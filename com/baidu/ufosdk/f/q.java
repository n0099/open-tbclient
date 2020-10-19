package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
/* loaded from: classes22.dex */
public final class q {
    private static int a(BitmapFactory.Options options) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        int i3 = 1;
        if (i > 800 || i2 > 480) {
            i3 = Math.min(Math.round(i / 800.0f), Math.round(i2 / 480.0f));
            while ((i * i2) / (i3 * i3) > 768000.0f) {
                i3++;
            }
        }
        return i3;
    }

    public static byte[] a(byte[] bArr) {
        Bitmap bitmap;
        ByteArrayOutputStream byteArrayOutputStream;
        Bitmap bitmap2;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        if (bArr == null) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = a(options);
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inJustDecodeBounds = false;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            try {
                bitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), new Matrix(), true);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Exception e) {
                    byteArrayOutputStream = null;
                    bitmap2 = bitmap;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                bitmap2 = decodeByteArray;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                bitmap = decodeByteArray;
                th = th2;
            }
        } catch (Exception e3) {
            byteArrayOutputStream = null;
            bitmap2 = null;
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream2);
            byteArrayOutputStream2.flush();
            byteArrayOutputStream2.close();
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return byteArray;
                }
            }
            byteArrayOutputStream2.flush();
            byteArrayOutputStream2.close();
            return byteArray;
        } catch (Exception e5) {
            byteArrayOutputStream = byteArrayOutputStream2;
            bitmap2 = bitmap;
            if (bitmap2 != null) {
                try {
                    if (!bitmap2.isRecycled()) {
                        bitmap2.recycle();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return null;
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream3 = byteArrayOutputStream2;
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                    throw th;
                }
            }
            if (byteArrayOutputStream3 != null) {
                byteArrayOutputStream3.flush();
                byteArrayOutputStream3.close();
            }
            throw th;
        }
    }
}
