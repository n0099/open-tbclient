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
    public int mdQ = -14;
    public int mdR = -1;
    public long mdS = -1;
    public long mdT = -1;
    public long bKr = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dqy() {
        this.mdT = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dqz() {
        this.bKr = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.cVs, Integer.valueOf(this.mdQ), Integer.valueOf(this.mdR), Long.valueOf(this.mdS), Long.valueOf(this.mRequestTime), Long.valueOf(this.mdT), Long.valueOf(this.bKr)));
        turbonetEngine.a(this.mUrl, this.cVs, this.mdQ, this.mdR, this.mdS, this.mRequestTime, this.mdT, this.bKr);
    }

    public void w(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.mdQ = -1;
        } else if (exc instanceof UnknownHostException) {
            this.mdQ = -2;
        } else if (exc instanceof ConnectException) {
            this.mdQ = -5;
        } else if (exc instanceof ProtocolException) {
            this.mdQ = -3;
        } else if (exc instanceof BindException) {
            this.mdQ = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.mdQ = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.mdQ = -9;
        } else if (exc instanceof RemoteException) {
            this.mdQ = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.mdQ = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.mdQ = -7;
        } else if (exc instanceof SSLKeyException) {
            this.mdQ = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.mdQ = -11;
        } else {
            this.mdQ = -14;
        }
    }
}
