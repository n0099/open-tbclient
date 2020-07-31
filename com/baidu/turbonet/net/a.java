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
/* loaded from: classes19.dex */
class a {
    public String dfN;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int mJb = -14;
    public int mJc = -1;
    public long mJd = -1;
    public long mJe = -1;
    public long bPW = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dyI() {
        this.mJe = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dyJ() {
        this.bPW = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dfN, Integer.valueOf(this.mJb), Integer.valueOf(this.mJc), Long.valueOf(this.mJd), Long.valueOf(this.mRequestTime), Long.valueOf(this.mJe), Long.valueOf(this.bPW)));
        turbonetEngine.a(this.mUrl, this.dfN, this.mJb, this.mJc, this.mJd, this.mRequestTime, this.mJe, this.bPW);
    }

    public void w(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.mJb = -1;
        } else if (exc instanceof UnknownHostException) {
            this.mJb = -2;
        } else if (exc instanceof ConnectException) {
            this.mJb = -5;
        } else if (exc instanceof ProtocolException) {
            this.mJb = -3;
        } else if (exc instanceof BindException) {
            this.mJb = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.mJb = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.mJb = -9;
        } else if (exc instanceof RemoteException) {
            this.mJb = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.mJb = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.mJb = -7;
        } else if (exc instanceof SSLKeyException) {
            this.mJb = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.mJb = -11;
        } else {
            this.mJb = -14;
        }
    }
}
