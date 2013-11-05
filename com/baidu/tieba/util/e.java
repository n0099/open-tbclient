package com.baidu.tieba.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2449a = new Object();
    private static volatile Hashtable<Integer, Bitmap> b = new Hashtable<>();

    public static Bitmap a(int i) {
        Bitmap bitmap = b.get(Integer.valueOf(i));
        if (bitmap == null && (bitmap = b(TiebaApplication.g(), i)) != null) {
            b.put(Integer.valueOf(i), bitmap);
        }
        return bitmap;
    }

    public static int a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static void a() {
        b.clear();
    }

    public static Bitmap a(Context context, int i) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = com.baidu.tieba.data.h.m;
            return BitmapFactory.decodeResource(context.getResources(), i, options);
        } catch (Throwable th) {
            be.b("BitmapHelper", "getResBitmap", "error = " + th.getMessage());
            return null;
        }
    }

    public static Bitmap b(Context context, int i) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, new BitmapFactory.Options());
        } catch (Throwable th) {
            be.b("BitmapHelper", "getResBitmap", "error = " + th.getMessage());
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        float f;
        Bitmap createBitmap;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i2 / height > i / width) {
                f = i / width;
            } else {
                f = i2 / height;
            }
            synchronized (f2449a) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                if (createBitmap != bitmap) {
                    bitmap.recycle();
                }
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2) {
        float f;
        Bitmap createBitmap;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i2 / height < i / width) {
                f = i / width;
            } else {
                f = i2 / height;
            }
            synchronized (f2449a) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                matrix.postTranslate((i - (width * f)) / 2.0f, (i2 - (height * f)) / 2.0f);
                createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
                new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap c(Bitmap bitmap, int i, int i2) {
        float f;
        Bitmap createBitmap;
        if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i2 / height > i / width) {
                f = i / width;
            } else {
                f = i2 / height;
            }
            synchronized (f2449a) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            return createBitmap;
        }
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        return a(bitmap, i, i);
    }

    public static Bitmap b(Bitmap bitmap, int i) {
        return b(bitmap, i, i);
    }

    public static Bitmap a(String str, int i) {
        Bitmap decodeStream;
        int i2 = 1;
        if (str == null || str.length() <= 0 || i <= 0) {
            return null;
        }
        try {
            synchronized (f2449a) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream h = w.h(str);
                BitmapFactory.decodeStream(h, null, options);
                options.inPreferredConfig = com.baidu.tieba.data.h.m;
                g.a(h);
                while (true) {
                    if (options.outWidth / (i2 * 2) > i || options.outHeight / (i2 * 2) > i) {
                        i2 *= 2;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        InputStream h2 = w.h(str);
                        decodeStream = BitmapFactory.decodeStream(h2, null, options);
                        g.a(h2);
                    }
                }
            }
            return decodeStream;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Bitmap a(Context context, Uri uri, int i) {
        ParcelFileDescriptor parcelFileDescriptor;
        ParcelFileDescriptor openFileDescriptor;
        Bitmap decodeFileDescriptor;
        int i2 = 1;
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        } catch (Throwable th) {
            parcelFileDescriptor = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = com.baidu.tieba.data.h.m;
            options.inDither = false;
            options.inJustDecodeBounds = true;
            synchronized (f2449a) {
                BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                while (true) {
                    if (options.outWidth / (i2 + 1) > i || options.outHeight / (i2 + 1) > i) {
                        i2++;
                    } else {
                        options.inJustDecodeBounds = false;
                        options.inSampleSize = i2;
                        decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                    }
                }
            }
            return decodeFileDescriptor;
        } catch (Throwable th2) {
            parcelFileDescriptor = openFileDescriptor;
            if (parcelFileDescriptor != null) {
                try {
                    parcelFileDescriptor.close();
                } catch (Throwable th3) {
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0057, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0052, code lost:
        if (r0 == r11) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0054, code lost:
        r11.recycle();
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0058 -> B:12:0x0059). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Bitmap bitmap, float f) {
        Bitmap bitmap2 = null;
        try {
            synchronized (f2449a) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                    try {
                        Canvas canvas = new Canvas(createBitmap);
                        Paint paint = new Paint();
                        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        RectF rectF = new RectF(rect);
                        paint.setAntiAlias(true);
                        canvas.drawARGB(0, 0, 0, 0);
                        paint.setColor(-12434878);
                        canvas.drawRoundRect(rectF, f, f, paint);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                        canvas.drawBitmap(bitmap, rect, rect, paint);
                    } catch (Throwable th) {
                        bitmap2 = createBitmap;
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            try {
                throw th;
            } catch (Throwable th3) {
                return bitmap2;
            }
        } catch (Throwable th4) {
            return null;
        }
    }

    public static Bitmap b(Bitmap bitmap) {
        Bitmap createBitmap;
        if (bitmap == null) {
            return null;
        }
        synchronized (f2449a) {
            if (bitmap.getHeight() < bitmap.getWidth()) {
                createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - bitmap.getHeight()) >> 1, 0, bitmap.getHeight(), bitmap.getHeight());
            } else {
                createBitmap = bitmap.getHeight() > bitmap.getWidth() ? Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - bitmap.getWidth()) >> 1, bitmap.getWidth(), bitmap.getWidth()) : bitmap;
            }
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
        }
        return createBitmap;
    }

    public static byte[] c(Bitmap bitmap, int i) {
        byte[] byteArray;
        synchronized (f2449a) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public static Bitmap a(byte[] bArr) {
        Bitmap bitmap;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = com.baidu.tieba.data.h.m;
        try {
            synchronized (f2449a) {
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    try {
                        return decodeByteArray;
                    } catch (Throwable th2) {
                        bitmap = decodeByteArray;
                        th = th2;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    bitmap = null;
                    th = th4;
                }
            }
            try {
                break;
                throw th;
            } catch (OutOfMemoryError e) {
                return bitmap;
            }
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }

    public static Bitmap d(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (f2449a) {
            Matrix matrix = new Matrix();
            if (i == 0) {
                matrix.postRotate(-90.0f);
            } else if (i == 1) {
                matrix.postRotate(90.0f);
            }
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (OutOfMemoryError e) {
                bitmap2 = null;
            }
            if (bitmap2 == null) {
                bitmap2 = bitmap;
            }
            if (bitmap != bitmap2) {
                bitmap.recycle();
            }
        }
        return bitmap2;
    }

    public static Bitmap e(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        synchronized (f2449a) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
            try {
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (OutOfMemoryError e) {
                bitmap2 = null;
            }
            if (bitmap2 == null) {
                bitmap2 = bitmap;
            }
            if (bitmap != bitmap2) {
                bitmap.recycle();
            }
        }
        return bitmap2;
    }

    public static Bitmap f(Bitmap bitmap, int i) {
        Bitmap createBitmap;
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 2) {
            matrix.setScale(1.0f, -1.0f);
        } else if (i == 3) {
            matrix.setScale(-1.0f, 1.0f);
        }
        synchronized (f2449a) {
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            matrix.setRotate(180.0f);
            createBitmap = Bitmap.createBitmap(createBitmap2, 0, 0, createBitmap2.getWidth(), createBitmap2.getHeight(), matrix, true);
            if (createBitmap2 != createBitmap) {
                createBitmap2.recycle();
            }
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
        }
        return createBitmap;
    }

    public static int b(int i) {
        int as = TiebaApplication.g().as();
        if (i > 15) {
            if (as == 1) {
                return R.drawable.icon_grade_yellow_1;
            }
            return R.drawable.icon_grade_yellow;
        } else if (i > 9) {
            if (as == 1) {
                return R.drawable.icon_grade_red_1;
            }
            return R.drawable.icon_grade_red;
        } else if (i > 3) {
            if (as == 1) {
                return R.drawable.icon_grade_blue_1;
            }
            return R.drawable.icon_grade_blue;
        } else if (i > 0) {
            if (as == 1) {
                return R.drawable.icon_grade_green_1;
            }
            return R.drawable.icon_grade_green;
        } else {
            return 0;
        }
    }
}
