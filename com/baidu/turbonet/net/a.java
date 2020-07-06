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
    public String dac;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int mAS = -14;
    public int mAT = -1;
    public long mAU = -1;
    public long mAV = -1;
    public long bPf = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dvv() {
        this.mAV = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dvw() {
        this.bPf = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dac, Integer.valueOf(this.mAS), Integer.valueOf(this.mAT), Long.valueOf(this.mAU), Long.valueOf(this.mRequestTime), Long.valueOf(this.mAV), Long.valueOf(this.bPf)));
        turbonetEngine.a(this.mUrl, this.dac, this.mAS, this.mAT, this.mAU, this.mRequestTime, this.mAV, this.bPf);
    }

    public void w(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.mAS = -1;
        } else if (exc instanceof UnknownHostException) {
            this.mAS = -2;
        } else if (exc instanceof ConnectException) {
            this.mAS = -5;
        } else if (exc instanceof ProtocolException) {
            this.mAS = -3;
        } else if (exc instanceof BindException) {
            this.mAS = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.mAS = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.mAS = -9;
        } else if (exc instanceof RemoteException) {
            this.mAS = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.mAS = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.mAS = -7;
        } else if (exc instanceof SSLKeyException) {
            this.mAS = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.mAS = -11;
        } else {
            this.mAS = -14;
        }
    }
}
