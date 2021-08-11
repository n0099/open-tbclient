package com.baidu.ufosdk.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(BitmapFactory.Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, options)) == null) {
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            if (i2 > 800 || i3 > 480) {
                int min = Math.min(Math.round(i2 / 800.0f), Math.round(i3 / 480.0f));
                while ((i3 * i2) / (min * min) > 768000.0f) {
                    min++;
                }
                return min;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
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
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (bitmap != null) {
                        try {
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Exception unused) {
                    if (bitmap != null) {
                        try {
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
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
            } catch (Exception unused2) {
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (Exception unused3) {
            bitmap = null;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            bitmap = null;
        }
    }
}
