package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
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
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Bitmap bitmap;
        ByteArrayOutputStream byteArrayOutputStream2;
        Bitmap bitmap2;
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
            bitmap2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            try {
                bitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), new Matrix(), true);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
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
                            } catch (Exception e) {
                                e.printStackTrace();
                                return byteArray;
                            }
                        }
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        return byteArray;
                    } catch (Exception e2) {
                        bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            try {
                                if (!bitmap2.isRecycled()) {
                                    bitmap2.recycle();
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (bitmap != null) {
                            try {
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.flush();
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    byteArrayOutputStream2 = null;
                    bitmap2 = bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e6) {
                byteArrayOutputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                bitmap = bitmap2;
            }
        } catch (Exception e7) {
            byteArrayOutputStream2 = null;
            bitmap2 = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            bitmap = null;
        }
    }
}
