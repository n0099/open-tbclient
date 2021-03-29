package com.baidu.wallet.base.camera.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.apollon.imagemanager.ImageProcessor;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public abstract class ImageUtils implements NoProguard {
    public static final boolean DEBUG = true;
    public static final String TAG = "ImageUtils";
    public static final int UNCONSTRAINED = -1;

    public static int calSampleSize(Context context, Uri uri) {
        int i;
        int[] screenSize;
        if (context != null && uri != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            ParcelFileDescriptor parcelFileDescriptor = null;
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, r.f7664a);
                if (openFileDescriptor != null) {
                    try {
                        BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                        i = options.outWidth * options.outHeight;
                    } catch (Exception unused) {
                        parcelFileDescriptor = openFileDescriptor;
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return 1;
                    } catch (Throwable th) {
                        th = th;
                        parcelFileDescriptor = openFileDescriptor;
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    i = 0;
                }
                if (openFileDescriptor != null) {
                    try {
                        openFileDescriptor.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (i == 0 || (screenSize = getScreenSize(context)) == null) {
                    return 1;
                }
                return (int) Math.ceil(Math.sqrt(i / (screenSize[0] * screenSize[1])));
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return 1;
    }

    public static synchronized String createFileName(String str) {
        String format;
        synchronized (ImageUtils.class) {
            format = String.format("%s.%s", new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss-SSS").format(new Date()), str);
        }
        return format;
    }

    public static Bitmap getBPfromsdcard(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = ImageProcessor.a(options, 361, -1);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmapFromRGB888(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 3;
            iArr[i4] = Color.rgb(bArr[i5] & 255, bArr[i5 + 1] & 255, bArr[i5 + 2] & 255);
        }
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0023 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: android.os.ParcelFileDescriptor */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: android.os.ParcelFileDescriptor */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: android.os.ParcelFileDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap getBitmapFromUri(Context context, Uri uri, BitmapFactory.Options options) {
        ParcelFileDescriptor parcelFileDescriptor;
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        ParcelFileDescriptor parcelFileDescriptor2 = 0;
        try {
            try {
                try {
                    parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, r.f7664a);
                    if (parcelFileDescriptor != null) {
                        try {
                            bitmap = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (parcelFileDescriptor != null) {
                                parcelFileDescriptor.close();
                            }
                            return bitmap;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    parcelFileDescriptor2 = context;
                    if (parcelFileDescriptor2 != 0) {
                        try {
                            parcelFileDescriptor2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                parcelFileDescriptor = null;
            } catch (Throwable th2) {
                th = th2;
                if (parcelFileDescriptor2 != 0) {
                }
                throw th;
            }
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return bitmap;
    }

    public static int[] getScreenSize(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        }
        return null;
    }

    public static Bitmap rotateAReversalBitmap(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap rotateBitmap(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static String saveBitmapToCache(Context context, Bitmap bitmap, String str) {
        return saveBitmapToCache(context, bitmap, str, 100);
    }

    public static String saveBitmapToSdcard(Context context, Bitmap bitmap, String str) {
        String str2;
        if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            if (TextUtils.isEmpty(str)) {
                str = "jpg";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", "image/jpeg");
            ContentResolver contentResolver = context.getContentResolver();
            Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(insert, "w", null);
                if (openFileDescriptor != null) {
                    if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(openFileDescriptor.getFileDescriptor()))) {
                        str2 = insert.toString();
                        contentValues.clear();
                        contentResolver.update(insert, contentValues, null, null);
                        openFileDescriptor.close();
                        return str2;
                    }
                }
                str2 = "";
                contentValues.clear();
                contentResolver.update(insert, contentValues, null, null);
                openFileDescriptor.close();
                return str2;
            } catch (IOException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (TextUtils.isEmpty(str)) {
                str = createFileName("jpg");
            }
            File file = new File(externalStoragePublicDirectory, str);
            return bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file)) ? file.getAbsolutePath() : "";
        } catch (Throwable th) {
            LogUtil.e(TAG, "FileNotFoundException", th);
            return "";
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0049 -> B:39:0x005d). Please submit an issue!!! */
    public static String saveBitmapToCache(Context context, Bitmap bitmap, String str, int i) {
        String str2;
        File file;
        FileOutputStream fileOutputStream;
        str2 = "";
        if (i < 0 || i > 100) {
            return "";
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file2 = new File(context.getCacheDir().getAbsolutePath(), "image_cache");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (TextUtils.isEmpty(str)) {
                    str = createFileName("jpg");
                }
                file = new File(file2, str);
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            str2 = bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream) ? file.getAbsolutePath() : "";
            fileOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                LogUtil.e(TAG, "FileNotFoundException", th);
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return str2;
            } catch (Throwable th3) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th3;
            }
        }
        return str2;
    }
}
