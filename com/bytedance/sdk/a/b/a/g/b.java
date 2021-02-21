package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b extends e {

    /* renamed from: a  reason: collision with root package name */
    final Method f5936a;

    /* renamed from: b  reason: collision with root package name */
    final Method f5937b;

    b(Method method, Method method2) {
        this.f5936a = method;
        this.f5937b = method2;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = a(list);
            this.f5936a.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.a.b.a.c.f("unable to set ssl parameters", e);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String c(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f5937b.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.a.b.a.c.f("unable to get selected protocols", e);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    public static b epG() {
        try {
            return new b(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}
