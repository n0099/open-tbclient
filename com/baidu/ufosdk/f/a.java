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
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f22623a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap f22624b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f22625c;

    public a() {
        if (f22624b == null) {
            f22624b = new HashMap();
        }
    }

    public static Bitmap a(String str) {
        Bitmap bitmap;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Exception e2) {
            e = e2;
            bitmap = null;
        } catch (OutOfMemoryError e3) {
            e = e3;
            bitmap = null;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            if (decodeStream != null) {
                decodeStream = Bitmap.createScaledBitmap(decodeStream, decodeStream.getWidth(), decodeStream.getHeight(), true);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return decodeStream;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return decodeStream;
                }
            }
            return decodeStream;
        } catch (Exception e5) {
            e = e5;
            inputStream2 = inputStream;
            bitmap = null;
            c.d(e.toString());
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    return bitmap;
                }
            }
            return bitmap;
        } catch (OutOfMemoryError e7) {
            e = e7;
            inputStream2 = inputStream;
            bitmap = null;
            System.gc();
            c.d(e.toString());
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e8) {
                    e = e8;
                    e.printStackTrace();
                    return bitmap;
                }
            }
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f22623a == null) {
                f22623a = new a();
                if (f22625c == null) {
                    f22625c = Executors.newFixedThreadPool(1);
                }
            }
            aVar = f22623a;
        }
        return aVar;
    }

    public final Bitmap a(n nVar, String str) {
        Bitmap bitmap;
        Bitmap bitmap2;
        String c2 = k.c(str);
        if (!f22624b.containsKey(c2) || (bitmap2 = (Bitmap) ((SoftReference) f22624b.get(c2)).get()) == null) {
            try {
                bitmap = f.a(c2);
            } catch (OutOfMemoryError unused) {
                System.gc();
                bitmap = null;
            }
            if (bitmap != null) {
                f22624b.put(c2, new SoftReference(bitmap));
                return bitmap;
            }
            f22625c.execute(new b(this, str, c2, nVar));
            return null;
        }
        return bitmap2;
    }
}
