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
    public String lKA;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int lKB = -14;
    public int lKC = -1;
    public long lKD = -1;
    public long lKE = -1;
    public long bBZ = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void djh() {
        this.lKE = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dji() {
        this.bBZ = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.lKA, Integer.valueOf(this.lKB), Integer.valueOf(this.lKC), Long.valueOf(this.lKD), Long.valueOf(this.mRequestTime), Long.valueOf(this.lKE), Long.valueOf(this.bBZ)));
        turbonetEngine.a(this.mUrl, this.lKA, this.lKB, this.lKC, this.lKD, this.mRequestTime, this.lKE, this.bBZ);
    }

    public void p(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.lKB = -1;
        } else if (exc instanceof UnknownHostException) {
            this.lKB = -2;
        } else if (exc instanceof ConnectException) {
            this.lKB = -5;
        } else if (exc instanceof ProtocolException) {
            this.lKB = -3;
        } else if (exc instanceof BindException) {
            this.lKB = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.lKB = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.lKB = -9;
        } else if (exc instanceof RemoteException) {
            this.lKB = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.lKB = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.lKB = -7;
        } else if (exc instanceof SSLKeyException) {
            this.lKB = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.lKB = -11;
        } else {
            this.lKB = -14;
        }
    }
}
