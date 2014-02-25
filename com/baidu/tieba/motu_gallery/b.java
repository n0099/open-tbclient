package com.baidu.tieba.motu_gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class b {
    public static Bitmap a(Context context, Uri uri, int i, int i2) {
        int i3;
        int i4;
        int i5;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(openInputStream, null, options);
        if (options.outHeight > options.outWidth) {
            i3 = options.outHeight;
            i4 = options.outWidth;
            i5 = 1;
        } else {
            i3 = options.outWidth;
            i4 = options.outHeight;
            i5 = 1;
        }
        while (true) {
            if (i4 > (i5 + 1) * i2 || i3 > (i5 + 1) * i) {
                i5++;
            } else {
                try {
                    break;
                } catch (IOException e) {
                    Log.w("ImageFile", "file close error");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        openInputStream.close();
        InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
        options.inJustDecodeBounds = false;
        options.inSampleSize = i5;
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options);
        try {
            openInputStream2.close();
        } catch (IOException e3) {
            Log.w("ImageFile", "file close error");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return decodeStream;
    }

    public static Bitmap b(Context context, Uri uri, int i, int i2) {
        return a(context, uri, i, i2, false);
    }

    public static Bitmap a(Context context, Uri uri, int i, int i2, boolean z) {
        Bitmap a;
        Bitmap a2 = a(context, uri, i, i2);
        if (a2 == null) {
            throw new OtherException();
        }
        try {
            if (a2.getWidth() > a2.getHeight()) {
                a = a(a2, i, i2);
            } else {
                a = a(a2, i2, i);
            }
            int b = w.b(context, uri, z);
            if (b != 0) {
                Matrix matrix = new Matrix();
                matrix.setRotate(b);
                return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OtherException();
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        float width = bitmap.getWidth() / i;
        float height = bitmap.getHeight() / i2;
        if (width <= height) {
            width = height;
        }
        if (width < 1.0f) {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap copy = bitmap.copy(config, true);
            bitmap.recycle();
            return copy;
        }
        return a(bitmap, width);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = (int) (width / f);
        int i2 = (int) (height / f);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(i, i2, config);
        }
        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, width, height), new Rect(0, 0, i, i2), new Paint());
        bitmap.recycle();
        return createBitmap;
    }

    public static boolean a(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return a(options);
    }

    private static boolean a(BitmapFactory.Options options) {
        float f = options.outHeight;
        float f2 = options.outWidth;
        return f != 0.0f && f2 != 0.0f && f / f2 <= 3.0f && f2 / f <= 3.0f;
    }
}
