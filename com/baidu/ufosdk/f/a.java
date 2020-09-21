package com.baidu.ufosdk.f;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes21.dex */
public final class a {
    public static a a;
    private static HashMap b;
    private static ExecutorService c;

    private a() {
        if (b == null) {
            b = new HashMap();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x0001 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x002f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static Bitmap a(String str) {
        OutOfMemoryError outOfMemoryError;
        Bitmap bitmap;
        Exception exc;
        InputStream inputStream = 0;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    try {
                        inputStream = BitmapFactory.decodeStream(inputStream2);
                        if (inputStream != 0) {
                            try {
                                bitmap = Bitmap.createScaledBitmap(inputStream, inputStream.getWidth(), inputStream.getHeight(), true);
                            } catch (Exception e) {
                                bitmap = inputStream;
                                inputStream = inputStream2;
                                exc = e;
                                c.d(exc.toString());
                                if (inputStream != 0) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return bitmap;
                            } catch (OutOfMemoryError e3) {
                                bitmap = inputStream;
                                inputStream = inputStream2;
                                outOfMemoryError = e3;
                                System.gc();
                                c.d(outOfMemoryError.toString());
                                if (inputStream != 0) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                return bitmap;
                            }
                        } else {
                            bitmap = inputStream;
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    bitmap = null;
                    inputStream = inputStream2;
                    exc = e7;
                } catch (OutOfMemoryError e8) {
                    bitmap = null;
                    inputStream = inputStream2;
                    outOfMemoryError = e8;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e9) {
            exc = e9;
            bitmap = null;
        } catch (OutOfMemoryError e10) {
            outOfMemoryError = e10;
            bitmap = null;
        }
        return bitmap;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
                if (c == null) {
                    c = Executors.newFixedThreadPool(1);
                }
            }
            aVar = a;
        }
        return aVar;
    }

    public final Bitmap a(n nVar, String str) {
        Bitmap bitmap;
        Bitmap bitmap2;
        String c2 = k.c(str);
        if (!b.containsKey(c2) || (bitmap2 = (Bitmap) ((SoftReference) b.get(c2)).get()) == null) {
            try {
                bitmap = f.a(c2);
            } catch (OutOfMemoryError e) {
                System.gc();
                bitmap = null;
            }
            if (bitmap != null) {
                b.put(c2, new SoftReference(bitmap));
                return bitmap;
            }
            c.execute(new b(this, str, c2, nVar));
            return null;
        }
        return bitmap2;
    }
}
