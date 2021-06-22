package com.baidubce.http;

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
/* loaded from: classes6.dex */
public class HttpClientFactory {

    /* loaded from: classes6.dex */
    public static class NTLMAuthenticator implements Authenticator {
        public final String domain;
        public final NTLMEngineImpl engine;
        public final String ntlmMsg1;
        public final String password;
        public final String username;
        public final String workstation;

        public NTLMAuthenticator(String str, String str2, String str3, String str4) {
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
    }

    public OkHttpClient createHttpClient(BceClientConfiguration bceClientConfiguration) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        OkHttpClient.Builder followSslRedirects = new OkHttpClient.Builder().protocols(arrayList).hostnameVerifier(new HostnameVerifier() { // from class: com.baidubce.http.HttpClientFactory.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
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
}
