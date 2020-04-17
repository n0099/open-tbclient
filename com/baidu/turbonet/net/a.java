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
/* loaded from: classes.dex */
class a {
    public String lKw;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int lKx = -14;
    public int lKy = -1;
    public long lKz = -1;
    public long lKA = -1;
    public long bBU = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void djk() {
        this.lKA = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void djl() {
        this.bBU = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.lKw, Integer.valueOf(this.lKx), Integer.valueOf(this.lKy), Long.valueOf(this.lKz), Long.valueOf(this.mRequestTime), Long.valueOf(this.lKA), Long.valueOf(this.bBU)));
        turbonetEngine.a(this.mUrl, this.lKw, this.lKx, this.lKy, this.lKz, this.mRequestTime, this.lKA, this.bBU);
    }

    public void o(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.lKx = -1;
        } else if (exc instanceof UnknownHostException) {
            this.lKx = -2;
        } else if (exc instanceof ConnectException) {
            this.lKx = -5;
        } else if (exc instanceof ProtocolException) {
            this.lKx = -3;
        } else if (exc instanceof BindException) {
            this.lKx = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.lKx = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.lKx = -9;
        } else if (exc instanceof RemoteException) {
            this.lKx = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.lKx = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.lKx = -7;
        } else if (exc instanceof SSLKeyException) {
            this.lKx = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.lKx = -11;
        } else {
            this.lKx = -14;
        }
    }
}
