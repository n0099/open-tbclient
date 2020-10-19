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
/* loaded from: classes17.dex */
class a {
    public String dEf;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int nBM = -14;
    public int nBN = -1;
    public long nBO = -1;
    public long nBP = -1;
    public long cjQ = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dSp() {
        this.nBP = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dSq() {
        this.cjQ = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dEf, Integer.valueOf(this.nBM), Integer.valueOf(this.nBN), Long.valueOf(this.nBO), Long.valueOf(this.mRequestTime), Long.valueOf(this.nBP), Long.valueOf(this.cjQ)));
        turbonetEngine.a(this.mUrl, this.dEf, this.nBM, this.nBN, this.nBO, this.mRequestTime, this.nBP, this.cjQ);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.nBM = -1;
        } else if (exc instanceof UnknownHostException) {
            this.nBM = -2;
        } else if (exc instanceof ConnectException) {
            this.nBM = -5;
        } else if (exc instanceof ProtocolException) {
            this.nBM = -3;
        } else if (exc instanceof BindException) {
            this.nBM = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.nBM = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.nBM = -9;
        } else if (exc instanceof RemoteException) {
            this.nBM = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.nBM = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.nBM = -7;
        } else if (exc instanceof SSLKeyException) {
            this.nBM = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.nBM = -11;
        } else {
            this.nBM = -14;
        }
    }
}
