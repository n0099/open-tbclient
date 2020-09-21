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
/* loaded from: classes15.dex */
class a {
    public String dsc;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int nmp = -14;
    public int nmq = -1;
    public long nmr = -1;
    public long nms = -1;
    public long bXB = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dOD() {
        this.nms = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dOE() {
        this.bXB = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dsc, Integer.valueOf(this.nmp), Integer.valueOf(this.nmq), Long.valueOf(this.nmr), Long.valueOf(this.mRequestTime), Long.valueOf(this.nms), Long.valueOf(this.bXB)));
        turbonetEngine.a(this.mUrl, this.dsc, this.nmp, this.nmq, this.nmr, this.mRequestTime, this.nms, this.bXB);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.nmp = -1;
        } else if (exc instanceof UnknownHostException) {
            this.nmp = -2;
        } else if (exc instanceof ConnectException) {
            this.nmp = -5;
        } else if (exc instanceof ProtocolException) {
            this.nmp = -3;
        } else if (exc instanceof BindException) {
            this.nmp = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.nmp = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.nmp = -9;
        } else if (exc instanceof RemoteException) {
            this.nmp = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.nmp = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.nmp = -7;
        } else if (exc instanceof SSLKeyException) {
            this.nmp = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.nmp = -11;
        } else {
            this.nmp = -14;
        }
    }
}
