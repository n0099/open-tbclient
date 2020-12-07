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
/* loaded from: classes14.dex */
class a {
    public String dXK;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int oDT = -14;
    public int oDU = -1;
    public long oDV = -1;
    public long oDW = -1;
    public long cDw = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void eht() {
        this.oDW = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void ehu() {
        this.cDw = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dXK, Integer.valueOf(this.oDT), Integer.valueOf(this.oDU), Long.valueOf(this.oDV), Long.valueOf(this.mRequestTime), Long.valueOf(this.oDW), Long.valueOf(this.cDw)));
        turbonetEngine.a(this.mUrl, this.dXK, this.oDT, this.oDU, this.oDV, this.mRequestTime, this.oDW, this.cDw);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.oDT = -1;
        } else if (exc instanceof UnknownHostException) {
            this.oDT = -2;
        } else if (exc instanceof ConnectException) {
            this.oDT = -5;
        } else if (exc instanceof ProtocolException) {
            this.oDT = -3;
        } else if (exc instanceof BindException) {
            this.oDT = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.oDT = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.oDT = -9;
        } else if (exc instanceof RemoteException) {
            this.oDT = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.oDT = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.oDT = -7;
        } else if (exc instanceof SSLKeyException) {
            this.oDT = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.oDT = -11;
        } else {
            this.oDT = -14;
        }
    }
}
