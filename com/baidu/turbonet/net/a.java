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
    public int oSX = -14;
    public int mHttpStatusCode = -1;
    public long oSY = -1;
    public long oSZ = -1;
    public long cHw = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void egA() {
        this.oSZ = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void egB() {
        this.cHw = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.mMethod, Integer.valueOf(this.oSX), Integer.valueOf(this.mHttpStatusCode), Long.valueOf(this.oSY), Long.valueOf(this.mRequestTime), Long.valueOf(this.oSZ), Long.valueOf(this.cHw)));
        turbonetEngine.a(this.mUrl, this.mMethod, this.oSX, this.mHttpStatusCode, this.oSY, this.mRequestTime, this.oSZ, this.cHw);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.oSX = -1;
        } else if (exc instanceof UnknownHostException) {
            this.oSX = -2;
        } else if (exc instanceof ConnectException) {
            this.oSX = -5;
        } else if (exc instanceof ProtocolException) {
            this.oSX = -3;
        } else if (exc instanceof BindException) {
            this.oSX = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.oSX = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.oSX = -9;
        } else if (exc instanceof RemoteException) {
            this.oSX = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.oSX = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.oSX = -7;
        } else if (exc instanceof SSLKeyException) {
            this.oSX = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.oSX = -11;
        } else {
            this.oSX = -14;
        }
    }
}
