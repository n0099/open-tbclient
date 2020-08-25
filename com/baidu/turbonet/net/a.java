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
/* loaded from: classes10.dex */
class a {
    public String dpW;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int nbY = -14;
    public int nbZ = -1;
    public long nca = -1;
    public long ncb = -1;
    public long bVw = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dKw() {
        this.ncb = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dKx() {
        this.bVw = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dpW, Integer.valueOf(this.nbY), Integer.valueOf(this.nbZ), Long.valueOf(this.nca), Long.valueOf(this.mRequestTime), Long.valueOf(this.ncb), Long.valueOf(this.bVw)));
        turbonetEngine.a(this.mUrl, this.dpW, this.nbY, this.nbZ, this.nca, this.mRequestTime, this.ncb, this.bVw);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.nbY = -1;
        } else if (exc instanceof UnknownHostException) {
            this.nbY = -2;
        } else if (exc instanceof ConnectException) {
            this.nbY = -5;
        } else if (exc instanceof ProtocolException) {
            this.nbY = -3;
        } else if (exc instanceof BindException) {
            this.nbY = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.nbY = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.nbY = -9;
        } else if (exc instanceof RemoteException) {
            this.nbY = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.nbY = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.nbY = -7;
        } else if (exc instanceof SSLKeyException) {
            this.nbY = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.nbY = -11;
        } else {
            this.nbY = -14;
        }
    }
}
