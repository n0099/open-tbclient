package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public final class a {
    public static int a(BitmapFactory.Options options, float f2, float f3) {
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        float f4 = i2;
        if (f4 > f3 || i3 > f2) {
            int round = Math.round(f4 / f3);
            int round2 = Math.round(i3 / f2);
            return round < round2 ? round : round2;
        }
        return 1;
    }

    public static Bitmap a(byte[] bArr, float f2, float f3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        options.inSampleSize = a(options, f2, f3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static boolean a() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4) < 5242880;
    }

    public static boolean a(Context context, Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) {
        FileOutputStream fileOutputStream;
        if (a()) {
            return false;
        }
        File file = new File(str);
        new File(file.getParent()).mkdirs();
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(compressFormat, i2, fileOutputStream);
            fileOutputStream.close();
            a(context, str);
            c.a((OutputStream) fileOutputStream);
            return true;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            c.a((OutputStream) fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            c.a((OutputStream) fileOutputStream2);
            throw th;
        }
    }

    public static void a(Context context, String str) {
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(("file://" + str).replaceAll("%", "%25").replaceAll("#", "%23").replaceAll(" ", "%20"))));
    }

    public static String a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                try {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return encodeToString;
            } catch (Exception unused) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
