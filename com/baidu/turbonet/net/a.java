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
    public String dSu;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int ons = -14;
    public int ont = -1;
    public long onu = -1;
    public long onv = -1;
    public long cyo = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void ebP() {
        this.onv = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void ebQ() {
        this.cyo = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dSu, Integer.valueOf(this.ons), Integer.valueOf(this.ont), Long.valueOf(this.onu), Long.valueOf(this.mRequestTime), Long.valueOf(this.onv), Long.valueOf(this.cyo)));
        turbonetEngine.a(this.mUrl, this.dSu, this.ons, this.ont, this.onu, this.mRequestTime, this.onv, this.cyo);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.ons = -1;
        } else if (exc instanceof UnknownHostException) {
            this.ons = -2;
        } else if (exc instanceof ConnectException) {
            this.ons = -5;
        } else if (exc instanceof ProtocolException) {
            this.ons = -3;
        } else if (exc instanceof BindException) {
            this.ons = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.ons = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.ons = -9;
        } else if (exc instanceof RemoteException) {
            this.ons = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.ons = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.ons = -7;
        } else if (exc instanceof SSLKeyException) {
            this.ons = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.ons = -11;
        } else {
            this.ons = -14;
        }
    }
}
