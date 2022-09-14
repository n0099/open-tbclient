package com.baidu.ufosdk;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class m1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, SoftReference<Bitmap>> a;
    public static m1 b;
    public static ExecutorService c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ r1 c;
        public final /* synthetic */ m1 d;

        public a(m1 m1Var, String str, String str2, r1 r1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m1Var, str, str2, r1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = m1Var;
            this.a = str;
            this.b = str2;
            this.c = r1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Bitmap a = this.d.a(this.a);
                    if (a != null) {
                        m1.a.put(this.b, new SoftReference<>(a));
                        if (n1.b == null) {
                            n1.b = new n1();
                        }
                        n1.b.a(a, this.b);
                        this.c.obtainMessage(0, a).sendToTarget();
                        return;
                    }
                    this.c.obtainMessage(0, null).sendToTarget();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (OutOfMemoryError e2) {
                    e2.toString();
                    System.gc();
                }
            }
        }
    }

    public m1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (a == null) {
            a = new HashMap<>();
        }
    }

    public static synchronized m1 a() {
        InterceptResult invokeV;
        m1 m1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (m1.class) {
                if (b == null) {
                    b = new m1();
                    if (c == null) {
                        c = Executors.newFixedThreadPool(1);
                    }
                }
                m1Var = b;
            }
            return m1Var;
        }
        return (m1) invokeV.objValue;
    }

    public Bitmap a(r1 r1Var, String str) {
        InterceptResult invokeLL;
        Bitmap bitmap;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r1Var, str)) == null) {
            String b2 = b.b(str, false);
            if (!a.containsKey(b2) || (bitmap2 = a.get(b2).get()) == null) {
                try {
                    bitmap = n1.a(b2);
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    bitmap = null;
                }
                if (bitmap != null) {
                    a.put(b2, new SoftReference<>(bitmap));
                    return bitmap;
                }
                c.execute(new a(this, str, b2, r1Var));
                return null;
            }
            return bitmap2;
        }
        return (Bitmap) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0038 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: android.graphics.Bitmap */
    /* JADX WARN: Multi-variable type inference failed */
    public Bitmap a(String str) {
        InterceptResult invokeL;
        Throwable th;
        InputStream inputStream;
        Bitmap bitmap;
        IOException e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            InputStream inputStream2 = null;
            try {
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.connect();
                        inputStream = httpURLConnection.getInputStream();
                    } catch (IOException e2) {
                        bitmap = str;
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = null;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    str = null;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                bitmap = decodeStream;
                if (decodeStream != null) {
                    bitmap = Bitmap.createScaledBitmap(decodeStream, decodeStream.getWidth(), decodeStream.getHeight(), true);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return bitmap;
                    } catch (IOException e5) {
                        e = e5;
                        e.printStackTrace();
                        return bitmap;
                    }
                }
                return bitmap;
            } catch (Exception e6) {
                e = e6;
                inputStream2 = inputStream;
                str = null;
                e.toString();
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                return str;
            } catch (OutOfMemoryError e7) {
                e = e7;
                inputStream2 = inputStream;
                str = null;
                System.gc();
                e.toString();
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return (Bitmap) invokeL.objValue;
    }
}
