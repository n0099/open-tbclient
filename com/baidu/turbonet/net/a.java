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
    public int mAP = -14;
    public int mAQ = -1;
    public long mAR = -1;
    public long mAS = -1;
    public long bPf = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dvr() {
        this.mAS = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dvs() {
        this.bPf = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dac, Integer.valueOf(this.mAP), Integer.valueOf(this.mAQ), Long.valueOf(this.mAR), Long.valueOf(this.mRequestTime), Long.valueOf(this.mAS), Long.valueOf(this.bPf)));
        turbonetEngine.a(this.mUrl, this.dac, this.mAP, this.mAQ, this.mAR, this.mRequestTime, this.mAS, this.bPf);
    }

    public void w(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.mAP = -1;
        } else if (exc instanceof UnknownHostException) {
            this.mAP = -2;
        } else if (exc instanceof ConnectException) {
            this.mAP = -5;
        } else if (exc instanceof ProtocolException) {
            this.mAP = -3;
        } else if (exc instanceof BindException) {
            this.mAP = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.mAP = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.mAP = -9;
        } else if (exc instanceof RemoteException) {
            this.mAP = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.mAP = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.mAP = -7;
        } else if (exc instanceof SSLKeyException) {
            this.mAP = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.mAP = -11;
        } else {
            this.mAP = -14;
        }
    }
}
