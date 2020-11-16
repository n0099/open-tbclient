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
/* loaded from: classes12.dex */
class a {
    public String dQM;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int ooV = -14;
    public int ooW = -1;
    public long ooX = -1;
    public long ooY = -1;
    public long cwE = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void ebO() {
        this.ooY = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void ebP() {
        this.cwE = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dQM, Integer.valueOf(this.ooV), Integer.valueOf(this.ooW), Long.valueOf(this.ooX), Long.valueOf(this.mRequestTime), Long.valueOf(this.ooY), Long.valueOf(this.cwE)));
        turbonetEngine.a(this.mUrl, this.dQM, this.ooV, this.ooW, this.ooX, this.mRequestTime, this.ooY, this.cwE);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.ooV = -1;
        } else if (exc instanceof UnknownHostException) {
            this.ooV = -2;
        } else if (exc instanceof ConnectException) {
            this.ooV = -5;
        } else if (exc instanceof ProtocolException) {
            this.ooV = -3;
        } else if (exc instanceof BindException) {
            this.ooV = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.ooV = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.ooV = -9;
        } else if (exc instanceof RemoteException) {
            this.ooV = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.ooV = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.ooV = -7;
        } else if (exc instanceof SSLKeyException) {
            this.ooV = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.ooV = -11;
        } else {
            this.ooV = -14;
        }
    }
}
