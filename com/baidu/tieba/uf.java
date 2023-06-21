package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.BdHttpCancelException;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes8.dex */
public class uf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yf a;
    public boolean b;
    public HttpURLConnection c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public boolean j;
    public int k;
    public TimerTask l;
    public TimerTask m;
    public Timer n;

    /* loaded from: classes8.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uf a;

        public a(uf ufVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ufVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ufVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uf a;

        public b(uf ufVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ufVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ufVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    tg.f(this.a.c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpsURLConnection a;

        public c(uf ufVar, HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ufVar, httpsURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                String requestProperty = this.a.getRequestProperty("Host");
                if (requestProperty == null) {
                    requestProperty = this.a.getURL().getHost();
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318780, "Lcom/baidu/tieba/uf;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318780, "Lcom/baidu/tieba/uf;");
                return;
            }
        }
        System.setProperty("http.keepAlive", "false");
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            yf yfVar = this.a;
            if (yfVar != null && yfVar.c() != null) {
                this.a.c().a = true;
            }
            tg.f(this.c);
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return invokeV.longValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a.c().b != 200 && this.a.c().b != 206) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public uf(yf yfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yfVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = false;
        this.j = true;
        this.k = 0;
        this.l = new a(this);
        this.m = new b(this);
        this.n = new Timer();
        if (yfVar != null) {
            this.a = yfVar;
            this.b = ((tf) ServiceManager.getService(tf.a)).netABTest();
            return;
        }
        throw new NullPointerException("init HttpImpl's args context is null");
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.k = i;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.j = z;
        }
    }

    public final byte[] c(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            if (str != null && str.toLowerCase().contains("gzip")) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                si.c(byteArrayInputStream, byteArrayOutputStream);
                this.h = System.currentTimeMillis();
                return byteArrayOutputStream.toByteArray();
            }
            if (this.h == 0) {
                this.h = System.currentTimeMillis();
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r15v1 */
    public boolean d(String str, cg cgVar, int i, int i2, boolean z, xf xfVar, boolean z2) throws Exception {
        InterceptResult invokeCommon;
        xf xfVar2;
        FileOutputStream fileOutputStream;
        String k;
        URL m;
        File i3;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z3;
        URL url;
        int i4;
        int i5;
        boolean z4;
        String headerField;
        int indexOf;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, cgVar, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), xfVar, Boolean.valueOf(z2)})) == null) {
            if (xfVar == null) {
                xfVar2 = new xf();
            } else {
                xfVar2 = xfVar;
            }
            InputStream inputStream3 = null;
            try {
                k = this.a.b().k(true);
                xfVar2.s = k;
                m = m(k, false, xfVar2, null);
                this.c = g(m, i2, i);
            } catch (Throwable th) {
                th = th;
            }
            if (this.a.c().a) {
                this.g = System.currentTimeMillis();
                tg.c(null);
                tg.f(this.c);
                tg.d(null);
                return false;
            }
            if (z2) {
                try {
                    ri.k(str);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                i3 = new File(str);
            } else {
                i3 = ri.i(str);
            }
            if (i3 != null) {
                try {
                    long length = i3.length();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(i3, true);
                    try {
                        this.a.b().t(this.c);
                        this.c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.c.connect();
                        if (this.d <= 0) {
                            try {
                                this.d = System.currentTimeMillis();
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream3 = null;
                                fileOutputStream = fileOutputStream2;
                            }
                        }
                        this.e = System.currentTimeMillis();
                        int responseCode = this.c.getResponseCode();
                        this.f = System.currentTimeMillis();
                        if (responseCode == 302) {
                            url = this.c.getURL();
                            if (url != null) {
                                xfVar2.r = url.toString();
                            }
                            if (url != null) {
                                i6 = responseCode;
                                if (!TextUtils.equals(url.getProtocol(), m.getProtocol())) {
                                    tg.f(this.c);
                                    this.c = g(new URL(url.toString()), i2, i);
                                    this.a.b().t(this.c);
                                    this.c.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                                    this.c.connect();
                                    responseCode = this.c.getResponseCode();
                                    z3 = true;
                                }
                            } else {
                                i6 = responseCode;
                            }
                            responseCode = i6;
                            z3 = false;
                        } else {
                            z3 = false;
                            url = null;
                        }
                        this.a.c().b = responseCode;
                        String headerField2 = this.c.getHeaderField("Content-Range");
                        if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                            i4 = ug.e(headerField2.substring(indexOf + 1), 0);
                        } else {
                            i4 = 0;
                        }
                        if (i4 == 0 && this.a.c().b == 200 && (headerField = this.c.getHeaderField("Content-Length")) != null) {
                            i4 = ug.e(headerField, 0);
                        }
                        this.a.c().f = String.valueOf(i4);
                        if (!n()) {
                            String str2 = "";
                            if (responseCode == 302) {
                                if (z3) {
                                    str2 = "isReConn ";
                                }
                                str2 = str2 + "url=" + m + "-newUrl=" + url;
                            } else if (responseCode == 416) {
                                if (i4 > 0 && i4 == length) {
                                    this.g = System.currentTimeMillis();
                                    tg.c(null);
                                    tg.f(this.c);
                                    tg.d(fileOutputStream2);
                                    return false;
                                }
                                str2 = "fileLen=" + length + "-contentLen=" + i4;
                            }
                            throw new UnsupportedOperationException(str2);
                        } else if (this.c.getContentType() != null && this.c.getContentType().contains("text/vnd.wap.wml")) {
                            this.c.disconnect();
                            this.a.c().b = 0;
                            boolean d = d(str, cgVar, i, i2, z, xfVar2, z2);
                            this.g = System.currentTimeMillis();
                            tg.c(null);
                            tg.f(this.c);
                            tg.d(fileOutputStream2);
                            return d;
                        } else {
                            xfVar2.a = k.getBytes().length;
                            long length2 = this.c.getHeaderFields().toString().getBytes().length;
                            xfVar2.b = length2;
                            long j = i4;
                            xfVar2.b = length2 + j;
                            if (i4 != 0 && length >= j) {
                                this.g = System.currentTimeMillis();
                                this.g = System.currentTimeMillis();
                                tg.c(null);
                                tg.f(this.c);
                                tg.d(fileOutputStream2);
                                return true;
                            }
                            inputStream2 = null;
                            try {
                                inputStream2 = this.c.getInputStream();
                                byte[] bArr = new byte[1024];
                                if (i4 > 0) {
                                    i5 = i4 / 50;
                                } else {
                                    i5 = 0;
                                }
                                if (cgVar != null && length > 0) {
                                    cgVar.onProgress((int) length, i4);
                                }
                                int i7 = 0;
                                loop0: while (true) {
                                    int i8 = 0;
                                    while (!this.a.c().a) {
                                        int read = inputStream2.read(bArr);
                                        if (read == -1) {
                                            break loop0;
                                        }
                                        try {
                                            fileOutputStream2.write(bArr, 0, read);
                                            i7 += read;
                                            int i9 = i8 + read;
                                            if (cgVar != null && (i9 > i5 || i7 == i4)) {
                                                long j2 = j;
                                                cgVar.onProgress((int) (i7 + length), i4);
                                                j = j2;
                                            } else {
                                                i8 = i9;
                                                j = j;
                                            }
                                        } catch (Exception unused) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                    break loop0;
                                }
                                long j3 = j;
                                try {
                                    fileOutputStream2.flush();
                                    long j4 = i7;
                                    xfVar2.w = j4;
                                    xfVar2.x = length;
                                    xfVar2.y = j3;
                                    if (j4 + length >= j3) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    this.g = System.currentTimeMillis();
                                    tg.c(inputStream2);
                                    tg.f(this.c);
                                    tg.d(fileOutputStream2);
                                    return z4;
                                } catch (Exception unused2) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream3 = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                this.g = System.currentTimeMillis();
                                tg.c(inputStream3);
                                tg.f(this.c);
                                tg.d(fileOutputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream2 = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                }
            } else {
                inputStream = null;
                try {
                    throw new FileNotFoundException();
                } catch (Throwable th7) {
                    th = th7;
                }
            }
            inputStream3 = inputStream;
            fileOutputStream = inputStream3;
            this.g = System.currentTimeMillis();
            tg.c(inputStream3);
            tg.f(this.c);
            tg.d(fileOutputStream);
            throw th;
        }
        return invokeCommon.booleanValue;
    }

    public final HttpURLConnection f(URL url) {
        InterceptResult invokeL;
        String curMobileProxyHost;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, url)) == null) {
            HttpsURLConnection httpsURLConnection = null;
            try {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    return null;
                }
                if (BdNetTypeUtil.isMobileNet() && (curMobileProxyHost = BdNetTypeUtil.curMobileProxyHost()) != null && curMobileProxyHost.length() > 0) {
                    if (BdNetTypeUtil.isWap(curMobileProxyHost) && BdNetTypeUtil.isSupportWap()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(curMobileProxyHost);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.a.b().a("X-Online-Host", url.getHost());
                        } catch (Exception e) {
                            e = e;
                            httpsURLConnection = httpURLConnection;
                            e.printStackTrace();
                            return httpsURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(curMobileProxyHost, BdNetTypeUtil.curMobileProxyPort())));
                    }
                    httpsURLConnection = httpURLConnection;
                }
                if (httpsURLConnection == null) {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                if (this.i && url.getProtocol().equals("https")) {
                    HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                    httpsURLConnection2.setSSLSocketFactory(new dg(httpsURLConnection2));
                    httpsURLConnection2.setHostnameVerifier(new c(this, httpsURLConnection2));
                    return httpsURLConnection2;
                }
                return httpsURLConnection;
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (HttpURLConnection) invokeL.objValue;
        }
    }

    public final HttpURLConnection g(URL url, int i, int i2) throws SocketException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, url, i, i2)) == null) {
            HttpURLConnection f = f(url);
            if (f != null) {
                f.setConnectTimeout(i);
                f.setReadTimeout(i2);
                return f;
            }
            throw new SocketException();
        }
        return (HttpURLConnection) invokeLII.objValue;
    }

    public void k(boolean z, boolean z2, int i, int i2, xf xfVar, fg fgVar) throws Exception {
        IHttpNet egVar;
        URL d;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), xfVar, fgVar}) == null) {
            xfVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                if (!this.a.c().a) {
                    String f = this.a.b().f(z, xfVar);
                    xfVar.s = f;
                    URL m = m(f, z2, xfVar, fgVar);
                    if (!this.a.c().a) {
                        xfVar.j = -2;
                        if (this.b) {
                            egVar = new wf(this.a, IHttpNet.HttpNetType.GET);
                        } else {
                            egVar = new eg(this.a, IHttpNet.HttpNetType.GET);
                        }
                        IHttpNet iHttpNet2 = egVar;
                        iHttpNet2.e(m);
                        iHttpNet2.g(m, this.i);
                        xfVar.j = -3;
                        long currentTimeMillis = System.currentTimeMillis();
                        iHttpNet2.a(m, i2, i);
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            xfVar.g = new Date().getTime() - currentTimeMillis;
                            xfVar.j = -4;
                            iHttpNet2.connect();
                            if (this.d <= 0) {
                                this.d = System.currentTimeMillis();
                            }
                            this.e = System.currentTimeMillis();
                            xfVar.j = -5;
                            xfVar.c = (new Date().getTime() - currentTimeMillis) - xfVar.g;
                            if (!this.a.c().a) {
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                if (this.a.b().m() && this.n != null && this.k >= 0 && this.k < 3) {
                                    this.n.schedule(this.m, (this.k + 1) * 3000);
                                }
                                this.f = System.currentTimeMillis();
                                iHttpNet2.h();
                                xfVar.j = -8;
                                if (f.contains("tiebac.baidu.com") && (map = this.a.c().h) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                                    xfVar.t = list.get(0);
                                    xfVar.u = list.get(1);
                                }
                                if (this.a.c().b == 302 && (d = iHttpNet2.d()) != null) {
                                    xfVar.r = d.toString();
                                }
                                xfVar.i = this.a.c().b;
                                xfVar.b = iHttpNet2.b().toString().getBytes().length;
                                if (this.n != null) {
                                    this.n.cancel();
                                }
                                if (execute != null) {
                                    xfVar.b += execute.length;
                                    this.a.c().i = c(this.a.c().d, execute);
                                }
                                xfVar.j = -9;
                                xfVar.d = new Date().getTime() - currentTimeMillis;
                                Timer timer = this.n;
                                if (timer != null) {
                                    timer.cancel();
                                }
                                iHttpNet2.disconnect();
                                return;
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                Timer timer2 = this.n;
                if (timer2 != null) {
                    timer2.cancel();
                }
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    public void o(boolean z, boolean z2, int i, int i2, xf xfVar, fg fgVar) throws Exception {
        IHttpNet egVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), xfVar, fgVar}) == null) {
            xfVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String k = this.a.b().k(z);
                xfVar.s = k;
                URL m = m(k, z2, xfVar, fgVar);
                if (!this.a.c().a) {
                    xfVar.j = -2;
                    if (this.b) {
                        egVar = new wf(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    } else {
                        egVar = new eg(this.a, IHttpNet.HttpNetType.POST_BYTE);
                    }
                    IHttpNet iHttpNet2 = egVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.i);
                    xfVar.j = -3;
                    System.currentTimeMillis();
                    iHttpNet2.a(m, i2, i);
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            long time = new Date().getTime();
                            xfVar.g = new Date().getTime() - time;
                            xfVar.j = -4;
                            iHttpNet2.connect();
                            if (this.d <= 0) {
                                this.d = System.currentTimeMillis();
                            }
                            this.e = System.currentTimeMillis();
                            xfVar.j = -5;
                            xfVar.c = (new Date().getTime() - time) - xfVar.g;
                            if (!this.a.c().a) {
                                if (this.n != null) {
                                    this.n.schedule(this.l, 45000L);
                                }
                                xfVar.j = -6;
                                iHttpNet2.c();
                                xfVar.j = -7;
                                byte[] execute = iHttpNet2.execute();
                                this.a.c().a(iHttpNet2);
                                iHttpNet2.h();
                                this.f = System.currentTimeMillis();
                                if (!this.a.c().a) {
                                    xfVar.j = -8;
                                    xfVar.i = this.a.c().b;
                                    long length = iHttpNet2.b().toString().getBytes().length;
                                    xfVar.b = length;
                                    if (execute != null) {
                                        xfVar.b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().d, execute);
                                    }
                                    xfVar.d = new Date().getTime() - time;
                                    xfVar.j = -9;
                                    Timer timer = this.n;
                                    if (timer != null) {
                                        timer.cancel();
                                    }
                                    iHttpNet2.disconnect();
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                Timer timer2 = this.n;
                if (timer2 != null) {
                    timer2.cancel();
                }
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final URL m(String str, boolean z, xf xfVar, fg fgVar) throws Exception {
        InterceptResult invokeCommon;
        boolean z2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), xfVar, fgVar})) == null) {
            String str3 = "hiphotos.baidu.com";
            URL url = new URL(str);
            if (this.b) {
                return url;
            }
            if (!TextUtils.isEmpty(str) && this.j) {
                try {
                    String host = url.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if (!host.contains("hiphotos.baidu.com")) {
                            str3 = host;
                        }
                        BDHttpDnsResult r = BDHttpDns.h(BdBaseApplication.getInst().getApplicationContext()).r(str3, true);
                        if (r != null) {
                            xfVar.m = r.d();
                            xfVar.o = r.c();
                            ArrayList<String> b2 = r.b();
                            if (((sf) ServiceManager.getService(sf.a)).isIpv6() && z && b2 != null && b2.size() != 0) {
                                z2 = true;
                                if (b2 != null && b2.size() > 0) {
                                    xfVar.p = b2.toString();
                                    int size = this.k % b2.size();
                                    str2 = b2.get(size);
                                    if (!TextUtils.isEmpty(str2)) {
                                        if (z2) {
                                            str2 = PreferencesUtil.LEFT_MOUNT + str2 + PreferencesUtil.RIGHT_MOUNT;
                                            if (fgVar != null) {
                                                fgVar.e = true;
                                            }
                                        }
                                        if (!str2.startsWith("10.") || !url.getProtocol().equals("https")) {
                                            this.a.b().a("Host", str3);
                                            URL url2 = new URL(str.replaceFirst("://(.*)" + str3, "://" + str2));
                                            try {
                                                this.i = true;
                                                xfVar.q = size;
                                                xfVar.l = str2;
                                                xfVar.n = true;
                                                return url2;
                                            } catch (Exception e) {
                                                e = e;
                                                url = url2;
                                                BdLog.e(e);
                                                return url;
                                            }
                                        }
                                    }
                                }
                            }
                            z2 = false;
                            b2 = r.a();
                            if (b2 != null) {
                                xfVar.p = b2.toString();
                                int size2 = this.k % b2.size();
                                str2 = b2.get(size2);
                                if (!TextUtils.isEmpty(str2)) {
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return url;
        }
        return (URL) invokeCommon.objValue;
    }

    public void p(boolean z, boolean z2, int i, int i2, xf xfVar, fg fgVar) throws Exception {
        IHttpNet egVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), xfVar, fgVar}) == null) {
            xfVar.j = -1;
            IHttpNet iHttpNet = null;
            try {
                String k = this.a.b().k(z);
                xfVar.s = k;
                URL m = m(k, z2, xfVar, fgVar);
                if (!this.a.c().a) {
                    xfVar.j = -2;
                    if (this.b) {
                        egVar = new wf(this.a, IHttpNet.HttpNetType.POST_FORM);
                    } else {
                        egVar = new eg(this.a, IHttpNet.HttpNetType.POST_FORM);
                    }
                    IHttpNet iHttpNet2 = egVar;
                    iHttpNet2.e(m);
                    iHttpNet2.g(m, this.i);
                    iHttpNet2.a(m, i2, i);
                    xfVar.j = -3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!this.a.c().a) {
                        iHttpNet2.f();
                        if (!this.a.c().a) {
                            xfVar.g = System.currentTimeMillis() - currentTimeMillis;
                            xfVar.j = -4;
                            iHttpNet2.connect();
                            if (this.d <= 0) {
                                this.d = System.currentTimeMillis();
                            }
                            this.e = System.currentTimeMillis();
                            xfVar.j = -5;
                            xfVar.c = (System.currentTimeMillis() - currentTimeMillis) - xfVar.g;
                            if (!this.a.c().a) {
                                xfVar.j = -6;
                                xfVar.a = iHttpNet2.c();
                                xfVar.j = -7;
                                if (!this.a.c().a) {
                                    iHttpNet2.h();
                                    this.f = System.currentTimeMillis();
                                    xfVar.j = -8;
                                    byte[] execute = iHttpNet2.execute();
                                    this.g = System.currentTimeMillis();
                                    this.a.c().a(iHttpNet2);
                                    xfVar.i = this.a.c().b;
                                    long length = this.a.c().h.toString().getBytes().length;
                                    xfVar.b = length;
                                    if (execute != null) {
                                        xfVar.b = length + execute.length;
                                        this.a.c().j = execute.length;
                                        this.a.c().i = c(this.a.c().d, execute);
                                    }
                                    xfVar.d = new Date().getTime() - currentTimeMillis;
                                    xfVar.j = -9;
                                    iHttpNet2.disconnect();
                                    return;
                                }
                                throw new BdHttpCancelException();
                            }
                            throw new BdHttpCancelException();
                        }
                        throw new BdHttpCancelException();
                    }
                    throw new BdHttpCancelException();
                }
                throw new BdHttpCancelException();
            } catch (Throwable th) {
                if (0 != 0) {
                    iHttpNet.disconnect();
                }
                throw th;
            }
        }
    }
}
