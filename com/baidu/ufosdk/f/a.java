package com.baidu.ufosdk.f;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f23477a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap f23478b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f23479c;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (f23478b == null) {
            f23478b = new HashMap();
        }
    }

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Bitmap bitmap;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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
        return (Bitmap) invokeL.objValue;
    }

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (f23477a == null) {
                    f23477a = new a();
                    if (f23479c == null) {
                        f23479c = Executors.newFixedThreadPool(1);
                    }
                }
                aVar = f23477a;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final Bitmap a(n nVar, String str) {
        InterceptResult invokeLL;
        Bitmap bitmap;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, nVar, str)) == null) {
            String c2 = k.c(str);
            if (!f23478b.containsKey(c2) || (bitmap2 = (Bitmap) ((SoftReference) f23478b.get(c2)).get()) == null) {
                try {
                    bitmap = f.a(c2);
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    bitmap = null;
                }
                if (bitmap != null) {
                    f23478b.put(c2, new SoftReference(bitmap));
                    return bitmap;
                }
                f23479c.execute(new b(this, str, c2, nVar));
                return null;
            }
            return bitmap2;
        }
        return (Bitmap) invokeLL.objValue;
    }
}
