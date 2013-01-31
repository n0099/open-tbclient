package com.baidu.zeus;

import android.content.Context;
import java.io.IOException;
import java.net.Socket;
import org.apache.http.HttpHost;
import org.apache.http.params.BasicHttpParams;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class HttpConnection extends Connection {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpConnection(Context context, HttpHost httpHost, RequestFeeder requestFeeder) {
        super(context, httpHost, requestFeeder);
    }

    @Override // com.baidu.zeus.Connection
    AndroidHttpClientConnection openConnection(Request request) {
        EventHandler eventHandler = request.getEventHandler();
        this.mCertificate = null;
        eventHandler.certificate(this.mCertificate);
        AndroidHttpClientConnection androidHttpClientConnection = new AndroidHttpClientConnection();
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        Socket socket = new Socket(this.mHost.getHostName(), this.mHost.getPort());
        basicHttpParams.setIntParameter("http.socket.buffer-size", 8192);
        androidHttpClientConnection.bind(socket, basicHttpParams);
        return androidHttpClientConnection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.zeus.Connection
    public void closeConnection() {
        try {
            if (this.mHttpClientConnection != null && this.mHttpClientConnection.isOpen()) {
                this.mHttpClientConnection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void restartConnection(boolean z) {
    }

    @Override // com.baidu.zeus.Connection
    String getScheme() {
        return "http";
    }
}
