package com.baidu.tieba.util;

import android.net.Proxy;
import android.util.Log;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HeaderElement;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public class HttpClientFactory {
    private static final int DEFAULT_TIMEOUT_MILLIS = 30000;
    private static final String HTTP_USER_AGENT = "BAIDU_NETDISK";
    private static final int KEEP_ALIVE_DURATION_SECS = 25;
    private static final int KEEP_ALIVE_INTERVAL_SECS = 30;

    public static HttpClient makeHttpClient() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRoute() { // from class: com.baidu.tieba.util.HttpClientFactory.1
            public int getMaxForRoute(HttpRoute route) {
                return 6;
            }
        });
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 20);
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            SSLSocketFactory sf = new MySSLSocketFactory(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", sf, 443));
            ClientConnectionManager cm = new ClientConnectionManager(basicHttpParams, schemeRegistry);
            BasicHttpParams basicHttpParams2 = new BasicHttpParams();
            String host = Proxy.getDefaultHost();
            int port = Proxy.getDefaultPort();
            Log.i("hybrid", "host: " + host + ",port: " + port);
            if (host != null && port != -1) {
                Log.i("hybrid", "host: " + host + ",port: " + port);
                HttpHost httpHost = new HttpHost(host, port);
                basicHttpParams2.setParameter("http.route.default-proxy", httpHost);
            }
            HttpConnectionParams.setConnectionTimeout(basicHttpParams2, DEFAULT_TIMEOUT_MILLIS);
            HttpConnectionParams.setSoTimeout(basicHttpParams2, DEFAULT_TIMEOUT_MILLIS);
            HttpConnectionParams.setSocketBufferSize(basicHttpParams2, 16384);
            HttpProtocolParams.setVersion(basicHttpParams2, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setUserAgent(basicHttpParams2, HTTP_USER_AGENT);
            return new DefaultHttpClient(cm, basicHttpParams2) { // from class: com.baidu.tieba.util.HttpClientFactory.2
                protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
                    return new DBKeepAliveStrategy(null);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
            return null;
        } catch (KeyStoreException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        } catch (UnrecoverableKeyException e5) {
            e5.printStackTrace();
            return null;
        } catch (CertificateException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* loaded from: classes.dex */
    private static class DBKeepAliveStrategy implements ConnectionKeepAliveStrategy {
        private DBKeepAliveStrategy() {
        }

        /* synthetic */ DBKeepAliveStrategy(DBKeepAliveStrategy dBKeepAliveStrategy) {
            this();
        }

        public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
            long timeout = 25000;
            BasicHeaderElementIterator basicHeaderElementIterator = new BasicHeaderElementIterator(response.headerIterator("Keep-Alive"));
            while (basicHeaderElementIterator.hasNext()) {
                HeaderElement element = basicHeaderElementIterator.nextElement();
                String name = element.getName();
                String value = element.getValue();
                if (value != null && name.equalsIgnoreCase("timeout")) {
                    try {
                        timeout = Math.min(timeout, Long.parseLong(value) * 1000);
                    } catch (NumberFormatException e) {
                    }
                }
            }
            return timeout;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ClientConnectionManager extends ThreadSafeClientConnManager {
        public ClientConnectionManager(HttpParams params, SchemeRegistry schreg) {
            super(params, schreg);
        }

        public ClientConnectionRequest requestConnection(HttpRoute route, Object state) {
            IdleConnectionMonitorThread.ensureRunning(this, 25, HttpClientFactory.KEEP_ALIVE_INTERVAL_SECS);
            return super.requestConnection(route, state);
        }
    }

    /* loaded from: classes.dex */
    private static class IdleConnectionMonitorThread extends Thread {
        private static IdleConnectionMonitorThread thread = null;
        private final int checkIntervalSeconds;
        private final int idleTimeoutSeconds;
        private final ClientConnectionManager manager;

        public IdleConnectionMonitorThread(ClientConnectionManager manager, int idleTimeoutSeconds, int checkIntervalSeconds) {
            this.manager = manager;
            this.idleTimeoutSeconds = idleTimeoutSeconds;
            this.checkIntervalSeconds = checkIntervalSeconds;
        }

        public static synchronized void ensureRunning(ClientConnectionManager manager, int idleTimeoutSeconds, int checkIntervalSeconds) {
            synchronized (IdleConnectionMonitorThread.class) {
                if (thread == null) {
                    thread = new IdleConnectionMonitorThread(manager, idleTimeoutSeconds, checkIntervalSeconds);
                    thread.start();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    synchronized (this) {
                        wait(this.checkIntervalSeconds * 1000);
                    }
                    this.manager.closeExpiredConnections();
                    this.manager.closeIdleConnections(this.idleTimeoutSeconds, TimeUnit.SECONDS);
                    synchronized (IdleConnectionMonitorThread.class) {
                        if (this.manager.getConnectionsInPool() == 0) {
                            thread = null;
                            return;
                        }
                    }
                } catch (InterruptedException e) {
                    thread = null;
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class MySSLSocketFactory extends SSLSocketFactory {
        SSLContext sslContext;

        public MySSLSocketFactory(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(truststore);
            this.sslContext = SSLContext.getInstance("TLS");
            TrustManager tm = new X509TrustManager() { // from class: com.baidu.tieba.util.HttpClientFactory.MySSLSocketFactory.1
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            this.sslContext.init(null, new TrustManager[]{tm}, null);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
            return this.sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() throws IOException {
            return this.sslContext.getSocketFactory().createSocket();
        }
    }
}
