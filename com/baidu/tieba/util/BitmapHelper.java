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
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class BitmapHelper {
    public static final int ROTATE_LEFT = 0;
    public static final int ROTATE_LEFT_RIGHT = 2;
    public static final int ROTATE_RIGHT = 1;
    public static final int ROTATE_UP_DOWN = 3;
    private static volatile Hashtable<Integer, Bitmap> mBitmapHash = new Hashtable<>();

    public static Bitmap getCashBitmap(int id) {
        Bitmap bm = mBitmapHash.get(Integer.valueOf(id));
        if (bm != null) {
            return bm;
        }
        Bitmap bm2 = getResBitmap(TiebaApplication.app, id);
        if (bm2 != null) {
            mBitmapHash.put(Integer.valueOf(id), bm2);
        }
        return bm2;
    }

    public static Bitmap getResBitmap(Context context, int resId) {
        Bitmap bm = null;
        try {
            BitmapFactory.Options opt = new BitmapFactory.Options();
            if (Build.VERSION.SDK_INT >= 16) {
                opt.inPreferredConfig = Bitmap.Config.ARGB_4444;
            } else {
                opt.inPreferredConfig = Config.BitmapConfig;
            }
            bm = BitmapFactory.decodeResource(context.getResources(), resId, opt);
            return bm;
        } catch (Exception ex) {
            TiebaLog.e("BitmapHelper", "getResBitmap", "error = " + ex.getMessage());
            return bm;
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

    public static Bitmap getResizedBitmap(Bitmap bitmap, int max_width, int max_height) {
        float temp;
        if (max_width <= 0 || max_height < 0 || bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        if (bitmap.getWidth() > max_width || bitmap.getHeight() > max_height) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (max_height / height < max_width / width) {
                temp = max_width / width;
            } else {
                temp = max_height / height;
            }
            Matrix matrix = new Matrix();
            float x = (max_width - (width * temp)) / 2.0f;
            float y = (max_height - (height * temp)) / 2.0f;
            matrix.postScale(temp, temp);
            matrix.postTranslate(x, y);
            Bitmap resizedBitmap = Bitmap.createBitmap(max_width, max_height, bitmap.getConfig());
            Canvas canvas = new Canvas(resizedBitmap);
            canvas.drawBitmap(bitmap, matrix, null);
            return resizedBitmap;
        }
        return bitmap;
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int maxsize) {
        return resizeBitmap(bitmap, maxsize, maxsize);
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int maxsize) {
        return getResizedBitmap(bitmap, maxsize, maxsize);
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
            if (fd != null) {
                try {
                    fd.close();
                    return null;
                } catch (Exception e2) {
                    return null;
                }
            }
            return null;
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
        if (bitmap == null) {
            return null;
        }
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
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

    public static Bitmap rotateBitmap(Bitmap bm, int direction) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        Matrix matrix = new Matrix();
        if (direction == 0) {
            matrix.postRotate(-90.0f);
        } else if (direction == 1) {
            matrix.postRotate(90.0f);
        }
        Bitmap returnBm = Bitmap.createBitmap(bm, 0, 0, w, h, matrix, true);
        if (bm != returnBm) {
            bm.recycle();
        }
        return returnBm;
    }

    public static Bitmap reversalBitmap(Bitmap bm, int direction) {
        Matrix mx = new Matrix();
        int w = bm.getWidth();
        int h = bm.getHeight();
        if (direction == 2) {
            mx.setScale(1.0f, -1.0f);
        } else if (direction == 3) {
            mx.setScale(-1.0f, 1.0f);
        }
        Bitmap btt = Bitmap.createBitmap(bm, 0, 0, w, h, mx, true);
        mx.setRotate(180.0f);
        Bitmap returnBm = Bitmap.createBitmap(btt, 0, 0, btt.getWidth(), btt.getHeight(), mx, true);
        if (btt != returnBm) {
            btt.recycle();
        }
        if (bm != returnBm) {
            bm.recycle();
        }
        return returnBm;
    }
}
