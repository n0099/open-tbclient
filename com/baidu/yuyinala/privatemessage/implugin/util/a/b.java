package com.baidu.yuyinala.privatemessage.implugin.util.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes10.dex */
public class b {
    private static final String TAG;
    private static final boolean oXb;
    public static double oXc;

    static {
        oXb = Build.VERSION.SDK_INT >= 11;
        TAG = b.class.getSimpleName();
        oXc = 1.778d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [106=5, 108=4, 109=4, 110=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0070 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0072 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0074 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Bitmap bitmap, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        try {
            try {
                fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            fileOutputStream = fileOutputStream2;
                        } catch (IOException e) {
                            String str = TAG;
                            com.baidu.yuyinala.privatemessage.implugin.util.c.e(str, e.getMessage());
                            fileOutputStream = str;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e(TAG, e.getMessage());
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            fileOutputStream = fileOutputStream2;
                        } catch (IOException e3) {
                            String str2 = TAG;
                            com.baidu.yuyinala.privatemessage.implugin.util.c.e(str2, e3.getMessage());
                            fileOutputStream = str2;
                        }
                    }
                    return file.getAbsolutePath();
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e(TAG, e.getMessage());
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            fileOutputStream = fileOutputStream2;
                        } catch (IOException e5) {
                            String str3 = TAG;
                            com.baidu.yuyinala.privatemessage.implugin.util.c.e(str3, e5.getMessage());
                            fileOutputStream = str3;
                        }
                    }
                    return file.getAbsolutePath();
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e(TAG, e6.getMessage());
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileOutputStream2 = null;
        } catch (Exception e8) {
            e = e8;
            fileOutputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
        return file.getAbsolutePath();
    }

    public static Bitmap a(Context context, String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (new File(str).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                if (Math.max(options.outWidth, options.outHeight) > 0) {
                    float max = f / Math.max(options.outWidth, options.outHeight);
                    float f2 = max <= 1.0f ? max : 1.0f;
                    options.inSampleSize = bA(f2);
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                    e(options);
                    return a(BitmapFactory.decodeFile(str, options), f2, readPictureDegree(str), f);
                }
                return null;
            } catch (OutOfMemoryError e) {
                Log.e("ImageUtil", "getBitmapThumbnail OutOfMemoryError", e);
                return null;
            }
        }
        Log.d(TAG, "The file does not exist!");
        return null;
    }

    public static Bitmap a(Bitmap bitmap, float f, int i, float f2) {
        if (bitmap == null) {
            return null;
        }
        float max = f2 / Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (max <= 0.5d) {
            bitmap = a(bitmap, max, true);
        }
        return b(i, Z(bitmap));
    }

    private static Bitmap a(Bitmap bitmap, float f, boolean z) {
        int round = Math.round(bitmap.getWidth() * f);
        int round2 = Math.round(bitmap.getHeight() * f);
        if (round != bitmap.getWidth() || round2 != bitmap.getHeight()) {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(round, round2, config);
            Canvas canvas = new Canvas(createBitmap);
            canvas.scale(f, f);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
            if (z) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return bitmap;
    }

    private static Bitmap Z(Bitmap bitmap) {
        if (bitmap != null && bitmap.getConfig() == null) {
            Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            bitmap.recycle();
            return copy;
        }
        return bitmap;
    }

    @TargetApi(11)
    private static void e(BitmapFactory.Options options) {
        if (oXb) {
            options.inMutable = true;
        }
    }

    public static int readPictureDegree(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return SubsamplingScaleImageView.ORIENTATION_270;
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            return 0;
        }
    }

    private static int bA(float f) {
        int floor = (int) Math.floor(1.0f / f);
        if (floor <= 1) {
            return 1;
        }
        return floor <= 8 ? NF(floor) : (floor / 8) * 8;
    }

    private static int NF(int i) throws IllegalArgumentException {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        return Integer.highestOneBit(i);
    }

    public static Bitmap b(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static int[] d(Context context, int i, int i2) {
        int i3;
        int i4;
        int[] iArr = new int[2];
        int i5 = ((int) context.getResources().getDisplayMetrics().density) * 120;
        if (i >= i2) {
            i4 = (int) ((i5 / i) * i2);
            i3 = i5;
        } else {
            i3 = (int) ((i5 / i2) * i);
            i4 = i5;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        return iArr;
    }
}
