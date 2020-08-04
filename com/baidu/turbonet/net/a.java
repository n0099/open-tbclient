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
    public int mJd = -14;
    public int mJe = -1;
    public long mJf = -1;
    public long mJg = -1;
    public long bPW = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dyJ() {
        this.mJg = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dyK() {
        this.bPW = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dfN, Integer.valueOf(this.mJd), Integer.valueOf(this.mJe), Long.valueOf(this.mJf), Long.valueOf(this.mRequestTime), Long.valueOf(this.mJg), Long.valueOf(this.bPW)));
        turbonetEngine.a(this.mUrl, this.dfN, this.mJd, this.mJe, this.mJf, this.mRequestTime, this.mJg, this.bPW);
    }

    public void w(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.mJd = -1;
        } else if (exc instanceof UnknownHostException) {
            this.mJd = -2;
        } else if (exc instanceof ConnectException) {
            this.mJd = -5;
        } else if (exc instanceof ProtocolException) {
            this.mJd = -3;
        } else if (exc instanceof BindException) {
            this.mJd = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.mJd = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.mJd = -9;
        } else if (exc instanceof RemoteException) {
            this.mJd = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.mJd = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.mJd = -7;
        } else if (exc instanceof SSLKeyException) {
            this.mJd = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.mJd = -11;
        } else {
            this.mJd = -14;
        }
    }
}
