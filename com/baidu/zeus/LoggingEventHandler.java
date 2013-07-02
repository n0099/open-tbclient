package com.baidu.zeus;
/* loaded from: classes.dex */
public class LoggingEventHandler implements EventHandler {
    public void requestSent() {
        HttpLog.v("LoggingEventHandler:requestSent()");
    }

    @Override // com.baidu.zeus.EventHandler
    public void status(int i, int i2, int i3, String str) {
    }

    @Override // com.baidu.zeus.EventHandler
    public void headers(Headers headers) {
    }

    public void locationChanged(String str, boolean z) {
    }

    @Override // com.baidu.zeus.EventHandler
    public void data(byte[] bArr, int i) {
    }

    @Override // com.baidu.zeus.EventHandler
    public void endData() {
    }

    @Override // com.baidu.zeus.EventHandler
    public void certificate(SslCertificate sslCertificate) {
    }

    @Override // com.baidu.zeus.EventHandler
    public void error(int i, String str) {
    }

    @Override // com.baidu.zeus.EventHandler
    public boolean handleSslErrorRequest(SslError sslError) {
        return false;
    }
}
