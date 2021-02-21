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
/* loaded from: classes6.dex */
class a {
    public String mMethod;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int oQS = -14;
    public int mHttpStatusCode = -1;
    public long oQT = -1;
    public long oQU = -1;
    public long cFW = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void egs() {
        this.oQU = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void egt() {
        this.cFW = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.mMethod, Integer.valueOf(this.oQS), Integer.valueOf(this.mHttpStatusCode), Long.valueOf(this.oQT), Long.valueOf(this.mRequestTime), Long.valueOf(this.oQU), Long.valueOf(this.cFW)));
        turbonetEngine.a(this.mUrl, this.mMethod, this.oQS, this.mHttpStatusCode, this.oQT, this.mRequestTime, this.oQU, this.cFW);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.oQS = -1;
        } else if (exc instanceof UnknownHostException) {
            this.oQS = -2;
        } else if (exc instanceof ConnectException) {
            this.oQS = -5;
        } else if (exc instanceof ProtocolException) {
            this.oQS = -3;
        } else if (exc instanceof BindException) {
            this.oQS = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.oQS = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.oQS = -9;
        } else if (exc instanceof RemoteException) {
            this.oQS = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.oQS = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.oQS = -7;
        } else if (exc instanceof SSLKeyException) {
            this.oQS = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.oQS = -11;
        } else {
            this.oQS = -14;
        }
    }
}
