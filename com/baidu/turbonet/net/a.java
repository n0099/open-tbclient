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
/* loaded from: classes4.dex */
class a {
    public String mMethod;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int oGj = -14;
    public int mHttpStatusCode = -1;
    public long oGk = -1;
    public long oGl = -1;
    public long cDA = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void edS() {
        this.oGl = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void edT() {
        this.cDA = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.mMethod, Integer.valueOf(this.oGj), Integer.valueOf(this.mHttpStatusCode), Long.valueOf(this.oGk), Long.valueOf(this.mRequestTime), Long.valueOf(this.oGl), Long.valueOf(this.cDA)));
        turbonetEngine.a(this.mUrl, this.mMethod, this.oGj, this.mHttpStatusCode, this.oGk, this.mRequestTime, this.oGl, this.cDA);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.oGj = -1;
        } else if (exc instanceof UnknownHostException) {
            this.oGj = -2;
        } else if (exc instanceof ConnectException) {
            this.oGj = -5;
        } else if (exc instanceof ProtocolException) {
            this.oGj = -3;
        } else if (exc instanceof BindException) {
            this.oGj = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.oGj = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.oGj = -9;
        } else if (exc instanceof RemoteException) {
            this.oGj = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.oGj = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.oGj = -7;
        } else if (exc instanceof SSLKeyException) {
            this.oGj = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.oGj = -11;
        } else {
            this.oGj = -14;
        }
    }
}
