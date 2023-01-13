package com.baidu.tieba;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.tieba.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class j implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final f.a b;
    public volatile int c;
    public volatile long d;

    public j(String str, f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = aVar;
    }

    public final void a() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d("RtcDownSo", "execute connnection");
            this.d = System.currentTimeMillis();
            try {
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (ProtocolException e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    httpURLConnection.setConnectTimeout(4000);
                    httpURLConnection.setReadTimeout(4000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Range", "bytes=0-");
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        c(httpURLConnection, false);
                    } else if (responseCode == 206) {
                        c(httpURLConnection, true);
                    } else {
                        Log.d("RtcDownSo", "UnSupported response code:" + responseCode);
                        throw new DownloadException(108, "UnSupported response code:" + responseCode);
                    }
                    httpURLConnection.disconnect();
                } catch (ProtocolException e3) {
                    e = e3;
                    e.printStackTrace();
                    throw new DownloadException(108, "Protocol error", e);
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    throw new DownloadException(108, "IO error", e);
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (MalformedURLException e5) {
                throw new DownloadException(108, "Bad url.", e5);
            }
        }
    }

    public final void b(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.b) {
                        this.c = 106;
                        ((o) this.b).h();
                    }
                    return;
                case 107:
                    synchronized (this.b) {
                        this.c = 107;
                        ((o) this.b).e();
                    }
                    return;
                case 108:
                    synchronized (this.b) {
                        this.c = 108;
                        ((o) this.b).c(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    public final void c(HttpURLConnection httpURLConnection, boolean z) {
        long contentLength;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection, z) == null) {
            Log.d("RtcDownSo", "start parse response");
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            if (!TextUtils.isEmpty(headerField) && !headerField.equals("0") && !headerField.equals("-1")) {
                contentLength = Long.parseLong(headerField);
            } else {
                contentLength = httpURLConnection.getContentLength();
            }
            if (contentLength <= 0) {
                String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
                if (!TextUtils.isEmpty(headerField2) && !headerField2.equals("0") && !headerField2.equals("-1")) {
                    contentLength = Long.parseLong(headerField2);
                } else {
                    contentLength = httpURLConnection.getContentLength();
                }
                if (contentLength <= 0) {
                    throw new DownloadException(108, "length <= 0");
                }
            }
            if (!d()) {
                if (!e()) {
                    this.c = 103;
                    long currentTimeMillis = System.currentTimeMillis() - this.d;
                    o oVar = (o) this.b;
                    if (((j) oVar.i).d()) {
                        oVar.e();
                        return;
                    }
                    oVar.g = 103;
                    i iVar = oVar.b;
                    iVar.b.s(currentTimeMillis);
                    iVar.b.j(z);
                    iVar.b.r(103);
                    iVar.a.a(iVar.b);
                    oVar.h.b(z);
                    oVar.h.c = contentLength;
                    oVar.g = 104;
                    oVar.j.clear();
                    if (z) {
                        ArrayList<m> arrayList = new ArrayList();
                        int a = oVar.e.a();
                        for (int i = 0; i < a; i++) {
                            long j2 = contentLength / a;
                            long j3 = j2 * i;
                            if (i == a - 1) {
                                j = contentLength;
                            } else {
                                j = (j2 + j3) - 1;
                            }
                            arrayList.add(new m(i, oVar.d, oVar.a.c(), j3, j, 0L));
                        }
                        int i2 = 0;
                        for (m mVar : arrayList) {
                            i2 = (int) (i2 + mVar.d);
                        }
                        oVar.h.a(i2);
                        for (m mVar2 : arrayList) {
                            oVar.j.add(new l(oVar.h, mVar2, oVar));
                        }
                    } else {
                        oVar.j.add(new n(oVar.h, new m(0, oVar.d, oVar.a.c(), 0L, 0L, 0L), oVar));
                    }
                    for (g gVar : oVar.j) {
                        oVar.c.execute(gVar);
                    }
                    return;
                }
                throw new DownloadException(106, "Connection Paused!");
            }
            throw new DownloadException(107, "Connection Canceled!");
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c == 107) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c == 106) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Process.setThreadPriority(10);
            this.c = 102;
            o oVar = (o) this.b;
            oVar.g = 102;
            i iVar = oVar.b;
            iVar.b.r(102);
            iVar.a.a(iVar.b);
            try {
                a();
            } catch (DownloadException e) {
                b(e);
            }
        }
    }
}
