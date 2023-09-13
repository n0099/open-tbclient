package com.baidu.tts;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes9.dex */
public class g1 {
    public static /* synthetic */ Interceptable $ic;
    public static final HostnameVerifier f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public HttpURLConnection d;
    public Map<String, String> e;

    /* loaded from: classes9.dex */
    public static class a implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            X509Certificate[] x509CertificateArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                try {
                    String peerHost = sSLSession.getPeerHost();
                    for (X509Certificate x509Certificate : (X509Certificate[]) sSLSession.getPeerCertificates()) {
                        X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                        try {
                            x509Certificate.getSubjectAlternativeNames();
                        } catch (CertificateParsingException e) {
                            e.printStackTrace();
                        }
                        for (String str2 : subjectX500Principal.getName().split(",")) {
                            if (str2.startsWith("CN") && peerHost.equals(str)) {
                                return true;
                            }
                        }
                    }
                } catch (SSLPeerUnverifiedException e2) {
                    e2.printStackTrace();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1722255335, "Lcom/baidu/tts/g1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1722255335, "Lcom/baidu/tts/g1;");
                return;
            }
        }
        f = new a();
    }

    public g1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 5000;
        this.b = null;
        this.c = -1;
        this.d = null;
        this.e = null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0143 A[Catch: all -> 0x0105, TRY_ENTER, TryCatch #2 {all -> 0x0105, blocks: (B:5:0x0007, B:7:0x0018, B:9:0x002e, B:11:0x0032, B:12:0x003a, B:14:0x0040, B:15:0x0054, B:17:0x0058, B:19:0x007a, B:21:0x00a5, B:20:0x00a0, B:25:0x00fe, B:26:0x0104, B:8:0x0026, B:32:0x010c, B:39:0x011e, B:40:0x0128, B:45:0x0131, B:54:0x0143, B:55:0x014d), top: B:67:0x0007, inners: #3, #4, #6, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, String str2, String str3, m1 m1Var) {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, m1Var) == null) {
            try {
                try {
                    try {
                        try {
                            URL url = new URL(str);
                            if (url.getProtocol().equalsIgnoreCase("https")) {
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                                this.d = httpsURLConnection;
                                httpsURLConnection.setHostnameVerifier(f);
                            } else {
                                this.d = (HttpURLConnection) url.openConnection();
                            }
                            Map<String, String> map = this.e;
                            if (map != null) {
                                for (String str4 : map.keySet()) {
                                    this.d.setRequestProperty(str4, this.e.get(str4));
                                }
                            }
                        } catch (InterruptedIOException e) {
                            LoggerProxy.d("HttpClientUtil", e.toString());
                            httpURLConnection = this.d;
                            if (httpURLConnection == null) {
                                return;
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        e = e2;
                        if (m1Var != null) {
                            m1Var.a(this.c, null, this.b, null, e);
                        }
                        e.printStackTrace();
                        httpURLConnection = this.d;
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (IOException e3) {
                        if (m1Var != null) {
                            m1Var.a(this.c, null, this.b, null, e3);
                        }
                        e3.printStackTrace();
                        httpURLConnection = this.d;
                        if (httpURLConnection == null) {
                            return;
                        }
                    }
                } catch (MalformedURLException e4) {
                    e = e4;
                    if (m1Var != null) {
                    }
                    e.printStackTrace();
                    httpURLConnection = this.d;
                    if (httpURLConnection == null) {
                    }
                } catch (Exception e5) {
                    if (m1Var != null) {
                        m1Var.a(this.c, null, this.b, null, e5);
                    }
                    httpURLConnection = this.d;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
                if (!(m1Var instanceof l1)) {
                    m1Var.a = URI.create(str);
                    this.d.setRequestMethod(str3);
                    this.d.setConnectTimeout(this.a);
                    this.d.setReadTimeout(this.a);
                    if ("POST".equals(str3)) {
                        this.d.setDoInput(true);
                        this.d.setDoOutput(true);
                        OutputStream outputStream = this.d.getOutputStream();
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                        bufferedOutputStream.write(str2.getBytes());
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        outputStream.close();
                    } else {
                        this.d.setDoInput(true);
                    }
                    this.c = this.d.getResponseCode();
                    LoggerProxy.d("HttpClientUtil", "ResponseCode: " + this.c);
                    this.b = this.d.getContentType();
                    Map<String, List<String>> headerFields = this.d.getHeaderFields();
                    i1 i1Var = new i1();
                    i1Var.a = this.d.getContentLength();
                    i1Var.b = this.d.getInputStream();
                    i1Var.c = headerFields;
                    this.d.getContentEncoding();
                    i1Var.e = this.b;
                    i1Var.d = this.c;
                    m1Var.a(i1Var);
                    httpURLConnection = this.d;
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                    return;
                }
                ((l1) m1Var).getClass();
                throw null;
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection2 = this.d;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
    }
}
