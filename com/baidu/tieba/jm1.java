package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;
@SuppressLint({"TrulyRandom"})
/* loaded from: classes5.dex */
public class jm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public byte[] b;
    public HttpURLConnection c;
    public String d;
    public String e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;

    public jm1(Context context, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new byte[1024];
        this.f = 10000;
        this.g = 10000;
        this.h = false;
        this.i = false;
        this.a = context;
    }

    public final InputStream a(byte[] bArr, Map<String, String> map, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, bArr, map, str)) == null) {
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    if (cn1.h(this.a) == 0) {
                        return null;
                    }
                    HttpURLConnection c = c(map);
                    this.c = c;
                    if (c == null) {
                        return null;
                    }
                    if (bArr == null) {
                        if ("gzip".equalsIgnoreCase(c.getContentEncoding())) {
                            this.h = true;
                        } else {
                            this.h = false;
                        }
                        this.c.getResponseCode();
                        return this.c.getInputStream();
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(this.c.getOutputStream());
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.flush();
                        if ("gzip".equalsIgnoreCase(this.c.getContentEncoding())) {
                            this.h = true;
                        } else {
                            this.h = false;
                        }
                        this.c.getResponseCode();
                        InputStream inputStream = this.c.getInputStream();
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable th) {
                            cn1.d(th);
                        }
                        return inputStream;
                    } catch (Exception e) {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable th3) {
                                cn1.d(th3);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            return (InputStream) invokeLLL.objValue;
        }
    }

    public String b(String str, byte[] bArr, Map<String, String> map) {
        InterceptResult invokeLLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, map)) == null) {
            d("POST", str);
            try {
                inputStream = a(bArr, map, str);
                if (inputStream == null) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    HttpURLConnection httpURLConnection = this.c;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        this.c = null;
                    }
                    return null;
                }
                try {
                    String f = f(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    HttpURLConnection httpURLConnection2 = this.c;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        this.c = null;
                    }
                    return f;
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    HttpURLConnection httpURLConnection3 = this.c;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                        this.c = null;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } else {
            return (String) invokeLLL.objValue;
        }
    }

    public final HttpURLConnection c(Map<String, String> map) {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            String str = null;
            if (this.i || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) {
                return null;
            }
            if (!this.d.equals("POST") && !this.d.equals("GET")) {
                this.d = "POST";
            }
            URL url = new URL(this.e);
            int i = 80;
            if (2 != cn1.h(this.a)) {
                if (Build.VERSION.SDK_INT >= 13) {
                    str = System.getProperties().getProperty("http.proxyHost");
                    String property = System.getProperties().getProperty("http.proxyPort");
                    if (!TextUtils.isEmpty(property)) {
                        try {
                            i = Integer.parseInt(property);
                        } catch (Throwable unused) {
                            i = -1;
                        }
                    }
                    i = -1;
                } else {
                    str = Proxy.getHost(this.a);
                    i = Proxy.getPort(this.a);
                }
            }
            if (str != null && i > 0) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (this.e.startsWith("https")) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            }
            httpURLConnection.setRequestMethod(this.d);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(this.d)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(this.f);
            httpURLConnection.setReadTimeout(this.g);
            httpURLConnection.setRequestProperty("x-device-id", hn1.b(dn1.a(this.a)));
            httpURLConnection.setRequestProperty("Pragma", "no-cache");
            String str2 = ll1.b;
            String e = cn1.e(this.a);
            httpURLConnection.setRequestProperty("User-Agent", "sso/" + str2 + "/" + e + "/1.2.1");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage());
            StringBuilder sb = new StringBuilder();
            sb.append("sso/");
            sb.append("1.2.1");
            httpURLConnection.setRequestProperty("x-sdk-ver", sb.toString());
            httpURLConnection.setRequestProperty("x-plu-ver", "sso/1.2.1");
            httpURLConnection.setRequestProperty("x-app-ver", this.a.getPackageName() + "/" + cn1.e(this.a));
            httpURLConnection.setRequestProperty("x-auth-ver", "5");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    httpURLConnection.setRequestProperty(str3, map.get(str3));
                }
            }
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.d = str;
            this.e = str2;
        }
    }

    public final byte[] e(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(this.b);
                if (read != -1) {
                    byteArrayOutputStream.write(this.b, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    public final String f(InputStream inputStream) {
        InterceptResult invokeL;
        byte[] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, inputStream)) == null) {
            if (inputStream == null || (e = e(inputStream)) == null) {
                return null;
            }
            if (this.h) {
                e = fn1.d(e);
            }
            if (e == null) {
                return "";
            }
            return new String(e);
        }
        return (String) invokeL.objValue;
    }
}
