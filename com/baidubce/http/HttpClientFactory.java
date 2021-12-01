package com.baidubce.http;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.NTLMEngineImpl;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.apache.http.auth.AUTH;
import org.apache.http.client.params.AuthPolicy;
/* loaded from: classes12.dex */
public class HttpClientFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class NTLMAuthenticator implements Authenticator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String domain;
        public final NTLMEngineImpl engine;
        public final String ntlmMsg1;
        public final String password;
        public final String username;
        public final String workstation;

        public NTLMAuthenticator(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            NTLMEngineImpl nTLMEngineImpl = new NTLMEngineImpl();
            this.engine = nTLMEngineImpl;
            this.domain = str4;
            this.username = str;
            this.password = str2;
            this.workstation = str3;
            String str5 = null;
            try {
                str5 = nTLMEngineImpl.generateType1Msg(null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.ntlmMsg1 = str5;
        }

        @Override // okhttp3.Authenticator
        public Request authenticate(Route route, Response response) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, route, response)) == null) {
                List<String> values = response.headers().values(AUTH.WWW_AUTH);
                if (values.contains(AuthPolicy.NTLM)) {
                    Request.Builder newBuilder = response.request().newBuilder();
                    return newBuilder.header("Authorization", "NTLM " + this.ntlmMsg1).build();
                }
                String str = null;
                try {
                    str = this.engine.generateType3Msg(this.username, this.password, this.domain, this.workstation, values.get(0).substring(5));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Request.Builder newBuilder2 = response.request().newBuilder();
                return newBuilder2.header("Authorization", "NTLM " + str).build();
            }
            return (Request) invokeLL.objValue;
        }
    }

    public HttpClientFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public OkHttpClient createHttpClient(BceClientConfiguration bceClientConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bceClientConfiguration)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Protocol.HTTP_1_1);
            OkHttpClient.Builder followSslRedirects = new OkHttpClient.Builder().protocols(arrayList).hostnameVerifier(new HostnameVerifier(this) { // from class: com.baidubce.http.HttpClientFactory.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpClientFactory this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) ? HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession) : invokeLL.booleanValue;
                }
            }).retryOnConnectionFailure(false).cache(null).followRedirects(false).followSslRedirects(false);
            if (bceClientConfiguration != null) {
                Dispatcher dispatcher = new Dispatcher();
                dispatcher.setMaxRequests(bceClientConfiguration.getMaxConnections());
                followSslRedirects.protocols(arrayList).connectTimeout(bceClientConfiguration.getConnectionTimeoutInMillis(), TimeUnit.MILLISECONDS).writeTimeout(bceClientConfiguration.getSocketTimeoutInMillis(), TimeUnit.MILLISECONDS).readTimeout(bceClientConfiguration.getSocketTimeoutInMillis(), TimeUnit.MILLISECONDS).dispatcher(dispatcher).connectionPool(new ConnectionPool(bceClientConfiguration.getMaxConnections(), bceClientConfiguration.getKeepAliveDuration(), TimeUnit.SECONDS));
                String proxyHost = bceClientConfiguration.getProxyHost();
                int proxyPort = bceClientConfiguration.getProxyPort();
                if (proxyHost != null && proxyPort > 0) {
                    followSslRedirects.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
                    String proxyUsername = bceClientConfiguration.getProxyUsername();
                    String proxyPassword = bceClientConfiguration.getProxyPassword();
                    String proxyDomain = bceClientConfiguration.getProxyDomain();
                    String proxyWorkstation = bceClientConfiguration.getProxyWorkstation();
                    if (proxyUsername != null && proxyPassword != null) {
                        followSslRedirects.proxyAuthenticator(new NTLMAuthenticator(proxyUsername, proxyPassword, proxyDomain, proxyWorkstation));
                    }
                }
            }
            return followSslRedirects.build();
        }
        return (OkHttpClient) invokeL.objValue;
    }
}
