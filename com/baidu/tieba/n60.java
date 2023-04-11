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
/* loaded from: classes5.dex */
public class n60 implements k60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h60 a;
    public l60 b;
    public f60 c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947954273, "Lcom/baidu/tieba/n60;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947954273, "Lcom/baidu/tieba/n60;");
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public f60 a;

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

        public n60 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new n60(this, null);
            }
            return (n60) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b c(f60 f60Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f60Var)) == null) {
                this.a = f60Var;
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public n60(b bVar) {
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
        f60 f60Var = bVar.a;
        this.c = f60Var;
        ProxySelector.setDefault(f60Var.y());
        this.b = this.c.s();
    }

    public /* synthetic */ n60(b bVar, a aVar) {
        this(bVar);
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

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new b(null);
        }
        return (b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k60
    public h60 a(Request request) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) {
            HttpURLConnection openHttpURLConnection = this.b.openHttpURLConnection(request.url().url());
            boolean equals = "CronetHttpURLConnection".equals(openHttpURLConnection.getClass().getSimpleName());
            if (!equals) {
                i = 4;
            } else {
                i = 5;
            }
            NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
            if (networkStatRecord != null) {
                networkStatRecord.netEngine = i;
            }
            if (request.getConnectionTimeout() > 0) {
                openHttpURLConnection.setConnectTimeout(request.getConnectionTimeout());
            } else if (this.c.o() > 0) {
                openHttpURLConnection.setConnectTimeout(this.c.o());
            }
            if (request.getReadTimeout() > 0) {
                openHttpURLConnection.setReadTimeout(request.getReadTimeout());
            } else if (this.c.z() > 0) {
                openHttpURLConnection.setReadTimeout(this.c.z());
            }
            openHttpURLConnection.setInstanceFollowRedirects(request.isFollowRedirects());
            if ("https".equalsIgnoreCase(request.url().scheme()) && !equals) {
                SSLSocketFactory B = this.c.B();
                if (B != null) {
                    ((HttpsURLConnection) openHttpURLConnection).setSSLSocketFactory(B);
                }
                HostnameVerifier r = this.c.r();
                if (r != null) {
                    ((HttpsURLConnection) openHttpURLConnection).setHostnameVerifier(r);
                }
            }
            String method = request.method();
            openHttpURLConnection.setRequestMethod(method);
            openHttpURLConnection.setDoInput(true);
            boolean permitsRequestBody = HttpMethod.permitsRequestBody(method);
            openHttpURLConnection.setDoOutput(permitsRequestBody);
            Headers headers = request.headers();
            if (permitsRequestBody) {
                long contentLength = request.body().contentLength();
                int i2 = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
                if (i2 < 0 && !"chunked".equals(headers.get("Transfer-Encoding"))) {
                    throw new IOException("content length < 0 but transfer-encoding is not set to chunked");
                }
                if (i2 < 0 && "chunked".equals(headers.get("Transfer-Encoding"))) {
                    openHttpURLConnection.setChunkedStreamingMode(-1);
                } else {
                    openHttpURLConnection.setFixedLengthStreamingMode((int) contentLength);
                }
            }
            int size = headers.size();
            for (int i3 = 0; i3 < size; i3++) {
                openHttpURLConnection.setRequestProperty(headers.name(i3), headers.value(i3));
            }
            if (permitsRequestBody) {
                c(request, openHttpURLConnection);
            }
            openHttpURLConnection.connect();
            m60 m60Var = new m60(openHttpURLConnection);
            this.a = m60Var;
            m60Var.t(i);
            return this.a;
        }
        return (h60) invokeL.objValue;
    }
}
