package com.baidu.tieba;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.tieba.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class p implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final j b;
    public final l c;
    public final f.a d;
    public volatile int e;
    public volatile int f;

    public p(j jVar, l lVar, f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, lVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.b = jVar;
        this.c = lVar;
        this.d = aVar;
        String k = k();
        this.a = k;
        if (TextUtils.isEmpty(k)) {
            this.a = getClass().getSimpleName();
        }
    }

    public abstract RandomAccessFile a(File file, String str, long j);

    public abstract Map<String, String> b(l lVar);

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0058 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.baidu.tieba.p, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        IOException e;
        ProtocolException e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        try {
            URL url = new URL(this.c.a);
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(4000);
                        httpURLConnection.setRequestMethod("GET");
                        h(b(this.c), httpURLConnection);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == i()) {
                            g(httpURLConnection);
                            httpURLConnection.disconnect();
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("UnSupported response code:");
                        sb.append(responseCode);
                        throw new DownloadException(108, sb.toString());
                    } catch (ProtocolException e3) {
                        e2 = e3;
                        throw new DownloadException(108, "Protocol error", e2);
                    } catch (IOException e4) {
                        e = e4;
                        throw new DownloadException(108, "IO error", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = url;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
            } catch (ProtocolException e5) {
                e2 = e5;
            } catch (IOException e6) {
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                if (r2 != 0) {
                }
                throw th;
            }
        } catch (MalformedURLException e7) {
            throw new DownloadException(108, "Bad url.", e7);
        }
    }

    public final void d(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.d) {
                        this.e = 106;
                        ((n) this.d).h();
                    }
                    return;
                case 107:
                    synchronized (this.d) {
                        this.e = 107;
                        ((n) this.d).g();
                    }
                    return;
                case 108:
                    synchronized (this.d) {
                        this.e = 108;
                        ((n) this.d).f(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void e(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, closeable) == null) || closeable == null) {
            return;
        }
        synchronized (p.class) {
            closeable.close();
        }
    }

    public final void f(InputStream inputStream, RandomAccessFile randomAccessFile) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, inputStream, randomAccessFile) == null) {
            byte[] bArr = new byte[8192];
            while (this.f != 107) {
                if (this.f != 106) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            return;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        long j = read;
                        this.c.d += j;
                        synchronized (this.d) {
                            this.b.d += j;
                            ((n) this.d).b(this.b.d, this.b.c);
                        }
                    } catch (IOException e) {
                        l(this.c);
                        throw new DownloadException(108, e);
                    }
                } else {
                    l(this.c);
                    throw new DownloadException(106, "Download paused!");
                }
            }
            throw new DownloadException(107, "Download canceled!");
        }
    }

    public final void g(HttpURLConnection httpURLConnection) {
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, httpURLConnection) != null) {
            return;
        }
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    long j = this.c.b + this.c.d;
                    try {
                        File file = this.b.b;
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        RandomAccessFile a = a(file, this.b.a, j);
                        f(inputStream, a);
                        try {
                            e(inputStream);
                            e(a);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e2) {
                        throw new DownloadException(108, "File occur IOException ", e2);
                    } catch (Exception e3) {
                        throw new DownloadException(108, "Occur Exception ", e3);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        e(inputStream);
                        e(null);
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                throw new DownloadException(108, "http get inputStream error", e5);
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public final void h(Map<String, String> map, URLConnection uRLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, map, uRLConnection) == null) || map == null) {
            return;
        }
        for (String str : map.keySet()) {
            uRLConnection.setRequestProperty(str, map.get(str));
        }
    }

    public abstract int i();

    public abstract void j(l lVar);

    public abstract String k();

    public abstract void l(l lVar);

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.e == 104 : invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Process.setThreadPriority(10);
            j(this.c);
            try {
                this.e = 104;
                c();
                synchronized (this.d) {
                    this.e = 105;
                    f.a aVar = this.d;
                    ((n) aVar).d(this.b.b.getAbsolutePath() + File.separator + this.b.a);
                }
            } catch (DownloadException e) {
                d(e);
            }
        }
    }
}
