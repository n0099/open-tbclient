package com.baidu.tieba.util;

import android.content.ContentResolver;
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
import com.baidu.tieba.data.Config;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BitmapHelper {
    private static volatile HashMap<Integer, Bitmap> mBitmapHash = new HashMap<>();

    public static Bitmap getCashBitmap(int id) {
        Bitmap bm = mBitmapHash.get(Integer.valueOf(id));
        if (bm != null) {
            return bm;
        }
        Bitmap bm2 = getResBitmap(TiebaApplication.app, id);
        if (bm2 != null) {
            synchronized (BitmapHelper.class) {
                mBitmapHash.put(Integer.valueOf(id), bm2);
            }
        }
        return bm2;
    }

    public static Bitmap getResBitmap(Context context, int resId) {
        try {
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inPreferredConfig = Config.BitmapConfig;
            Bitmap bm = BitmapFactory.decodeResource(context.getResources(), resId, opt);
            return bm;
        } catch (Exception ex) {
            TiebaLog.e("BitmapHelper", "getResBitmap", "error = " + ex.getMessage());
            return null;
        }
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int max_widht, int max_height) {
        float temp;
        if (max_widht <= 0 || max_height < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > max_widht || bitmap.getHeight() > max_height) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (max_height / height > max_widht / width) {
                temp = max_widht / width;
            } else {
                temp = max_height / height;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(temp, temp);
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (resizedBitmap != bitmap) {
                bitmap.recycle();
            }
            return resizedBitmap;
        }
        return bitmap;
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int maxsize) {
        return resizeBitmap(bitmap, maxsize, maxsize);
    }

    public static Bitmap resizeBitmap(String file_name, int maxsize) {
        Bitmap b = subSampleBitmap(file_name, maxsize);
        return resizeBitmap(b, maxsize);
    }

    public static Bitmap subSampleBitmap(String file_name, int maxsize) {
        int s = 1;
        if (file_name == null || file_name.length() <= 0 || maxsize <= 0) {
            return null;
        }
        try {
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inJustDecodeBounds = true;
            InputStream in = FileHelper.GetStreamFromFile(file_name);
            BitmapFactory.decodeStream(in, null, opt);
            opt.inPreferredConfig = Config.BitmapConfig;
            try {
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            while (true) {
                if (opt.outWidth / (s * 2) > maxsize || opt.outHeight / (s * 2) > maxsize) {
                    s *= 2;
                } else {
                    opt.inJustDecodeBounds = false;
                    opt.inSampleSize = s;
                    InputStream in2 = FileHelper.GetStreamFromFile(file_name);
                    Bitmap decodeStream = BitmapFactory.decodeStream(in2, null, opt);
                    try {
                        in2.close();
                        return decodeStream;
                    } catch (Exception ex2) {
                        ex2.printStackTrace();
                        return decodeStream;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap resizeBitmap(Context context, Uri uri, int maxsize) {
        Bitmap b = subSampleBitmap(context, uri, maxsize);
        return resizeBitmap(b, maxsize);
    }

    public static Bitmap subSampleBitmap(Context context, Uri uri, int maxsize) {
        ContentResolver res = context.getContentResolver();
        ParcelFileDescriptor fd = null;
        int s = 1;
        try {
            fd = res.openFileDescriptor(uri, "r");
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inPreferredConfig = Config.BitmapConfig;
            opt.inDither = false;
            opt.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fd.getFileDescriptor(), null, opt);
            while (true) {
                if (opt.outWidth / (s + 1) > maxsize || opt.outHeight / (s + 1) > maxsize) {
                    s++;
                } else {
                    opt.inJustDecodeBounds = false;
                    opt.inSampleSize = s;
                    return BitmapFactory.decodeFileDescriptor(fd.getFileDescriptor(), null, opt);
                }
            }
        } catch (Exception e) {
            try {
                fd.close();
                return null;
            } catch (Exception e2) {
                return null;
            }
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
        if (bitmap == null) {
            return null;
        }
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
            return output;
        }
        return output;
    }

    public static byte[] Bitmap2Bytes(Bitmap bm, int quality) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        return baos.toByteArray();
    }

    public static Bitmap Bytes2Bitmap(byte[] b) {
        if (b == null || b.length == 0) {
            return null;
        }
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Config.BitmapConfig;
        return BitmapFactory.decodeByteArray(b, 0, b.length, opt);
    }

    public static Bitmap rotateBitmap(Bitmap bm, float degrees) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        Bitmap returnBm = Bitmap.createBitmap(bm, 0, 0, w, h, matrix, true);
        return returnBm;
    }
}
