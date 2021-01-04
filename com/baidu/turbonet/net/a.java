package com.baidu.turbonet.net;

import android.os.RemoteException;
import android.util.Log;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
/* loaded from: classes5.dex */
class a {
    public String mMethod;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int oKO = -14;
    public int mHttpStatusCode = -1;
    public long oKP = -1;
    public long oKQ = -1;
    public long cIm = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void ehJ() {
        this.oKQ = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void ehK() {
        this.cIm = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.mMethod, Integer.valueOf(this.oKO), Integer.valueOf(this.mHttpStatusCode), Long.valueOf(this.oKP), Long.valueOf(this.mRequestTime), Long.valueOf(this.oKQ), Long.valueOf(this.cIm)));
        turbonetEngine.a(this.mUrl, this.mMethod, this.oKO, this.mHttpStatusCode, this.oKP, this.mRequestTime, this.oKQ, this.cIm);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.oKO = -1;
        } else if (exc instanceof UnknownHostException) {
            this.oKO = -2;
        } else if (exc instanceof ConnectException) {
            this.oKO = -5;
        } else if (exc instanceof ProtocolException) {
            this.oKO = -3;
        } else if (exc instanceof BindException) {
            this.oKO = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.oKO = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.oKO = -9;
        } else if (exc instanceof RemoteException) {
            this.oKO = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.oKO = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.oKO = -7;
        } else if (exc instanceof SSLKeyException) {
            this.oKO = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.oKO = -11;
        } else {
            this.oKO = -14;
        }
    }
}
