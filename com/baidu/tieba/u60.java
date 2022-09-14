package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.HttpMethod;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProxySelector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes6.dex */
public class u60 implements r60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p60 a;
    public s60 b;
    public o60 c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o60 a;

        public /* synthetic */ b(a aVar) {
            this();
        }

        public u60 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new u60(this, null) : (u60) invokeV.objValue;
        }

        public b c(o60 o60Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o60Var)) == null) {
                this.a = o60Var;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948162810, "Lcom/baidu/tieba/u60;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948162810, "Lcom/baidu/tieba/u60;");
        }
    }

    public /* synthetic */ u60(b bVar, a aVar) {
        this(bVar);
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new b(null) : (b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r60
    public p60 a(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) {
            HttpURLConnection a2 = this.b.a(request.url().url());
            boolean equals = "CronetHttpURLConnection".equals(a2.getClass().getSimpleName());
            int i = !equals ? 4 : 5;
            NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
            if (networkStatRecord != null) {
                networkStatRecord.netEngine = i;
            }
            if (request.getConnectionTimeout() > 0) {
                a2.setConnectTimeout(request.getConnectionTimeout());
            } else if (this.c.o() > 0) {
                a2.setConnectTimeout(this.c.o());
            }
            if (request.getReadTimeout() > 0) {
                a2.setReadTimeout(request.getReadTimeout());
            } else if (this.c.w() > 0) {
                a2.setReadTimeout(this.c.w());
            }
            a2.setInstanceFollowRedirects(request.isFollowRedirects());
            if ("https".equalsIgnoreCase(request.url().scheme()) && !equals) {
                SSLSocketFactory x = this.c.x();
                if (x != null) {
                    ((HttpsURLConnection) a2).setSSLSocketFactory(x);
                }
                HostnameVerifier q = this.c.q();
                if (q != null) {
                    ((HttpsURLConnection) a2).setHostnameVerifier(q);
                }
            }
            String method = request.method();
            a2.setRequestMethod(method);
            a2.setDoInput(true);
            boolean permitsRequestBody = HttpMethod.permitsRequestBody(method);
            a2.setDoOutput(permitsRequestBody);
            Headers headers = request.headers();
            if (permitsRequestBody) {
                long contentLength = request.body().contentLength();
                int i2 = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
                if (i2 < 0 && !"chunked".equals(headers.get("Transfer-Encoding"))) {
                    throw new IOException("content length < 0 but transfer-encoding is not set to chunked");
                }
                if (i2 < 0 && "chunked".equals(headers.get("Transfer-Encoding"))) {
                    a2.setChunkedStreamingMode(-1);
                } else {
                    a2.setFixedLengthStreamingMode((int) contentLength);
                }
            }
            int size = headers.size();
            for (int i3 = 0; i3 < size; i3++) {
                a2.setRequestProperty(headers.name(i3), headers.value(i3));
            }
            if (permitsRequestBody) {
                c(request, a2);
            }
            a2.connect();
            t60 t60Var = new t60(a2);
            this.a = t60Var;
            t60Var.t(i);
            return this.a;
        }
        return (p60) invokeL.objValue;
    }

    public final void c(Request request, HttpURLConnection httpURLConnection) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, httpURLConnection) == null) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    request.body().writeTo(outputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            } finally {
                Util.closeQuietly(outputStream);
            }
        }
    }

    public u60(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        o60 o60Var = bVar.a;
        this.c = o60Var;
        ProxySelector.setDefault(o60Var.v());
        this.b = this.c.r();
    }
}
