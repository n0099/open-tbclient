package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.n;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<n> f6160a;

    /* renamed from: b  reason: collision with root package name */
    private int f6161b = 0;
    private boolean c;
    private boolean d;

    public b(List<n> list) {
        this.f6160a = list;
    }

    public n a(SSLSocket sSLSocket) throws IOException {
        n nVar;
        int i = this.f6161b;
        int size = this.f6160a.size();
        int i2 = i;
        while (true) {
            if (i2 >= size) {
                nVar = null;
                break;
            }
            nVar = this.f6160a.get(i2);
            if (!nVar.e(sSLSocket)) {
                i2++;
            } else {
                this.f6161b = i2 + 1;
                break;
            }
        }
        if (nVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.f6160a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.c = b(sSLSocket);
        com.bytedance.sdk.a.b.a.a.pir.a(nVar, sSLSocket, this.d);
        return nVar;
    }

    public boolean g(IOException iOException) {
        this.d = true;
        if (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return (iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException);
    }

    private boolean b(SSLSocket sSLSocket) {
        int i = this.f6161b;
        while (true) {
            int i2 = i;
            if (i2 < this.f6160a.size()) {
                if (!this.f6160a.get(i2).e(sSLSocket)) {
                    i = i2 + 1;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }
}
