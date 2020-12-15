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
    public int oDV = -14;
    public int oDW = -1;
    public long oDX = -1;
    public long oDY = -1;
    public long cDw = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void ehu() {
        this.oDY = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void ehv() {
        this.cDw = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dXK, Integer.valueOf(this.oDV), Integer.valueOf(this.oDW), Long.valueOf(this.oDX), Long.valueOf(this.mRequestTime), Long.valueOf(this.oDY), Long.valueOf(this.cDw)));
        turbonetEngine.a(this.mUrl, this.dXK, this.oDV, this.oDW, this.oDX, this.mRequestTime, this.oDY, this.cDw);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.oDV = -1;
        } else if (exc instanceof UnknownHostException) {
            this.oDV = -2;
        } else if (exc instanceof ConnectException) {
            this.oDV = -5;
        } else if (exc instanceof ProtocolException) {
            this.oDV = -3;
        } else if (exc instanceof BindException) {
            this.oDV = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.oDV = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.oDV = -9;
        } else if (exc instanceof RemoteException) {
            this.oDV = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.oDV = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.oDV = -7;
        } else if (exc instanceof SSLKeyException) {
            this.oDV = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.oDV = -11;
        } else {
            this.oDV = -14;
        }
    }
}
