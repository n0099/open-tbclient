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
    public String cVs;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int mfa = -14;
    public int mfb = -1;
    public long mfc = -1;
    public long mfd = -1;
    public long bKr = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dqM() {
        this.mfd = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dqN() {
        this.bKr = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.cVs, Integer.valueOf(this.mfa), Integer.valueOf(this.mfb), Long.valueOf(this.mfc), Long.valueOf(this.mRequestTime), Long.valueOf(this.mfd), Long.valueOf(this.bKr)));
        turbonetEngine.a(this.mUrl, this.cVs, this.mfa, this.mfb, this.mfc, this.mRequestTime, this.mfd, this.bKr);
    }

    public void w(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.mfa = -1;
        } else if (exc instanceof UnknownHostException) {
            this.mfa = -2;
        } else if (exc instanceof ConnectException) {
            this.mfa = -5;
        } else if (exc instanceof ProtocolException) {
            this.mfa = -3;
        } else if (exc instanceof BindException) {
            this.mfa = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.mfa = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.mfa = -9;
        } else if (exc instanceof RemoteException) {
            this.mfa = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.mfa = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.mfa = -7;
        } else if (exc instanceof SSLKeyException) {
            this.mfa = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.mfa = -11;
        } else {
            this.mfa = -14;
        }
    }
}
