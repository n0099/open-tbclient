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
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f5377a;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap f5378b;
    private static ExecutorService c;

    private a() {
        if (f5378b == null) {
            f5378b = new HashMap();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(String str) {
        InputStream inputStream;
        Bitmap bitmap;
        InputStream inputStream2 = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    if (decodeStream != null) {
                        try {
                            bitmap = Bitmap.createScaledBitmap(decodeStream, decodeStream.getWidth(), decodeStream.getHeight(), true);
                        } catch (Exception e) {
                            e = e;
                            bitmap = decodeStream;
                            c.d(e.toString());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return bitmap;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            bitmap = decodeStream;
                            System.gc();
                            c.d(e.toString());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            return bitmap;
                        }
                    } else {
                        bitmap = decodeStream;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    bitmap = null;
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    bitmap = null;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            inputStream = null;
            bitmap = null;
        } catch (OutOfMemoryError e10) {
            e = e10;
            inputStream = null;
            bitmap = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return bitmap;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f5377a == null) {
                f5377a = new a();
                if (c == null) {
                    c = Executors.newFixedThreadPool(1);
                }
            }
            aVar = f5377a;
        }
        return aVar;
    }

    public final Bitmap a(n nVar, String str) {
        Bitmap bitmap;
        Bitmap bitmap2;
        String c2 = k.c(str);
        if (!f5378b.containsKey(c2) || (bitmap2 = (Bitmap) ((SoftReference) f5378b.get(c2)).get()) == null) {
            try {
                bitmap = f.a(c2);
            } catch (OutOfMemoryError e) {
                System.gc();
                bitmap = null;
            }
            if (bitmap != null) {
                f5378b.put(c2, new SoftReference(bitmap));
                return bitmap;
            }
            c.execute(new b(this, str, c2, nVar));
            return null;
        }
        return bitmap2;
    }
}
