package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public final class s58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(final String filePath, final int i, final int i2, final q58 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{filePath, Integer.valueOf(i), Integer.valueOf(i2), callback}) == null) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ng.d(new Runnable() { // from class: com.baidu.tieba.p58
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        s58.b(filePath, i, i2, callback);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00a5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00a7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0139 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[Catch: all -> 0x0113, Exception -> 0x0117, TryCatch #10 {Exception -> 0x0117, all -> 0x0113, blocks: (B:7:0x0039, B:9:0x004f, B:19:0x0060, B:20:0x0066, B:23:0x0076, B:46:0x00c3, B:50:0x00d4, B:52:0x00db, B:53:0x00e4, B:15:0x0059), top: B:90:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v12, types: [int] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(final String filePath, int i, int i2, final q58 callback) {
        ByteArrayOutputStream byteArrayOutputStream;
        ?? r7;
        Object obj;
        Bitmap bitmap;
        BitmapFactory.Options options;
        int i3;
        int i4;
        Bitmap.CompressFormat compressFormat;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{filePath, Integer.valueOf(i), Integer.valueOf(i2), callback}) == null) {
            Intrinsics.checkNotNullParameter(filePath, "$filePath");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            final String str = filePath + "_backup";
            Bitmap bitmap2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    bitmap = BitmapFactory.decodeFile(filePath, options);
                    try {
                        i3 = options.outWidth;
                        i4 = options.outHeight;
                        compressFormat = Bitmap.CompressFormat.JPEG;
                        String str2 = options.outMimeType;
                        Intrinsics.checkNotNullExpressionValue(str2, "options.outMimeType");
                        if (StringsKt__StringsJVMKt.endsWith$default(str2, "png", false, 2, null)) {
                            compressFormat = Bitmap.CompressFormat.PNG;
                        }
                    } catch (Exception e) {
                        e = e;
                        obj = null;
                        bitmap2 = bitmap;
                        bitmap = obj;
                        r7 = obj;
                        try {
                            e.printStackTrace();
                            g(bitmap2, r7, byteArrayOutputStream, bitmap);
                            ng.e(new Runnable() { // from class: com.baidu.tieba.n58
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        s58.f(q58.this, filePath);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            th = th;
                            g(bitmap2, r7, byteArrayOutputStream, bitmap);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r7 = 0;
                        bitmap2 = bitmap;
                        bitmap = r7;
                        g(bitmap2, r7, byteArrayOutputStream, bitmap);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    obj = null;
                } catch (Throwable th3) {
                    th = th3;
                    r7 = 0;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                obj = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                r7 = 0;
            }
            try {
                try {
                    try {
                        if (i4 <= i && i4 <= i2) {
                            i5 = 1;
                            if (i5 < 1) {
                                options.inSampleSize = i5;
                                bitmap = BitmapFactory.decodeFile(filePath, options);
                            }
                            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                            r7 = byteArrayOutputStream.toByteArray().length;
                            if (r7 > 5242880) {
                                if (i5 < 1) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                    Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
                                    if (decodeStream.compress(compressFormat, 100, fileOutputStream)) {
                                        fileOutputStream.flush();
                                    }
                                    ng.e(new Runnable() { // from class: com.baidu.tieba.m58
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                s58.c(q58.this, str);
                                            }
                                        }
                                    });
                                    g(decodeStream, byteArrayInputStream, byteArrayOutputStream, fileOutputStream);
                                    g(decodeStream, byteArrayInputStream, byteArrayOutputStream, fileOutputStream);
                                    return;
                                }
                                ng.e(new Runnable() { // from class: com.baidu.tieba.l58
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            s58.d(q58.this, filePath);
                                        }
                                    }
                                });
                                g(bitmap, null, byteArrayOutputStream, null);
                                g(bitmap, null, byteArrayOutputStream, null);
                                return;
                            }
                            int i6 = 90;
                            while (byteArrayOutputStream.toByteArray().length > 5242880) {
                                byteArrayOutputStream.reset();
                                bitmap.compress(compressFormat, i6, byteArrayOutputStream);
                                i6 -= 10;
                            }
                            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            Bitmap decodeStream2 = BitmapFactory.decodeStream(byteArrayInputStream2);
                            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                            if (decodeStream2.compress(compressFormat, 100, fileOutputStream2)) {
                                fileOutputStream2.flush();
                            }
                            ng.e(new Runnable() { // from class: com.baidu.tieba.o58
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        s58.e(q58.this, str);
                                    }
                                }
                            });
                            g(decodeStream2, byteArrayInputStream2, byteArrayOutputStream, fileOutputStream2);
                            g(decodeStream2, byteArrayInputStream2, byteArrayOutputStream, fileOutputStream2);
                            return;
                        }
                        if (r7 > 5242880) {
                        }
                    } catch (Exception e4) {
                        e = e4;
                        bitmap = 0;
                        bitmap2 = 1;
                        r7 = r7;
                        bitmap = bitmap;
                        e.printStackTrace();
                        g(bitmap2, r7, byteArrayOutputStream, bitmap);
                        ng.e(new Runnable() { // from class: com.baidu.tieba.n58
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    s58.f(q58.this, filePath);
                                }
                            }
                        });
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        bitmap = 0;
                        bitmap2 = 1;
                        g(bitmap2, r7, byteArrayOutputStream, bitmap);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bitmap2 = 1;
                    r7 = r7;
                    bitmap = bitmap;
                    e.printStackTrace();
                    g(bitmap2, r7, byteArrayOutputStream, bitmap);
                    ng.e(new Runnable() { // from class: com.baidu.tieba.n58
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                s58.f(q58.this, filePath);
                            }
                        }
                    });
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    bitmap2 = 1;
                    g(bitmap2, r7, byteArrayOutputStream, bitmap);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                Bitmap bitmap3 = bitmap;
                bitmap = 0;
                bitmap2 = bitmap3;
                r7 = r7;
                e.printStackTrace();
                g(bitmap2, r7, byteArrayOutputStream, bitmap);
                ng.e(new Runnable() { // from class: com.baidu.tieba.n58
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            s58.f(q58.this, filePath);
                        }
                    }
                });
                return;
            } catch (Throwable th7) {
                th = th7;
                Bitmap bitmap4 = bitmap;
                bitmap = 0;
                bitmap2 = bitmap4;
                g(bitmap2, r7, byteArrayOutputStream, bitmap);
                throw th;
            }
            i5 = i / i3;
            int i7 = i2 / i4;
            if (i5 > i7) {
                i5 = i7;
            }
            if (i5 < 1) {
            }
            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
            r7 = byteArrayOutputStream.toByteArray().length;
        }
    }

    public static final void c(q58 callback, String toFilePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, callback, toFilePath) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(toFilePath, "$toFilePath");
            callback.onFinish(toFilePath);
        }
    }

    public static final void d(q58 callback, String filePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, callback, filePath) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(filePath, "$filePath");
            callback.onFinish(filePath);
        }
    }

    public static final void e(q58 callback, String toFilePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callback, toFilePath) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(toFilePath, "$toFilePath");
            callback.onFinish(toFilePath);
        }
    }

    public static final void f(q58 callback, String filePath) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, callback, filePath) == null) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(filePath, "$filePath");
            callback.onFinish(filePath);
        }
    }

    public static final void g(Bitmap bitmap, ByteArrayInputStream byteArrayInputStream, ByteArrayOutputStream byteArrayOutputStream, FileOutputStream fileOutputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, bitmap, byteArrayInputStream, byteArrayOutputStream, fileOutputStream) == null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
