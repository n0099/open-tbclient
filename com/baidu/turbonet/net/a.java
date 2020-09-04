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
    public String dqa;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int ncq = -14;
    public int ncr = -1;
    public long ncs = -1;
    public long nct = -1;
    public long bVA = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dKF() {
        this.nct = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dKG() {
        this.bVA = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dqa, Integer.valueOf(this.ncq), Integer.valueOf(this.ncr), Long.valueOf(this.ncs), Long.valueOf(this.mRequestTime), Long.valueOf(this.nct), Long.valueOf(this.bVA)));
        turbonetEngine.a(this.mUrl, this.dqa, this.ncq, this.ncr, this.ncs, this.mRequestTime, this.nct, this.bVA);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.ncq = -1;
        } else if (exc instanceof UnknownHostException) {
            this.ncq = -2;
        } else if (exc instanceof ConnectException) {
            this.ncq = -5;
        } else if (exc instanceof ProtocolException) {
            this.ncq = -3;
        } else if (exc instanceof BindException) {
            this.ncq = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.ncq = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.ncq = -9;
        } else if (exc instanceof RemoteException) {
            this.ncq = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.ncq = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.ncq = -7;
        } else if (exc instanceof SSLKeyException) {
            this.ncq = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.ncq = -11;
        } else {
            this.ncq = -14;
        }
    }
}
