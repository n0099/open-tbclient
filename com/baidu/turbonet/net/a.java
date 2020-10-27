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
    public String dMC;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int oen = -14;
    public int oeo = -1;
    public long oep = -1;
    public long oeq = -1;
    public long csr = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void dYh() {
        this.oeq = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void dYi() {
        this.csr = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.dMC, Integer.valueOf(this.oen), Integer.valueOf(this.oeo), Long.valueOf(this.oep), Long.valueOf(this.mRequestTime), Long.valueOf(this.oeq), Long.valueOf(this.csr)));
        turbonetEngine.a(this.mUrl, this.dMC, this.oen, this.oeo, this.oep, this.mRequestTime, this.oeq, this.csr);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.oen = -1;
        } else if (exc instanceof UnknownHostException) {
            this.oen = -2;
        } else if (exc instanceof ConnectException) {
            this.oen = -5;
        } else if (exc instanceof ProtocolException) {
            this.oen = -3;
        } else if (exc instanceof BindException) {
            this.oen = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.oen = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.oen = -9;
        } else if (exc instanceof RemoteException) {
            this.oen = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.oen = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.oen = -7;
        } else if (exc instanceof SSLKeyException) {
            this.oen = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.oen = -11;
        } else {
            this.oen = -14;
        }
    }
}
