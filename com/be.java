package com;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
/* loaded from: classes.dex */
class be extends SSLSocketFactory {
    private SSLContext a;

    public be(KeyStore keyStore) {
        super(keyStore);
        bf bfVar = new bf(this);
        this.a = SSLContext.getInstance("TLS");
        this.a.init(null, new TrustManager[]{bfVar}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return this.a.getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.a.getSocketFactory().createSocket(socket, str, i, z);
    }
}
