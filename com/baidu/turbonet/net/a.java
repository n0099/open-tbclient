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
/* loaded from: classes6.dex */
class a {
    public String mMethod;
    public long mRequestTime;
    public long mStartTime;
    public String mUrl;
    public int oQs = -14;
    public int mHttpStatusCode = -1;
    public long oQt = -1;
    public long oQu = -1;
    public long cFW = -1;

    public a(String str) {
        this.mRequestTime = -1L;
        this.mStartTime = -1L;
        this.mUrl = str;
        this.mStartTime = System.nanoTime() / 1000;
        this.mRequestTime = System.currentTimeMillis();
    }

    public void egk() {
        this.oQu = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void egl() {
        this.cFW = (System.nanoTime() / 1000) - this.mStartTime;
    }

    public void a(TurbonetEngine turbonetEngine) {
        Log.v("HTTPMetrics", String.format("url:%s, method:%s, netCode:%d, httpCode:%d, bytesReceived:%d, requestTime:%d, firstByteTime:%d, durationTime:%d", this.mUrl, this.mMethod, Integer.valueOf(this.oQs), Integer.valueOf(this.mHttpStatusCode), Long.valueOf(this.oQt), Long.valueOf(this.mRequestTime), Long.valueOf(this.oQu), Long.valueOf(this.cFW)));
        turbonetEngine.a(this.mUrl, this.mMethod, this.oQs, this.mHttpStatusCode, this.oQt, this.mRequestTime, this.oQu, this.cFW);
    }

    public void A(Exception exc) {
        if (exc instanceof SocketTimeoutException) {
            this.oQs = -1;
        } else if (exc instanceof UnknownHostException) {
            this.oQs = -2;
        } else if (exc instanceof ConnectException) {
            this.oQs = -5;
        } else if (exc instanceof ProtocolException) {
            this.oQs = -3;
        } else if (exc instanceof BindException) {
            this.oQs = -4;
        } else if (exc instanceof SSLHandshakeException) {
            this.oQs = -8;
        } else if (exc instanceof SSLProtocolException) {
            this.oQs = -9;
        } else if (exc instanceof RemoteException) {
            this.oQs = -13;
        } else if (exc instanceof NoRouteToHostException) {
            this.oQs = -6;
        } else if (exc instanceof PortUnreachableException) {
            this.oQs = -7;
        } else if (exc instanceof SSLKeyException) {
            this.oQs = -10;
        } else if (exc instanceof SSLPeerUnverifiedException) {
            this.oQs = -11;
        } else {
            this.oQs = -14;
        }
    }
}
